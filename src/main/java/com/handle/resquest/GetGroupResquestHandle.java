package com.handle.resquest;

import com.protocol.packet.request.GetGroupResquestPacket;
import com.protocol.packet.response.GetGroupResponsePacket;
import com.session.Session;
import com.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class GetGroupResquestHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:54
 **/
public class GetGroupResquestHandle extends SimpleChannelInboundHandler<GetGroupResquestPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GetGroupResquestPacket msg) throws Exception {

        String groudId = msg.getGroupId();
        List<String> names = new ArrayList<>();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groudId);

        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            names.add(session.getUserName());
        }

        GetGroupResponsePacket responsePacket = new GetGroupResponsePacket();
        responsePacket.setFlag(true);
        responsePacket.setNames(names);

        ctx.channel().writeAndFlush(responsePacket);

    }
}
