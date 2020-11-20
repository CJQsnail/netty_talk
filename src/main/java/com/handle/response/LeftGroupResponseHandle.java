package com.handle.response;

import com.protocol.packet.response.LeftGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Class LeftGroupResponseHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:38
 **/
public class LeftGroupResponseHandle extends SimpleChannelInboundHandler<LeftGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LeftGroupResponsePacket msg) throws Exception {
        String name = msg.getUserName();
        if (msg.isFlag()){
            System.out.println("【用户：" + name + "退出群聊成功。。。】");
        }
    }
}
