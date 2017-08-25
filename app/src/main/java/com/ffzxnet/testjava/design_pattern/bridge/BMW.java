package com.ffzxnet.testjava.design_pattern.bridge;

/**
 *  宝马品牌
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class BMW implements Brand {
    @Override
    public String brandName() {
        return "我是宝马";
    }
}
