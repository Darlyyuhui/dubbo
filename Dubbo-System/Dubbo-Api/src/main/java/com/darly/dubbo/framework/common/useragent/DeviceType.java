package com.darly.dubbo.framework.common.useragent;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/10/28 16:24
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public enum DeviceType {
    COMPUTER("Computer"),
    MOBILE("Mobile"),
    TABLET("Tablet"),
    GAME_CONSOLE("Game console"),
    DMR("Digital media receiver"),
    UNKNOWN("Unknown");

    String name;

    private DeviceType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

