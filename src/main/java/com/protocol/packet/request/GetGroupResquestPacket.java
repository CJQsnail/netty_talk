package com.protocol.packet.request;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class GetGroupResquestPacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:53
 **/
@Data
public class GetGroupResquestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.GET_GROUPNUM_REQUEST;
    }
}
