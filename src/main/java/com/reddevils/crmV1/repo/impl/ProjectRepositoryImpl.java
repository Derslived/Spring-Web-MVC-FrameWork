/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.repo.impl;


import com.reddevils.crmV1.entity.Project;
import com.reddevils.crmV1.entity.User;
import com.reddevils.crmV1.repo.ProjectRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Derslived
 */

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    public JdbcTemplate template;

    public Project mapUser(ResultSet rs) throws SQLException {
        Project project = new Project();
        project.setId(rs.getInt("id"));
        project.setName(rs.getString("project_name"));
        project.setDescription(rs.getString("project_description"));
        project.setStartDate(new Date(rs.getDate("start_date").getTime()));
        project.setEndDate(new Date(rs.getDate("end_date").getTime()));
        project.setCreatedDate(new Date(rs.getDate("created_date").getTime()));
        project.setCreatedBy(new User(rs.getInt("created_by")));
        project.setStatus(rs.getBoolean("status"));
        
        return project;
        
        

    }

    @Override
    public void insert(Project model) throws Exception {
        String sql = "insert into tbl_projects(project_name,project_description,start_date,end_date,created_by,status) values(?,?,?,?,?,?)";
        template.update(sql, new Object[]{model.getName(), model.getDescription(), model.getStartDate(), model.getEndDate(), model.getCreatedBy().getId(), model.getStatus()});

    }

    @Override
    public void update(Project model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Project> findAll() throws Exception {
        String sql = "select * from tbl_projects";
        return template.query(sql, new RowMapper<Project>() {

            @Override
            public Project mapRow(ResultSet rs, int i) throws SQLException {
                return mapUser(rs);
            }
        });
    }

    @Override
    public Project findById(int id) throws Exception {
      String sql = "select * from tbl_projects where id=?";
      return template.queryForObject(sql, new Object[]{id}, new RowMapper<Project>() {

          @Override
          public Project mapRow(ResultSet rs, int i) throws SQLException {
             return mapUser(rs);
          }
      });  
    }

}
