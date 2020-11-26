package com.client;

import com.console.detailcommand.ConsoleCommandManage;
import com.console.detailcommand.Login;
import com.handle.*;
import com.handle.code.PacketDecoder;
import com.handle.code.PacketEncoder;
import com.handle.response.*;
import com.util.SessionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * @Class NettyClient
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 14:53
 **/
public class NettyClient {

    private static final int MAX_RETRY = 5;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8080;


    public static void main(String[] args) {

        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap
                .group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginResponseHandler());
                        ch.pipeline().addLast(new MessageResponseHandler());
                        ch.pipeline().addLast(new CreatGroupResponseHandle());
                        ch.pipeline().addLast(new JoinGroupResponseHandle());
                        ch.pipeline().addLast(new LeftGroupResponseHandle());
                        ch.pipeline().addLast(new GetGroupResponseHandle());
                        ch.pipeline().addLast(new GroupMessageResponseHandler());
                        //TODO：客户端一般先解码
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });
        connect(bootstrap,HOST, PORT, MAX_RETRY);

    }

    private static void connect(Bootstrap bootstrap, String host, int port, int maxRetry) {

        bootstrap.connect(host,port).addListener(future -> {
            //连接成功
           if(future.isSuccess()){
               ChannelFuture channelFuture = (ChannelFuture) future;
               Channel channel = channelFuture.channel();
               System.out.println("连接成功，启动控制台程序。。。");
               startConsoleThread(channel);
           }
//           //连接次数用完
//           else if(maxRetry == 0){
//
//           }
//           //处理连接次数
//           else {
//
//           }
        });


    }

    private static void startConsoleThread(Channel channel) {
        Scanner sc = new Scanner(System.in);

        ConsoleCommandManage commandManage = new ConsoleCommandManage();
        Login login = new Login();
        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                    login.exec(sc,channel);
                } else {
                    //System.out.println("请输出操作指令：");
                    commandManage.exec(sc,channel);
                }
            }
        }).start();
    }



}
