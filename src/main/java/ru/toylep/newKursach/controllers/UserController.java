package ru.toylep.newKursach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.toylep.newKursach.DAO.UserDAO;
import ru.toylep.newKursach.DAO.mappers.UserMapper;
import ru.toylep.newKursach.models.UserModel;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @PostMapping("/reg")
    public String addUser(@RequestBody UserModel userModel){
        userDAO.addUser(userModel);
        return "хехех";
    }
    @GetMapping("/find")
    public List<UserModel> findAll(){
        return userDAO.showAllUsers();
    }
    //Дописать метод авторизации
    @PostMapping("/sign_up")
    public Object loginUser(@RequestBody String login,
                               @RequestBody String password){
       return userDAO.loginUser(login,password);
    }

    @PostMapping("/my_space")
    public UserModel personalPage(@RequestBody UserModel me){
         return userDAO.getMyPersonalPage(me);
    }



    //hello bogdan
    //Дописать метод перехода в личный кабинет
        //Дописать вывод своих комментов и своих описаний
        //Дописать редактирование своего аккаунта


}
