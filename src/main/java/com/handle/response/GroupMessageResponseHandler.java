package com.handle.response;

import com.protocol.packet.response.GroupMessageResponsePacket;
import com.session.Session;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Class GroupMessageResponseHandler
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/26 15:48
 **/
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket msg) throws Exception {
        String fromGroupId = msg.getFromGroupId();
        Session fromUser = msg.getFromUser();
        System.out.println("收到群[" + fromGroupId + "]中[" + fromUser + "]发来的消息：" + msg.getMessage());

    }
}
