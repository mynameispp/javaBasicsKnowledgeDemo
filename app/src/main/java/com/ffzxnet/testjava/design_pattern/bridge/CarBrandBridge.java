package com.ffzxnet.testjava.design_pattern.bridge;

/**
 *  品牌桥连接
 * 创建者： feifan.pi 在 2017/8/25.
 */

public abstract class CarBrandBridge {
    protected Brand brand;

    public CarBrandBridge(Brand brand) {
        this.brand = brand;
    }

    public abstract void car();
}
