package ru.toylep.newKursach.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.toylep.newKursach.models.CommentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<CommentModel> {
    @Override
    public CommentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CommentModel commentModel = new CommentModel();
        commentModel.setId(rs.getLong("id"));
        commentModel.setText(rs.getString("text"));
        commentModel.setDescriptionID(rs.getLong("description_id"));
        return commentModel;


    }
}
