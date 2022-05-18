package com.example.javaWeb.dao;

import com.example.javaWeb.entity.User;

/**
 * @Author: WK
 * @Date: 2022/5/18
 * @Email: 1686617586@qq.com
 * @Description: ©WK userDaoImp
 */
public interface UserDao {
    public boolean add(User user);

    public boolean delete(Integer id);

    public boolean update(User user);

    public User getByName_Pwd(String username, String password);

    public User getById(String id);
}
