package com.handle.resquest;

import com.protocol.packet.response.LeftGroupResponsePacket;
import com.protocol.packet.request.LeftGroupResquestPacket;
import com.session.Session;
import com.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @Class LeftGroupResquestHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/20 15:22
 **/
public class LeftGroupResquestHandle extends SimpleChannelInboundHandler<LeftGroupResquestPacket> {



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LeftGroupResquestPacket msg) throws Exception {

        String groupId = msg.getGroupId();
        Session session = SessionUtil.getSession(ctx.channel());
        String userName = session.getUserName();
        ChannelGroup group = SessionUtil.getChannelGroup(groupId);
        LeftGroupResponsePacket responsePacket = new LeftGroupResponsePacket();
        if(group == null){
            System.out.println("该群组并不存在。。。。");
        }
        if (group != null){
            group.remove(ctx.channel());
            //SessionUtil.removeChannel(groupId);
            responsePacket.setFlag(true);
            responsePacket.setUserName(userName);
            System.out.println("【用户："+ userName +"已经退出群聊。。。】");
        }

        ctx.channel().writeAndFlush(responsePacket);



    }
}
