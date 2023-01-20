package com.eion.restapi.repository;

import com.eion.restapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
   List<Comment> findByPostId(long post_id);

}
