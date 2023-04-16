package ru.toylep.newKursach.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.toylep.newKursach.DAO.mappers.DescriptionMapper;
import ru.toylep.newKursach.DAO.mappers.UserMapper;
import ru.toylep.newKursach.models.CommentModel;
import ru.toylep.newKursach.models.DescriptionModel;
import ru.toylep.newKursach.models.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DescriptionDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DescriptionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addDescription(DescriptionModel descriptionModel,UserModel userModel) {
        jdbcTemplate.update("INSERT INTO public.\"Description\"( subject_name, teacher_fio, \"Description_text\", spec_links, user_id) VALUES ( ?, ?, ?, ?, ?)",
                descriptionModel.getSubjectName(),
                descriptionModel.getTeacherFIO(),
                descriptionModel.getText(),
                descriptionModel.getSpecLinks(),
                userModel.getId());

    }

    public List<DescriptionModel> showDescriptions() {
        return jdbcTemplate.query("select * from public.\"Description\"", new DescriptionMapper());
    }
    /*
    public List<String> showAuthor(){
        List<String> result = new ArrayList<>();
        for (var description:showDescriptions()) {
            String resultStr="";
            resultStr+= jdbcTemplate.queryForObject("SELECT  groups FROM public.\"UsersInfo\" where id =" + description.getUserID(), String.class) + " ";
            resultStr+= jdbcTemplate.queryForObject("SELECT  name FROM public.\"UsersInfo\" where id =" + description.getUserID(), String.class)+ " ";
            resultStr+= jdbcTemplate.queryForObject("SELECT \"lastName\" FROM public.\"UsersInfo\" where id =" + description.getUserID(), String.class )+ " ";
        result.add(resultStr);
        }
        //return jdbcTemplate.query("SELECT  groups, name, \"lastName\" FROM public.\"UsersInfo\" where id =?", new Object[]( description.getUserID()), new UserMapper());
        return result;
    }

     */
}