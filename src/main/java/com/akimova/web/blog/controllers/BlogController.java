package com.akimova.web.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //помечает что класс - контроллер
public class BlogController {

    //Отслеживает URL-адрес
    @GetMapping("/blog")
    // ПРинимаем обьект на основе класса Model
    public String blogMain(Model model){
        return "blog-main";
    }
}
