package com.protocol.packet.request;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

import java.util.List;

/**
 * @Class CreatGroupRequestPacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 13:55
 **/
@Data
public class CreatGroupRequestPacket extends Packet {


    private List<String> userIds;


    @Override
    public Byte getCommand() {
        return Command.CREAT_GROUP_REQUEST;
    }
}
