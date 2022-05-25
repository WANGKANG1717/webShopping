package com.example.javaWeb.service;

import com.example.javaWeb.entity.Notice;
import com.example.javaWeb.entity.Product;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/25/15:58
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public interface NoticeService {
    public Notice getNotice(String id);

    public ArrayList<Notice> getAllNotice();

    public ArrayList<Notice> getNotices(Integer page, Integer limit);
}
