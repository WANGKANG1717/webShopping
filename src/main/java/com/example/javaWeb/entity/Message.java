package com.example.javaWeb.entity;

import java.util.Date;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/10:54
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class Message {
    String uID;
    String pID;
    String content;

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    Integer totalNum;

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    Date ptime;

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
