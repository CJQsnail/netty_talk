package com.handle.response;

import com.protocol.packet.response.LoginResponsePacket;
import com.session.Session;
import com.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Class LoginResponseHandler
 * @Desc 客户端响应处理器
 * @Author CJQ
 * @Class 2020/11/17 16:44
 **/
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {

        String id = msg.getUserId();
        String name = msg.getUserName();
        if(msg.isStatus()){
            System.out.println("[" + name + "]登录成功，userId 为: " + id);

            //保存登陆状态
            SessionUtil.saveStutas(new Session(id,name),ctx.channel());
        }else {
            System.out.println("用户名 "+ name + "登陆失败"+"原因是：" + msg.getMsg());
        }



    }
}
