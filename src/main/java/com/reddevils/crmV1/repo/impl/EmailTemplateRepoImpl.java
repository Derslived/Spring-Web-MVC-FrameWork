/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reddevils.crmV1.repo.impl;

import com.mysql.cj.api.mysqla.result.Resultset;
import com.reddevils.crmV1.entity.EmailTemplate;
import com.reddevils.crmV1.repo.EmailTemplateRepository;
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
public class EmailTemplateRepoImpl implements EmailTemplateRepository {

    private JdbcTemplate template;

    @Override
    public void insert(EmailTemplate model) throws Exception {
        String sql = "insert into tbl_email_templates(email_title,slug_name,subject,body,created_by) values(?,?,?,?,?)";
        template.update(sql, new Object[]{model.getTitle(), model.getSlug(), model.getSubject(), model.getBody(), model.getCreatedBy()});
    }

    @Override
    public void update(EmailTemplate model) throws Exception {
        String sql = "update tbl_email_templates set email_title=?,slug_name =?,subject=?,body=?, modified_date= current_timestamp,modified_by=? where id=?";
        template.update(sql, new Object[]{model.getTitle(), model.getSlug(), model.getSubject(), model.getBody(), model.getCreatedBy(), model.getId()});

    }

    

    @Override
    public List<EmailTemplate> findAll() throws Exception {
        String sql = "select * from vw_email_templates";
        return template.query(sql, new RowMapper<EmailTemplate>() {

            @Override
            public EmailTemplate mapRow(ResultSet rs, int i) throws SQLException {
                EmailTemplate emailTemplate = new EmailTemplate();
                emailTemplate.setId(rs.getInt("id"));
                emailTemplate.setTitle(rs.getString("email_title"));
                emailTemplate.setSlug(rs.getString("slug_name"));
                emailTemplate.setSubject(rs.getString("subject"));
                emailTemplate.setBody(rs.getString("body"));
                emailTemplate.setStatus(rs.getBoolean("status"));
                emailTemplate.setCreatedDate(new Date(rs.getDate("created_date").getTime()));
                emailTemplate.setCreatedBy(rs.getInt("created_by"));

                return emailTemplate;

            }
        });

    }

    @Override
    public EmailTemplate findById(int id) throws Exception {
        String sql = "select * from vw_email_templates where  id=?";
        return template.queryForObject(sql, new Object[]{id}, new RowMapper<EmailTemplate>() {

            @Override
            public EmailTemplate mapRow(ResultSet rs, int i) throws SQLException {
                EmailTemplate emailTemplate = new EmailTemplate();
                emailTemplate.setId(rs.getInt("id"));
                emailTemplate.setTitle(rs.getString("email_title"));
                emailTemplate.setSlug(rs.getString("slug_name"));
                emailTemplate.setSubject(rs.getString("subject"));
                emailTemplate.setBody(rs.getString("body"));
                emailTemplate.setStatus(rs.getBoolean("status"));
                emailTemplate.setCreatedDate(new Date(rs.getDate("created_date").getTime()));
                emailTemplate.setCreatedBy(rs.getInt("created_by"));

                return emailTemplate;

            }
        });

    }

}
