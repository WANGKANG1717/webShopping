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
    MessageDao messageDao = new MessageDaoImp();

    public Message getMessage(String id) {
        return messageDao.getById(id);
    }

    public ArrayList<Message> getAllMessage() {
        return messageDao.getAll();
    }

    public ArrayList<Message> getMessages(Integer page, Integer limit) {
        ArrayList<Message> allMessages = messageDao.getAll();
        ArrayList<Message> messages = new ArrayList<>();
        //得到查询到的所有产品总数，写到第一个产品中去，这样可以避免再次查询数据库
        Integer TotalNum = allMessages.size();
        for (int i = 0; i < allMessages.size(); i++) {
            allMessages.get(i).setTotalNum(TotalNum);
        }
        if (page <= 0 || allMessages.size() <= ((page - 1) * limit)) {
            return messages;
        } else {
            for (int i = (page - 1) * limit; i < allMessages.size() && i < page * limit; i++) {
                messages.add(allMessages.get(i));
            }
            return messages;
        }
    }
}
