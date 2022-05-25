package com.example.javaWeb.service.imp;

import com.example.javaWeb.dao.NoticeDao;
import com.example.javaWeb.dao.imp.NoticeDaoImp;
import com.example.javaWeb.entity.Notice;
import com.example.javaWeb.service.NoticeService;

import java.util.ArrayList;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/25/15:59
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class NoticeServiceImp implements NoticeService {
    NoticeDao noticeDao=new NoticeDaoImp();

    @Override
    public Notice getNotice(String id) {
        return noticeDao.getById(id);
    }

    @Override
    public ArrayList<Notice> getAllNotice() {
        return noticeDao.getAll();
    }

    @Override
    public ArrayList<Notice> getNotices(Integer page, Integer limit) {
        ArrayList<Notice> allNotices = noticeDao.getAll();
        ArrayList<Notice> notices = new ArrayList<>();
        //得到查询到的所有产品总数，写到第一个产品中去，这样可以避免再次查询数据库
        Integer TotalNum = allNotices.size();
        for (int i = 0; i < allNotices.size(); i++) {
            allNotices.get(i).setTotalNum(TotalNum);
        }
        if (page <= 0 || allNotices.size() <= ((page - 1) * limit)) {
            return notices;
        } else {
            for (int i = (page - 1) * limit; i < allNotices.size() && i < page * limit; i++) {
                notices.add(allNotices.get(i));
            }
            return notices;
        }
    }
}
