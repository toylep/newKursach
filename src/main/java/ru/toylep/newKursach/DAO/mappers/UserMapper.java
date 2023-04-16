package ru.toylep.newKursach.DAO.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.toylep.newKursach.models.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(rs.getLong("id"));
        userModel.setName(rs.getString("name"));
        userModel.setGroups(rs.getString("groups"));
        userModel.setLastName(rs.getString("lastName"));
        userModel.setLogin(rs.getString("login"));
        userModel.setPassword(rs.getString("password"));
        return userModel;
    }
}
