package com.protocol.packet.request;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Class LoginRequestPacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:29
 *
 **/
@Data

public class LoginRequestPacket extends Packet {

    private String userName = "cjq";
//    private String userId;
    private String passW = "123";


    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
