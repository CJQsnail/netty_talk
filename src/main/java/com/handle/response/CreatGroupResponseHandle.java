package com.handle.response;

import com.protocol.packet.response.CreatGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Class CreatGroupResponseHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 14:15
 **/
public class CreatGroupResponseHandle extends SimpleChannelInboundHandler<CreatGroupResponsePacket> {



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreatGroupResponsePacket msg) throws Exception {
        System.out.print("群创建成功，id 为[" + msg.getGroudId() + "], ");
        System.out.println("群里面有：" + msg.getUserName());
    }
}
