package com.protocol.packet.response;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

import java.util.List;

/**
 * @Class CreatGroupResponsePacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 14:04
 **/
@Data
public class CreatGroupResponsePacket extends Packet {

    boolean flag;

    String groudId;
    List<String> userName;

    @Override
    public Byte getCommand() {
        return Command.CREAT_GROUP_RESPONSE;
    }
}
