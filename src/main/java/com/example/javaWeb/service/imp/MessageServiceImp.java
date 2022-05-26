package com.example.javaWeb.service.imp;

import com.example.javaWeb.dao.MessageDao;
import com.example.javaWeb.dao.imp.MessageDaoImp;
import com.example.javaWeb.entity.Message;
import com.example.javaWeb.service.MessageService;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/11:24
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class MessageServiceImp implements MessageService {
    MessageDao messageDao=new MessageDaoImp();

    public Message getMessage(String id) {
        return messageDao.getById(id);
    }

    public ArrayList<Message> getAllMessage() {
        return messageDao.getAll();
    }

    public ArrayList<Message> getMessages(Integer page, Integer limit) {
        return messageDao.getAll();
    }
}
