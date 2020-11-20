package com.console.detailcommand;


import com.console.ConsoleCommand;
import com.protocol.packet.request.CreatGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Class GreatGroup
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 14:31
 **/
public class GreatGroup implements ConsoleCommand {

    private final String SPLIT_FLAG = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {

        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");
        CreatGroupRequestPacket requestPacket = new CreatGroupRequestPacket();
        String[] split = scanner.next().split(SPLIT_FLAG);
        List<String> list = Arrays.asList(split);
        requestPacket.setUserIds(list);
        channel.writeAndFlush(requestPacket);
    }
}
