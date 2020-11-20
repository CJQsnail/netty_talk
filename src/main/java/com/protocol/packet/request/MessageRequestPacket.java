package com.protocol.packet.request;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Class MessageRequestPacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:29
 **/
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }



    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
