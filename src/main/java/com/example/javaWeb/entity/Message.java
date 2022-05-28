package com.example.javaWeb.entity;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/10:54
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class Message {
    String id;
    String uID;
    String mID;
    LocalDateTime ptime;
    String content;

    public LocalDateTime getPtime() {
        return ptime;
    }

    public void setPtime(LocalDateTime ptime) {
        this.ptime = ptime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", uID='" + uID + '\'' +
                ", mID='" + mID + '\'' +
                ", ptime=" + ptime +
                ", content='" + content + '\'' +
                '}';
    }
}
