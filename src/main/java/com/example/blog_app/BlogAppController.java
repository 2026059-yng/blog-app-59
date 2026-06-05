package com.example.blog_app;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
public class BlogAppController {

    private final BlogAppRepository blogAppRepository;

    @GetMapping("/")
    public String blogs(Model model) {
        model.addAttribute("blogList", blogAppRepository.findAll());
        return "/";
    }
    

}
