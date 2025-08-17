package com.skillwise.backend.repository;

import com.skillwise.backend.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
    List<Post> findByUserEmail(String email);

    @Override
    Page<Post> findAll(Pageable pageable);
    Page<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(
            String titleKeyword, String contentKeyword, Pageable pageable);
    Page<Post> findByAuthor(String author, Pageable pageable);
    Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);


}
