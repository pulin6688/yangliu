package com.yangliu.test.wm3.entity;

import java.util.List;

/**
 * Created by mac on 17/6/14.
 */
public class DeliveryRegionTO {
    private String name;
    private List<List<RegionTO>> region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<RegionTO>> getRegion() {
        return region;
    }

    public void setRegion(List<List<RegionTO>> region) {
        this.region = region;
    }
}
