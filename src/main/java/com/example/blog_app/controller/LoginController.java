package com.example.blog_app.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // login.htmlを表示する
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) { // 引数にHttpSessionを指定するとSpringが自動で渡す

        // 簡易的なパスワードチェック
        if ("user".equals(username) && "password".equals(password)) {
            // セッションに「loginUser」という名前でユーザー名を保存
            session.setAttribute("loginUser", username);
            return "redirect:/";
        }
        // 失敗したらログイン画面に戻す
        return "login";
    }
}
