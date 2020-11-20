package com.console.detailcommand;

import com.command.Command;
import com.console.ConsoleCommand;
import com.protocol.packet.request.GetGroupResquestPacket;
import com.protocol.packet.request.LeftGroupResquestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Class GetGroupNum
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:50
 **/
public class GetGroupNum implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {
        GetGroupResquestPacket getGroupResquestPacket = new GetGroupResquestPacket();

        System.out.print("输入 groupId，查询群成员。");
        String groupId = scanner.next();

        getGroupResquestPacket.setGroupId(groupId);
        channel.writeAndFlush(getGroupResquestPacket);
    }
}
