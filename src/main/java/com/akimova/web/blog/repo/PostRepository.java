package com.akimova.web.blog.repo;

//необходимые функции для добавить удалить обновить и получить записи из табл
import com.akimova.web.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post, Long>{
}
