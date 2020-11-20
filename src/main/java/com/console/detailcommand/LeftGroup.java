package com.console.detailcommand;

import com.console.ConsoleCommand;
import com.protocol.packet.request.LeftGroupResquestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Class LeftGroup
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 16:22
 **/
public class LeftGroup implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {
        LeftGroupResquestPacket leftGroupResquestPacket = new LeftGroupResquestPacket();

        System.out.print("输入 groupId，退出群聊：");
        String groupId = scanner.next();

        leftGroupResquestPacket.setGroupId(groupId);
        channel.writeAndFlush(leftGroupResquestPacket);
    }
}
