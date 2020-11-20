package com.protocol.packet.response;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class LoginResponsePacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:29
 **/
@Data
public class LoginResponsePacket extends Packet {


    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;


    /**
     * 返回消息
     */
    private String msg;


    /**
     * 返回状态
     */
    private boolean status;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
