package com.ruoyi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SellMailBusinessExceptionEnum {

    MSG("1001","品类信息不存在");
    private String msg;
    private String msgDesc;

    /**
     * 获取msgDesc
     *
     * @param msg 对应msg
     * @return 对应code枚举
     */
    public static SellMailBusinessExceptionEnum getMsg(String msg) {
        SellMailBusinessExceptionEnum[] es = SellMailBusinessExceptionEnum.values();
        for (SellMailBusinessExceptionEnum e : es) {
            if (e.getMsg().equals(msg)) {
                return e;
            }
        }
        return SellMailBusinessExceptionEnum.MSG;
    }


}
