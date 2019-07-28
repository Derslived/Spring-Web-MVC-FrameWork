/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.repo.impl;


import com.reddevils.crmV1.entity.User;
import com.reddevils.crmV1.repo.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Derslived
 */
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate template;

    private User mapUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setCreatedDate(new Date(rs.getDate("created_Date").getTime()));
        if (rs.getDate("modfied_Date") != null) {
            user.setModifiedDate(new Date(rs.getDate("modfied_Date").getTime()));
        }
        user.setStatus(rs.getBoolean("status"));
        return user;
    }

    @Override
    public void insert(User model) throws Exception {

        String sql = "insert into tbl_users(email,password,status) values(?,?,?)";
        template.update(sql, new Object[]{model.getEmail(), model.getPassword(), model.isStatus()});

    }

    @Override
    public void update(User model) throws Exception {

        String sql = "update tbl_users set email=?,password=?, modfied_Date=CURRENT_TIMESTAMP,status=? where id=?";
        template.update(sql, new Object[]{model.getId()});
    }

    @Override
    public List<User> findAll() throws Exception {

        String sql = "select * from tbl_users";

        return template.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapUser(rs);
            }
        });

    }

    @Override
    public User findById(int id) throws Exception {

        String sql = "select * from tbl_users where id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapUser(rs);
            }
        });

    }

    @Override
    public User login(String email, String password) throws Exception {
        String sql = "select * from tbl_users where email=? and password=?";
        return template.queryForObject(sql, new Object[]{email, password}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapUser(rs);
            }
        });
    }

    @Override
    public User findByEmail(String email) throws Exception {
        String sql = "select * from tbl_users where email=?";
        return template.queryForObject(sql, new Object[]{email}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapUser(rs);
            }
        });
    }

    @Override
    public boolean changeStatus(int id, boolean status) throws Exception {
        String sql = "update tbl_users set modfied_Date=CURRENT_TIMESTAMP,status=? where id=?";
       int result= template.update(sql, new Object[]{status,id});
        
        return result>0;
        
    }
}
