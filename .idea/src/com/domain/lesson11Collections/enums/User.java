package com.domain.lesson11Collections.enums;

import javax.management.relation.Role;

public class User {
    private String login;
    private String pwd;
    private Role role;

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


    public void setRole(com.domain.lesson11Collections.enums.Role admin) {
    }
}
