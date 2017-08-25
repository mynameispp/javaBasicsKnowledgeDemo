package com.ffzxnet.testjava.design_pattern.bridge;

/**
 * 创建者： feifan.pi 在 2017/8/25.
 */

public class SUVCar extends CarBrandBridge {
    public SUVCar(Brand brand) {
        super(brand);
    }

    @Override
    public void car() {
        System.out.print(super.brand.brandName() + "SUV\n");
    }
}
