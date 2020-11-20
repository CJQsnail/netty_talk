package com.protocol.packet.request;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class LeftGroupResquestPacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:23
 **/
@Data
public class LeftGroupResquestPacket extends Packet {


    private String groupId;
//    private String userName;
//    private boolean flag;

    @Override
    public Byte getCommand() {
        return Command.LEFT_GROUP_REQUEST;
    }
}
