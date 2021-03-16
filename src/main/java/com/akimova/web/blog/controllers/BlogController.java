package com.akimova.web.blog.controllers;

import com.akimova.web.blog.models.Post;
import com.akimova.web.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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

    //Получаем данные когда переходим на страницу
    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    //Получаем данные из формы при нажатии кнопки
    @PostMapping("/blog/add")
    //Получение новых параметров
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        // сохранение и добавление объекта в базу данных
        postRepository.save(post);
        //в таблицу Post добавлена новая статья//

        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    //PathVariable берет динамическое значение из url-адреса
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";

        }

        Optional<Post> post= postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        //из класса optional переводим всё в класс arraylist
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }
}
