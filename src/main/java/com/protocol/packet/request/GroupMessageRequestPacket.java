package com.protocol.packet.request;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class GroupMessageRequestPacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/26 15:22
 **/
@Data
public class GroupMessageRequestPacket extends Packet {

    private String toGroupId;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}
