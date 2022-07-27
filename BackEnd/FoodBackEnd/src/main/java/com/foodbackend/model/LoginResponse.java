package com.foodbackend.model;

public class LoginResponse {
    private boolean flag;
    private String msg;
    private String role;
    private String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String Role) {
        this.role = Role;
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
