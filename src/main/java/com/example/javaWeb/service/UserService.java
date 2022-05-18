package com.example.javaWeb.service;

import com.example.javaWeb.entity.User;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/10:08
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface UserService {
    public boolean Register(String userName, String passwd, String sex, String[] hobby);

    public User Login(String username, String password);

    public boolean Exit(String userID);
}
