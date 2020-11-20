package com.console;

import com.protocol.packet.request.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;


/**
 * @Class Login
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 14:42
 **/
public class Login implements ConsoleCommand{

    @Override
    public void exec(Scanner scanner, Channel channel) {

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.print("输入用户名登录: ");
        String username = scanner.nextLine();
        loginRequestPacket.setUserName(username);
        // 密码使用默认的
        loginRequestPacket.setPassW("123");
        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        //留出服务端的处理时间
        waitForLoginResponse();
    }

    public static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
