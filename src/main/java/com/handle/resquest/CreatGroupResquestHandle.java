package com.handle.resquest;

import com.protocol.packet.request.CreatGroupRequestPacket;
import com.protocol.packet.response.CreatGroupResponsePacket;
import com.session.Session;
import com.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Class CreatGroupResquestHandle
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 13:53
 **/

public class CreatGroupResquestHandle extends SimpleChannelInboundHandler<CreatGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreatGroupRequestPacket msg) throws Exception {

        //1.获取到ids
        List<String> ids = msg.getUserIds();
        List<String> names = new ArrayList<>();

        //2.循环判断ids对应的channel是否存在,使用ChannelGroup保存
        //创建一个channel分组
        ChannelGroup channels = new DefaultChannelGroup(ctx.executor());
        for (String id : ids) {
            Channel channel = SessionUtil.getChannel(id);
            if(channel != null){
                Session session = SessionUtil.getSession(channel);
                names.add(session.getUserName());
                channels.add(channel);

            }
        }

        //3.构建响应信息
        String groupId = UUID.randomUUID().toString().split("-")[0];
        CreatGroupResponsePacket response = new CreatGroupResponsePacket();
        response.setFlag(true);
        response.setUserName(names);
        response.setGroudId(groupId);

        //4.保存已经存在的channels
        SessionUtil.saveChannelGroup(groupId,channels);

        //5.给每个客户端发送拉群通知
        channels.writeAndFlush(response);
        System.out.println("服务端创建群聊成功。。。群id为：" + groupId);
    }
}
