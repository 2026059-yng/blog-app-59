package com.example.blog_app.repository;

import org.springframework.stereotype.Repository;
import com.example.blog_app.model.Blog;

import org.springframework.jdbc.core.simple.JdbcClient;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogAppRepository {

    private final JdbcClient jdbcClient;

    // ブログ一覧の取得
    public List<Blog> findAll() {
        String sql = "SELECT id, user_id AS userId, title, post_content AS content, created_at AS createdAt, updated_at AS updatedAt FROM posts";
        return jdbcClient.sql(sql).query(Blog.class).list();
    }

    public void save(Blog blog) {

        String sql = "INSERT INTO posts (user_id, title, post_content) VALUES (?, ?, ?)";

        jdbcClient.sql(sql)
                .param(blog.getUserId())
                .param(blog.getTitle())
                .param(blog.getContent())
                .update();
    }

}
