package com.example.ogs.model;

public class Search_model {

    Integer id;
    Integer imageurl;
    String price;
    String producut_name;
    String product_unit;
    String product_des;



    public Search_model(Integer id , Integer imageurl, String producut_name, String price, String product_unit, String product_des)
    {
        this.id=id;
        this.imageurl=imageurl;
        this.producut_name=producut_name;
        this.price=price;
        this.product_unit=product_unit;
        this.product_des=product_des;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) {
        this.imageurl = imageurl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProducut_name() {
        return producut_name;
    }

    public void setProducut_name(String producut_name) {
        this.producut_name = producut_name;
    }

    public String getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(String product_unit) {
        this.product_unit = product_unit;
    }

    public String getProduct_des() {
        return product_des;
    }

    public void setProduct_des(String product_des) {
        this.product_des = product_des;
    }
}
