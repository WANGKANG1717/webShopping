package com.example.javaWeb.service.imp;

import com.example.javaWeb.dao.MessageDao;
import com.example.javaWeb.dao.UserDao;
import com.example.javaWeb.dao.imp.MessageDaoImp;
import com.example.javaWeb.dao.imp.UserDaoImp;
import com.example.javaWeb.entity.Message;
import com.example.javaWeb.entity.MessageInfo;
import com.example.javaWeb.entity.User;
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

    public boolean deleteMessage(String id) {
        return messageDao.deleteById(id);
    }

    public ArrayList<Message> getAllMessage() {
        return messageDao.getAll();
    }

    public ArrayList<MessageInfo> getMessages() {
        ArrayList<Message> messages = messageDao.getAll();
        Integer TotalNum = messages.size();
        //
        ArrayList<MessageInfo> messageInfos = new ArrayList<>();
        UserDao userDao = new UserDaoImp();
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            User user = userDao.getById(message.getuID());
            messageInfos.add(new MessageInfo(user, message, TotalNum));
        }

        return messageInfos;
    }

    @Override
    public ArrayList<MessageInfo> getMessages(Integer page, Integer limit) {
        ArrayList<Message> messages = messageDao.getAll();
        //
        ArrayList<MessageInfo> messageInfos = new ArrayList<>();
        UserDao userDao = new UserDaoImp();
        Integer TotalNum = messages.size();
        //得到查询到的所有产品总数，写到第一个产品中去，这样可以避免再次查询数据库

        if (page <= 0 || messages.size() <= ((page - 1) * limit)) {
            for (int i = 0; i < messages.size(); i++) {
                Message message = messages.get(i);
                User user = userDao.getById(message.getuID());
                messageInfos.add(new MessageInfo(user, message, TotalNum));
            }
            return messageInfos;
        } else {
            for (int i = (page - 1) * limit; i < messages.size() && i < page * limit; i++) {
                Message message = messages.get(i);
                User user = userDao.getById(message.getuID());
                messageInfos.add(new MessageInfo(user, message, TotalNum));
            }
            return messageInfos;
        }
    }

    /**
     * 第一个参数是留言人， 第二个是回复人
     *
     * @param id
     * @return
     */
    public ArrayList<MessageInfo> getMessagePair(String id) {
        UserDao userDao = new UserDaoImp();
        //
        ArrayList<MessageInfo> messageInfoPair = new ArrayList<>();
        //
        Message message = messageDao.getById(id);
        User user = userDao.getById(message.getuID());
        messageInfoPair.add(new MessageInfo(user, message));
        //
        Message messageTo = null;
        User userTo = null;
        if (message.getmID() != null) {
            messageTo = messageDao.getById(message.getmID());
            if (messageTo != null) {
                userTo = userDao.getById(message.getuID());
                messageInfoPair.add(new MessageInfo(userTo, messageTo));
            }
        }
        return messageInfoPair;
    }

    public boolean addMessage(String userID, String mID, String content) {
        return messageDao.add(userID, mID, content);
    }

    /**
     * 这里比较有难度
     * 这里的效率比较糟糕，很糟糕
     *
     * @return
     */
//    public HashMap<String, ArrayList<Message>> getMessages() {
//        ArrayList<Message> messages = messageDao.getAll();
//        //
//        HashMap<String, ArrayList<Message>> res = new HashMap<>();
//        //先建立表
//        for (int i = 0; i < messages.size(); i++) {
//            res.put(messages.get(i).getId(), new ArrayList<>());
//        }
//        for (int i = 0; i < messages.size(); i++) {
//            Message message = messages.get(i);
//            //得到利用Hashmap形成的属性结构
//            if (message.getmID() != null && !message.getmID().equals("")) {
//                res.get(message.getmID()).add(message);
//            }
//        }
//
//        return res;
//    }

    /**
     *  mID为null的即为要获得的信息头
     */
//    @Override
//    public ArrayList<Message> getMessageHead() {
//        ArrayList<Message> messages = messageDao.getAll();
//        //
//        ArrayList<Message> head = new ArrayList<>();
//        for (int i = 0; i < messages.size(); i++) {
//            Message message = messages.get(i);
//            if (message.getmID() == null || message.getmID().equals("")) {
//                head.add(message);
//            }
//        }
//        return head;
//    }

    /**
     * 根据id得到第一层的直接孩子
     * @param id
     * @return
     */
//    @Override
//    public ArrayList<Message> getMessageChildByID(String id) {
//        ArrayList<Message> messages = messageDao.getAll();
//        ArrayList<Message> child = new ArrayList<>();
//        for (int i = 0; i < messages.size(); i++) {
//            Message message = messages.get(i);
//            String mID=message.getmID();
//            if (mID != null && mID.equals("") && mID.equals(id)) {
//                child.add(message);
//            }
//        }
//        return child;
//    }
}
