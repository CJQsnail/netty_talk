package com.handle.resquest;

import com.protocol.packet.request.MessageRequestPacket;
import com.protocol.packet.response.MessageResponsePacket;
import com.session.Session;
import com.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Class MessageRequestHandler
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/18 9:43
 **/
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {


        //1。拿到消息请求体中必要信息
        String toUserId = msg.getToUserId();
        String message = msg.getMessage();

        //2.先获取到session

        Session session = SessionUtil.getSession(ctx.channel());

        //3.构建消息返回对象
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setFromUserId(session.getUserId());
        responsePacket.setFromUserName(session.getUserName());
        responsePacket.setMessage(message);

        //4.根据toUserId 那到对应的channel
        Channel channel = SessionUtil.getChannel(toUserId);

        //5.数据写出(先判断是否存在和登陆)
        if (channel != null && SessionUtil.hasLogin(channel)) {
            channel.writeAndFlush(responsePacket);
        } else {
            System.err.println("[" + msg.getToUserId() + "] 不在线，发送失败!");
        }

        //TODO:猜测toUserId应该和session保存中的id是一样的
        System.out.println("toUserId" + toUserId);
        System.out.println("session保存的id"+ session.getUserId());



    }
}
