package com.protocol.packet.response;

import com.command.Command;
import com.protocol.packet.Packet;
import com.session.Session;
import lombok.Data;

/**
 * @Class GroupMessageResponsePacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/26 15:37
 **/

@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;
    private Session fromUser;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
