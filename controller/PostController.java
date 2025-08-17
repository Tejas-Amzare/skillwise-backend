package com.skillwise.backend.controller;

import com.skillwise.backend.dto.PostRequestDto;
import com.skillwise.backend.dto.PostResponseDto;
import com.skillwise.backend.service.PostServices;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostServices postServices;

    @Operation(summary = "  - Create a new Post :) - " , description ="Authenticated users can create a post by providing title and content" )
    @PostMapping("/createPost")
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto request, Authentication authentication){
       String email = authentication.getName();
       log.debug("Request to create posy by {}",email);
       PostResponseDto response = postServices.createPost(request,email);
       return ResponseEntity.ok(response);
    }


    @Operation(summary = "  - Get All Post -")
    @GetMapping("/getAllPost")
    public ResponseEntity<List<PostResponseDto>> getAllPost(){
        List<PostResponseDto> posts = postServices.getAllPost();
        return ResponseEntity.ok(posts);
    }


    @Operation(summary = "  - Get Post By Id -")
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id){
        PostResponseDto posts = postServices.getPostById(id);
        return ResponseEntity.ok(posts);
    }


    @Operation(summary = "  -Update Post By Id -")
    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> updatedPost(@PathVariable Long id, @RequestBody PostResponseDto request ,Authentication authentication ){
        String email = authentication.getName();
        PostResponseDto update = postServices.updatedPost(id ,request,email);
       return ResponseEntity.ok(update);
    }

    @Operation(summary = "  - Delete Posy by Id -")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedPost(@PathVariable Long id ,Authentication authentication){
    String email = authentication.getName();
        String result = postServices.deletedPost(id , email);
        return ResponseEntity.ok(result);
    }
//---------------  page  --------------------

    @Operation(summary = "  - Get Post Using Keyword -")
    @GetMapping("/getAll")
    public ResponseEntity<Page<PostResponseDto>> getAllPost(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {
        return ResponseEntity.ok(postServices.getAllPostPaged(page, size,sortBy,sortDir));
    }

    @Operation(summary = "  - Search Post Using Keyword -")
    @GetMapping("/search")
    public ResponseEntity<Page<PostResponseDto>> searchPosts(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(postServices.searchPosts(keyword, page, size, sortBy));
    }

    @Operation(summary = "  - Get All Newest Post -")
    @GetMapping("/my-posts")
    public ResponseEntity<Page<PostResponseDto>> getMyPosts(
            Authentication authentication,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        String email = authentication.getName();
        return ResponseEntity.ok(postServices.getMyPosts(email, page, size, sortBy));
    }
}
