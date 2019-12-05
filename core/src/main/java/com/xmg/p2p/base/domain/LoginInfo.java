package com.xmg.p2p.base.domain;

public class LoginInfo extends BaseDomain {

    public static final int STATE_NORMAL = 0;// 正常
    public static final int STATE_LOCK = 1;// 锁定

    public static final int USER_MANAGER = 0;// 后台用户
    public static final int USER_CLIENT = 1;// 前台用户

    private String username;
    private String password;
    private int state;
    private int userType;

    public static int getStateNormal() {
        return STATE_NORMAL;
    }

    public static int getStateLock() {
        return STATE_LOCK;
    }

    public static int getUserManager() {
        return USER_MANAGER;
    }

    public static int getUserClient() {
        return USER_CLIENT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
