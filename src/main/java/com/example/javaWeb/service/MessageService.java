package com.example.javaWeb.service;

import com.example.javaWeb.entity.Message;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/11:24
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface MessageService {
    public Message getMessage(String id);

    public ArrayList<Message> getAllMessage();

    public ArrayList<Message> getMessages(Integer page, Integer limit);
}
