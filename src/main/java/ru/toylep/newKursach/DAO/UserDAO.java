package ru.toylep.newKursach.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.toylep.newKursach.DAO.mappers.UserMapper;
import ru.toylep.newKursach.models.UserModel;

import java.sql.SQLException;
import java.util.List;

public class UserDAO {

   private final JdbcTemplate jdbcTemplate;
@Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public String addUser(String group,String name,String lastName,String login,String password){
    jdbcTemplate.update("INSERT INTO public.\"UsersInfo\"(groups, name, \"lastName\", login, password) VALUES ( ?, ?, ?, ?, ?) ",group,name,lastName,login,password);
    return "Регистрация успешна";
    }
    public void addUser(UserModel um){
     jdbcTemplate.update("INSERT INTO public.\"UsersInfo\"(groups, name, \"lastName\", login, password) VALUES ( ?, ?, ?, ?, ?)",
            um.getGroups(),
            um.getName(),
            um.getLastName(),
            um.getLogin(),
            um.getPassword());

    }
    public List<UserModel> showAllUsers(){
    return jdbcTemplate.query("SELECT * FROM public.\"UsersInfo\"", new UserMapper());
    }
    public Object loginUser(String login,String password){
    Object result;
    try{
        result = jdbcTemplate.query("select * from FROM public.\"UsersInfo\" where login =? and password = ?",new Object[]{login,password},new UserMapper());
    }catch (InvalidResultSetAccessException e){
        result = "Неверный логин или пароль";
    }
    return result;
    }
    public UserModel getMyPersonalPage(UserModel me){
    return  jdbcTemplate.queryForObject("Select * from public.\"UsersInfo\" where id=? ", UserModel.class);//query("Select * from public.\"UsersInfo\" where id=? ",new Object[]{me.getId()},new UserMapper());
    }

}
