package com.example.javaWeb.entity;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/27/15:38
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class MessageInfo {
    private User user;            //消息的发出者
    private Message message;  //发出的消息
    private Integer totalNum;

    public MessageInfo(User user, Message message) {
        this.user = user;
        this.message = message;
    }

    public MessageInfo(User user, Message message, Integer totalNum) {
        this.user = user;
        this.message = message;
        this.totalNum = totalNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}
