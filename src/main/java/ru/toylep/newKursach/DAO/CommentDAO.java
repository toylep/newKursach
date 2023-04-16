package ru.toylep.newKursach.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.toylep.newKursach.DAO.mappers.CommentMapper;
import ru.toylep.newKursach.models.CommentModel;
import ru.toylep.newKursach.models.DescriptionModel;
import ru.toylep.newKursach.models.UserModel;

import java.util.List;

public class CommentDAO {

        private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CommentModel> searchCommentByDescription(Long id){
        return jdbcTemplate.query("SELECT * FROM public.\"Comment\" where description_id = ?",new Object[]{id},new CommentMapper());
    }
    public void addComment(Long id,
                           CommentModel commentModel,
                           UserModel userModel){
        jdbcTemplate.update("Insert INSERT INTO public.\"Comment\"(  text, description_id, \"user\") VALUES (?, ?, ?);",
                commentModel.getText(),
                id,
                userModel.getId());
    }

}
