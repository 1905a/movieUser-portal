package com.fh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserQuery extends DataTablePageBean{
    private String userName;

    private String realName;

    private String phoneNumber;

    private String email;

    private Integer sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date minBirthday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date maxBirthday;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date minCreateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date maxCreateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date minUpdateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date maxUpdateDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getMinBirthday() {
        return minBirthday;
    }

    public void setMinBirthday(Date minBirthday) {
        this.minBirthday = minBirthday;
    }

    public Date getMaxBirthday() {
        return maxBirthday;
    }

    public void setMaxBirthday(Date maxBirthday) {
        this.maxBirthday = maxBirthday;
    }

    public Date getMinCreateDate() {
        return minCreateDate;
    }

    public void setMinCreateDate(Date minCreateDate) {
        this.minCreateDate = minCreateDate;
    }

    public Date getMaxCreateDate() {
        return maxCreateDate;
    }

    public void setMaxCreateDate(Date maxCreateDate) {
        this.maxCreateDate = maxCreateDate;
    }

    public Date getMinUpdateDate() {
        return minUpdateDate;
    }

    public void setMinUpdateDate(Date minUpdateDate) {
        this.minUpdateDate = minUpdateDate;
    }

    public Date getMaxUpdateDate() {
        return maxUpdateDate;
    }

    public void setMaxUpdateDate(Date maxUpdateDate) {
        this.maxUpdateDate = maxUpdateDate;
    }
}
