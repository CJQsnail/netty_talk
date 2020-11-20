package com.protocol.packet.response;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

/**
 * @Class JoinGroupResponsePacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 16:52
 **/
@Data
public class JoinGroupResponsePacket extends Packet {

    private String groupId;
    private String useId;
    private String msg;



    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_RESPONSE;
    }
}
