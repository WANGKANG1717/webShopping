package com.example.javaWeb.entity;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Double pro_price;
    private Integer inventory;
    private Integer sales;
    private String img;
    private String category;
    private String fan_material;
    private String fan_bone_material;
    private Integer fan_bone_num;
    private Integer fan_bone_length;

    //购物车中数量
    private Integer num;
    //查到的总数（方便进行程序设计）
    private Integer totalNum;

    //总价
    private Double total_price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPro_price() { return pro_price; }

    public void setPro_price(Double pro_price) { this.pro_price = pro_price; }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFan_material() {
        return fan_material;
    }

    public void setFan_material(String fan_material) {
        this.fan_material = fan_material;
    }

    public String getFan_bone_material() {
        return fan_bone_material;
    }

    public void setFan_bone_material(String fan_bone_material) {
        this.fan_bone_material = fan_bone_material;
    }

    public Integer getFan_bone_num() {
        return fan_bone_num;
    }

    public void setFan_bone_num(Integer fan_bone_num) {
        this.fan_bone_num = fan_bone_num;
    }

    public Integer getFan_bone_length() {
        return fan_bone_length;
    }

    public void setFan_bone_length(Integer fan_bone_length) {
        this.fan_bone_length = fan_bone_length;
    }

    public Integer getNum() { return num; }

    public void setNum(Integer num) { this.num = num; }

    public Double getTotal_price() {
        this.setTotal_price();
        return total_price;
    }

    public void setTotal_price() {
        this.total_price = this.getPro_price()*this.getNum();
    }

    public Integer getTotalNum() { return totalNum; }

    public void setTotalNum(Integer totalNum) { this.totalNum = totalNum; }
}
