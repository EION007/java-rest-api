package com.eion.restapi.controller;

import com.eion.restapi.payload.PostDto;
import com.eion.restapi.payload.PostResponse;
import com.eion.restapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.eion.restapi.utils.AppConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    @PostMapping
    private ResponseEntity<PostDto> createPosts(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE ,required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return new ResponseEntity<>(postService.getAllPost(pageNo,pageSize,sortBy,sortDir), HttpStatus.OK);
    }

    @GetMapping("{id}")
    private ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long id) {
        return new ResponseEntity<>(postService.updatePost(postDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("post with :"+id+" Deleted",HttpStatus.OK);
    }
}
