package com.eion.restapi.controller;

import com.eion.restapi.payload.PostDto;
import com.eion.restapi.payload.PostResponse;
import com.eion.restapi.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.eion.restapi.utils.AppConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    @PostMapping

    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostDto> createPosts(@Valid @RequestBody PostDto postDto) {


    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PostDto> createPosts(@Valid @RequestBody PostDto postDto) {

    private ResponseEntity<PostDto> createPosts(@Valid @RequestBody PostDto postDto) {


        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE ,required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return new ResponseEntity<>(postService.getAllPost(pageNo,pageSize,sortBy,sortDir), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Long id) {
        return new ResponseEntity<>(postService.updatePost(postDto, id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("post with :"+id+" Deleted",HttpStatus.OK);
    }
}
