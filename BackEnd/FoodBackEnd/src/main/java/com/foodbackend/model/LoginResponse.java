package com.foodbackend.model;

public class LoginResponse {
    private boolean flag;
    private String msg;
    private long userID;
    private String Role;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMSg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
