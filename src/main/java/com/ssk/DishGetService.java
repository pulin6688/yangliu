package com.ssk;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yangliu.utils.HttpUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2017/8/23.
 */
public class DishGetService {

    public static void main(String[] args) throws Exception{
        String url = "http://devb.shishike.com/merchandise/innerApi/dishDomain/getShopDishBusiDatas";
        Map<String,Object> map = Maps.newHashMap();
        map.put("brandIdenty",2479);
        map.put("shopIdenty",247900001);
        map.put("startId",0);
        map.put("pageNum",1);
        List<Long> list = Lists.newArrayList();
        list.add(1L);
        map.put("dishType",list);
        HttpUtils.httppostJson(url, JSON.toJSONString(map));
    }
}
