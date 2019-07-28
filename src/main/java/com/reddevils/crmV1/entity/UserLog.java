/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.entity;

import java.util.Date;

/**
 *
 * @author Derslived
 */
public class UserLog extends MasterEntity {

    private User user;
    private Date logDate;

    public UserLog() {
    }

    public UserLog(User user) {
        this.user = user;
    }
    public UserLog(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    
    
    
    
    
}
