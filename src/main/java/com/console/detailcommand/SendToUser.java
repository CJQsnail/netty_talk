package com.console.detailcommand;

import com.console.ConsoleCommand;
import com.protocol.packet.request.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Class SendToUser
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 14:30
 **/
public class SendToUser implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输出聊天对象id: ");
        String toUserId = scanner.next();
        System.out.println("请输出聊天消息: ");
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
