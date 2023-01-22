package com.eion.restapi.service;

import com.eion.restapi.payload.PostDto;
import com.eion.restapi.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deletePost(Long id);

    List<PostDto> getPostByCategory(Long categoryId);
}
