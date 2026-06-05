package com.example.blog_app;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.simple.JdbcClient;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogAppRepository {

    private final JdbcClient jdbcClient;

    //ブログ一覧の取得
    public List<Blog> findAll(){
        return jdbcClient.sql("")
        .query(Blog.class)
        .list();
    }
    
}
