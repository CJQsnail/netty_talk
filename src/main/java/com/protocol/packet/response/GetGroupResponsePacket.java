package com.protocol.packet.response;

import com.command.Command;
import com.protocol.packet.Packet;
import lombok.Data;

import java.util.List;

/**
 * @Class GetGroupResponsePacket
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:59
 **/
@Data
public class GetGroupResponsePacket extends Packet {

    private boolean flag;
    private List<String> names;
    @Override
    public Byte getCommand() {
        return Command.GET_GROUPNUM_RESPONSE;
    }
}
