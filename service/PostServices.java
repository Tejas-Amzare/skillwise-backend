package com.skillwise.backend.service;

import com.skillwise.backend.dto.PostRequestDto;
import com.skillwise.backend.dto.PostResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostServices {

    PostResponseDto createPost(PostRequestDto request, String email);

    List<PostResponseDto> getAllPost();

    PostResponseDto getPostById(Long id);

    PostResponseDto updatedPost(Long id , PostResponseDto request, String email);

    String deletedPost(Long id, String email);

    Page<PostResponseDto> getAllPostPaged(int page, int size ,String sortBy, String sortDir);

    Page<PostResponseDto> searchPosts(String keyword, int page, int size, String sortBy);

    Page<PostResponseDto> getMyPosts(String email, int page, int size, String sortBy);
}
