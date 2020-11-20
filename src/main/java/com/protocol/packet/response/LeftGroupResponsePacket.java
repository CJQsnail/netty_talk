package com.protocol.packet.response;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class LeftGroupResponsePacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:34
 **/
@Data
public class LeftGroupResponsePacket extends Packet {

    private boolean flag;
    private String userName;

    @Override
    public Byte getCommand() {
        return Command.LEFT_GROUP_RESPONSE;
    }
}
