package com.denisabramov.postings.dao.entity;

import com.denisabramov.postings.service.converter.BooleanToLowerCaseConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CsvBindByName(column = "AppAccountName")
    private String username;
    @CsvBindByName(column = "Application")
    private String application;
   // @CsvBindByName(column = "IsActive")
    @CsvCustomBindByName(column = "IsActive", converter = BooleanToLowerCaseConverter.class)
    private boolean isActive;
    @CsvBindByName(column = "JobTitle")
    private String job;
    @CsvBindByName(column = "Department")
    private String department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application.trim();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", application='" + application + '\'' +
                ", isActive=" + isActive +
                ", job='" + job + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
