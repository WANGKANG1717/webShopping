package com.example.javaWeb.dao;

import com.example.javaWeb.entity.Notice;
import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/25/15:49
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface NoticeDao {
    public Notice getById(String id);
    public ArrayList<Notice> getAll();
}
