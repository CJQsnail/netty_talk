package com.handle.response;

import com.protocol.packet.response.GetGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.Scanner;

/**
 * @Class GetGroupResponseHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 16:02
 **/
public class GetGroupResponseHandle extends SimpleChannelInboundHandler<GetGroupResponsePacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GetGroupResponsePacket msg) throws Exception {
        List<String> names = msg.getNames();
        if (msg.isFlag()){
            System.out.println("【群中有：" + names + "】");
        }
    }
}
