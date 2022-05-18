package com.example.javaWeb.service.imp;

import com.example.javaWeb.dao.UserDao;
import com.example.javaWeb.dao.imp.UserDaoImp;
import com.example.javaWeb.entity.User;
import com.example.javaWeb.service.UserService;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/18/10:12
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class UserServiceImp implements UserService {
    private UserDao userDao=new UserDaoImp();

    @Override
    public boolean Register(String userName, String passwd, String sex, String[] hobby) {
        User user =new User(userName, passwd, sex, hobby);
        return userDao.add(user);
    }

    @Override
    public User Login(String username, String password) {
        User user=userDao.getByName_Pwd(username, password);
        if(user!=null) {
            user.setOnline(1);
            userDao.update(user);
        }
        return user;
    }

    @Override
    public boolean Exit(String userID) {
        boolean flag=false;
        User user=userDao.getById(userID);
        //设置下线
        if(user!=null) {
            user.setOnline(0);
            flag=userDao.update(user);
        }
        return flag;
    }
}
