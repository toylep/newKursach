package ru.toylep.newKursach.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.toylep.newKursach.models.DescriptionModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DescriptionMapper implements RowMapper<DescriptionModel> {
    @Override
    public DescriptionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        DescriptionModel descriptionModel = new DescriptionModel();
        descriptionModel.setId(rs.getLong("id"));
        descriptionModel.setSubjectName(rs.getString("subject_name"));
        descriptionModel.setTeacherFIO(rs.getString("teacher_fio"));
        descriptionModel.setText(rs.getString("Description_text"));
        descriptionModel.setSpecLinks(rs.getString("spec_links"));
        descriptionModel.setUserID(rs.getLong("user_id"));
        return descriptionModel;
    }
}
