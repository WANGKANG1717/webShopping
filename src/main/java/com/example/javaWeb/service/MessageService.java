package com.example.javaWeb.service;

import com.example.javaWeb.entity.Message;
import com.example.javaWeb.entity.MessageInfo;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/11:24
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface MessageService {
    public Message getMessage(String id);

    public boolean deleteMessage(String id);

    public ArrayList<Message> getAllMessage();

    public ArrayList<MessageInfo> getMessages();

    public ArrayList<MessageInfo> getMessages(Integer page, Integer limit);

    public ArrayList<MessageInfo> getMessagePair(String id);

    public boolean addMessage(String userID, String mID, String content);

//    public HashMap<String, ArrayList<Message>> getMessages();

//    public ArrayList<Message> getMessageHead();
//
//    public  ArrayList<Message> getMessageChildByID(String id);
}
