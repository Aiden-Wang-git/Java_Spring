package com.exchange.used.configure.searchUser;

/**
 * ClassName:DataUser
 * Package:com.exchange.used.configure.search
 * Description:
 *
 * @date:2019/12/10 19:15
 * @author:Wang Jun
 */
public class DataUser {
    private String id;
    private String username;
    private String realname = "";
    private String sex = "";
    private int age = 0;
    private String phone = "";
    private String email = "";
    private String power = "";
    private String password="";

    public DataUser(String id, String username, String realname, String sex, int age, String phone, String email, String power ,String password) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.power = power;
        this.password = password;
    }

    public DataUser(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
