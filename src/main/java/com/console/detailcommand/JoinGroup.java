package com.console.detailcommand;

import com.command.Command;
import com.console.ConsoleCommand;
import com.protocol.packet.request.JoinGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Class JoinGroup
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 16:19
 **/
public class JoinGroup implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.print("输入 groupId，加入群聊：");
        String groupId = scanner.next();

        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
