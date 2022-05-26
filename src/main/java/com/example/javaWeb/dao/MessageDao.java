package com.example.javaWeb.dao;

import com.example.javaWeb.entity.Message;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/26/10:55
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface MessageDao {
    Message getById(String id);
    ArrayList<Message> getAll();
}
