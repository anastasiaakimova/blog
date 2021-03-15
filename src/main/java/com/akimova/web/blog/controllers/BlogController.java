package com.akimova.web.blog.controllers;

import com.akimova.web.blog.models.Post;
import com.akimova.web.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //помечает что класс - контроллер
public class BlogController {
    //создание переменной которая ссылается на репозиторий
    @Autowired
    private PostRepository postRepository;

    //Отслеживает URL-адрес
    @GetMapping("/blog")
    // ПРинимаем обьект на основе класса Model
    public String blogMain(Model model) {
        //перечисление, массив данных в котором содержатся все значения полученные из определенной таблицы в бд
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
}
