package com.akimova.web.blog.models;

import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;

    // fetch - параметр, который определяет как данные значения будут подгружаться относительно основной сущности
    //EAGER - сразу же при запросе пользователья подгружает роли
    //LAZY  - подгрузка ролей только когда пользователь обратится к этому полю
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    //Описывает что данное поле хранится в отдельной таблице для которой мы не описывали мэпинг
    // создаем таблицу "user_role" для набора ролей которая соединяется с текущей таблицей через "user_id"
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
