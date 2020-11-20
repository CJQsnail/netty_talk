package com.handle.resquest;

import com.protocol.packet.request.LoginRequestPacket;
import com.protocol.packet.response.LoginResponsePacket;
import com.session.Session;
import com.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @Class LoginRequestHandler
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/18 9:03
 **/
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {

        LoginResponsePacket response = new LoginResponsePacket();
        response.setVersion(msg.getVersion());
        response.setUserName(msg.getUserName());
        String id = null;
        if(verifit(msg)){
            //1.构建返回对象
            response.setStatus(true);
            id = UUID.randomUUID().toString().split("-")[0];
            response.setUserId(id);
            //2.保存用户登陆状态
            SessionUtil.saveStutas(new Session(id,msg.getUserName()),ctx.channel());
            System.out.println("登陆成功。。。");
        }else {
            response.setStatus(false);
            System.out.println("登陆失败 ");
            response.setMsg("密码错误或者账号错误");
        }
        //3.写出返回对象
        ctx.channel().writeAndFlush(response);
    }

    private boolean verifit(LoginRequestPacket msg) {
//        if(msg == null || msg.getUserName() ==null || msg.getPassW() ==null) {return false;}
//        if("cjq".equals(msg.getUserName()) && "123".equals(msg.getPassW())){
//            return true;
//        }else {
//            return false;
//        }
        return true;

    }
}
