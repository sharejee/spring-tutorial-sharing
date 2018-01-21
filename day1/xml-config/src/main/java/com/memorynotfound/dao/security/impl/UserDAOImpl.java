package com.memorynotfound.dao.security.impl;

import com.memorynotfound.dao.security.UserDAO;
import com.memorynotfound.model.security.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by : Ron Rith
 * Create Date: 01/21/2018.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    public JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByUserName(String username) {
        String sqlFindByName = "select *from sec_user where name =?";

        User user = (User) jdbcTemplate.queryForObject(sqlFindByName, new Object[]
                {username}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setEnabled(rs.getBoolean("enable"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        return user;
    }
}
