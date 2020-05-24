package com.testservice.platform.server.model;

public class SysLoginLog extends BaseModel {

    private String userName;

    private String status;

    private String ip;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "SysLoginLog [userName=" + userName + ", status=" + status
                + ", ip=" + ip + "]";
    }

}