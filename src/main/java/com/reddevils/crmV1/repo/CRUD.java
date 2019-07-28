/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.repo;

import java.util.List;

/**
 *
 * @author Derslived
 */
public interface CRUD<T> {

    void insert(T model) throws Exception;

    void update(T model) throws Exception;

    List<T> findAll() throws Exception;

    T findById(int id) throws Exception;

}
