package com.handle.response;

import com.protocol.packet.response.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Class JoinGroupResponseHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 16:52
 **/
public class JoinGroupResponseHandle extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket msg) throws Exception {

        String groupId = msg.getGroupId();
        String useId = msg.getUseId();
        String msgMsg = msg.getMsg();
        System.out.println("【用户："+useId+" 加入群组，群id为： " + groupId);
    }
}
