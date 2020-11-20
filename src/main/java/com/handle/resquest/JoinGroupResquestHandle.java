package com.handle.resquest;

import com.protocol.packet.request.JoinGroupRequestPacket;
import com.protocol.packet.response.JoinGroupResponsePacket;
import com.session.Session;
import com.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @Class JoinGroupResquestHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 16:23
 **/
public class JoinGroupResquestHandle extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket msg) throws Exception {

        //1.获取请求体中的群聊id
        String groupId = msg.getGroupId();

        //2.从sessionUtil中获取之前保存的channel分组
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        Session session = SessionUtil.getSession(ctx.channel());

        //3.将该用户的channel加入channel分组中
        channelGroup.add(ctx.channel());
        //Channel channel = SessionUtil.getChannel(userId);

        //4.创建群发对象
        JoinGroupResponsePacket response = new JoinGroupResponsePacket();
        response.setGroupId(groupId);
        response.setUseId(session.getUserId());

        //5.发送
        ctx.channel().writeAndFlush(response);



    }
}
