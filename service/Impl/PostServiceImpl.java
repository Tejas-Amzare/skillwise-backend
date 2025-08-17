package com.skillwise.backend.service.Impl;

import com.skillwise.backend.dto.PostRequestDto;
import com.skillwise.backend.dto.PostResponseDto;
import com.skillwise.backend.model.Post;
import com.skillwise.backend.model.User;
import com.skillwise.backend.repository.PostRepository;
import com.skillwise.backend.repository.UserRepository;
import com.skillwise.backend.service.PostServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostServices {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Override
    public PostResponseDto createPost(PostRequestDto request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(email)
                .user(user) // set user entity
                .build();

        Post saved = postRepository.save(post);
        log.info("Post created successfully with ID {}" , saved.getId());

        return mapToDto(saved);
    }

    @Override
    public List<PostResponseDto> getAllPost() {
        return postRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        return mapToDto(post);
    }

    @Override
    public PostResponseDto updatedPost(Long id, PostResponseDto request, String email) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (!post.getAuthor().equals(email)) {
            throw new RuntimeException("You are not authorized to update this post");
        }

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        Post updated = postRepository.save(post);
        return mapToDto(updated);
    }

    @Override
    public String deletedPost(Long id, String email) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        if (!post.getAuthor().equals(email)) {
            throw new RuntimeException("You are not authorized to delete this post");
        }

        postRepository.delete(post);
        return "Post deleted successfully";
    }

    private PostResponseDto mapToDto(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getUser().getFullName())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdateAt())
                .build();
    }

    // ---------------- page ---------------


    public Page<PostResponseDto> getAllPostPaged(int page, int size,String sortBy, String sortDir) {
        Sort sort  = sortDir.equalsIgnoreCase("asc")?
                Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return postRepository.findAllByOrderByCreatedAtDesc(pageable)
                                .map(this::mapToDto);
    }

    @Override
    public Page<PostResponseDto> searchPosts(String keyword, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return postRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword, pageable)
                .map(this::mapToDto);
    }

    @Override
    public Page<PostResponseDto> getMyPosts(String email, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        return postRepository.findByAuthor(email, pageable).map(this::mapToDto);
    }
}