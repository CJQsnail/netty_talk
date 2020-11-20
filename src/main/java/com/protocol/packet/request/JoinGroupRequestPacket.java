package com.protocol.packet.request;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class JoinGroupRequestPacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 16:20
 **/
@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;



    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_REQUEST;
    }
}
