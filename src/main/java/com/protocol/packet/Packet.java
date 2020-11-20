package com.protocol.packet;

import lombok.Data;

/**
 * @Class Packet
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 15:23
 **/
@Data
public abstract class Packet {

    /**
     *协议版本
     * TODO:未添加@JSONField
     */
    private Byte version = 1;

    /**
     *获取指令
     * TODO:未添加@JSONField
     */
    public abstract Byte getCommand();
}
