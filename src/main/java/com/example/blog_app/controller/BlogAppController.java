package com.example.blog_app.controller;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.blog_app.service.BlogService;
import com.example.blog_app.model.BlogForm;

import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class BlogAppController {

    @Autowired
    private BlogService blogService;

    // ブログの一覧を取得
    @GetMapping("/")
    public String blogs(Model model) {
        model.addAttribute("blogList", blogService.getBlogList());
        return "blog";
    }

    // ブログを投稿
    @PostMapping("blog/post")
    public String postMethodName(@ModelAttribute BlogForm blogForm, HttpSession session) {

        // ログインチェック（ユーザー名を取り出す）
        String loginUser = (String) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        // ★引数に loginUser を追加して、誰が投稿したかをServiceに伝える
        blogService.addBlogContent(blogForm, loginUser);
        return "redirect:/";
    }

}
