package com.yangliu.test.wm3;

import java.io.Serializable;



public class DishMenuGetTO implements Serializable {

//    shop_id	String
//    商户ID
//
//    baidu_shop_id 可选	String
//            百度商户ID,与shop_id二选一
//
//    dish_name 可选	String
//            根据菜品名称检索
//
//    has_category 可选	String
//            根据是否有分类检索

//    dish_id	String
//    合作方菜品ID
//
//    baidu_dish_id	String
//    百度菜品ID,与dish_id二选一

    private String shop_id;
    private String baidu_shop_id;
    private String dish_name;
    private String has_category;

    private String dish_id;
    private String baidu_dish_id;

    public String getDish_id() {
        return dish_id;
    }

    public void setDish_id(String dish_id) {
        this.dish_id = dish_id;
    }

    public String getBaidu_dish_id() {
        return baidu_dish_id;
    }

    public void setBaidu_dish_id(String baidu_dish_id) {
        this.baidu_dish_id = baidu_dish_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getBaidu_shop_id() {
        return baidu_shop_id;
    }

    public void setBaidu_shop_id(String baidu_shop_id) {
        this.baidu_shop_id = baidu_shop_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getHas_category() {
        return has_category;
    }

    public void setHas_category(String has_category) {
        this.has_category = has_category;
    }


}