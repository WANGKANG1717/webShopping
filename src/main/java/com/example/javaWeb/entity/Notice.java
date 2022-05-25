package com.example.javaWeb.entity;

/**
 * @Author: WK kang17.xyz
 * @Date: 2022/05/25/15:48
 * @Email: 1686617586@qq.com
 * @Description: ©WK
 */
public class Notice {
    String id;
    String name;
    String content;

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    String ptime;

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    Integer totalNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
