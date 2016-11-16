package com.yangliu.test.wm.to.dish;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * 菜品信息查询TO
 *
 * @author 
 * @since 
 */
public class DishInfoQueryTO implements Serializable {

    private static final long serialVersionUID = -5569010402083811632L;
    /**
     * 商户ID,如：80000001
     */
    @SerializedName("id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
