package com.ffzxnet.testjava.design_pattern.bridge;

/**
 * 奔驰品牌
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class Benz implements Brand {
    @Override
    public String brandName() {
        return "我是奔驰";
    }
}
