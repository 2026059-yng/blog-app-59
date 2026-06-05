package com.example.blog_app.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

//時間を取得
import java.time.LocalDateTime;
import java.util.List;

import com.example.blog_app.model.Blog;
import com.example.blog_app.model.BlogForm;
import com.example.blog_app.repository.BlogAppRepository;

@Service
public class BlogService {

    @Autowired
    private BlogAppRepository blogAppRepository;

    // ブログ一覧の取得
    public List<Blog> getBlogList() {
        return blogAppRepository.findAll();
    }

    // ブログを投稿
    public void addBlogContent(BlogForm blogForm, String username) {

        Blog blog = new Blog();

        // 画面から送られてきたタイトルと内容をセットする
        blog.setTitle(blogForm.getTitle());
        blog.setContent(blogForm.getContent());

        if ("user".equals(username)) {
            blog.setUserId(1);
        }

        // システム側で生成する「現在日時」をセットする
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());

        blogAppRepository.save(blog);
    }

}
