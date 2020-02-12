package com.domain.lesson12Map;



public class User {
    private String login;
    private String pwd;
    private Role role;

    public User(String login, String pwd, Role role) {
        this.login = login;
        this.pwd = pwd;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role=" + role +
                '}'+ "\n";
    }

    enum  Role{
        USER, ADMIN;
    }
}
