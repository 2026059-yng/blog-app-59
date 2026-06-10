package com.example.blog_app.controller;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.blog_app.service.BlogService;
import com.example.blog_app.model.Blog;
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

    @GetMapping("/blog/new")
    public String showCreateForm(HttpSession session) {
        // 投稿画面を開くときにもログインチェックをかける
        String loginUser = (String) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }
        return "blog-create"; // blog-create.htmlを表示
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

    //ブログの詳細を表示する
    @GetMapping("/blog/{id}")
    public String blogDetail(@PathVariable int id, Model model) {
        // URLの{id}の部分を @PathVariable で受け取ってServiceに渡す
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog-detail"; // blog-detail.htmlを表示
    }

}
