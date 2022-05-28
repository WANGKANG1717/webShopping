package com.example.javaWeb.entity;

public class User {
    private Integer id;
    private String name;
    private String passwd;
    private String sex;
    private String[] hobby;
    private Integer online;
    private Double balance;

    public User() {
        name = "";
        passwd = "";
        sex = "";
        hobby = null;
    }

    public User(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public User(String name, String passwd, String sex, String[] hobby) {
        this.name = name;
        this.passwd = passwd;
        this.sex = sex;
        this.hobby = hobby;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return this.name;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    public String[] getHobby() { return hobby; }

    public void setHobby(String[] hobby) { this.hobby = hobby; }

    public Integer getOnline() { return online; }

    public void setOnline(Integer online) { this.online = online; }

    public Double getBalance() { return balance; }

    public void setBalance(Double balance) { this.balance = balance;}

    @Override
    public boolean equals(Object obj) {
        User b=(User) obj;
        return this.id.equals(b.id);
    }
}
