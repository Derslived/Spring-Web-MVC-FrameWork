/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.repo.impl;


import com.reddevils.crmV1.entity.UserLog;
import com.reddevils.crmV1.repo.UserLogRepository;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Derslived
 */
public class UserLogRepositoryImpl implements UserLogRepository{
    private JdbcTemplate temp;

    @Override
    public void insert(UserLog model) throws Exception {
        String sql="insert into tbl_user_logs(user_id) VALUES(?)";
        temp.update(sql, new Object[] {model.getUser().getId()});
    }

    @Override
    public void update(UserLog model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserLog> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserLog findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
