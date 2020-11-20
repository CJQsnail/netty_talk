package com.protocol.packet.response;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class MessageResponsePacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:29
 **/
@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
