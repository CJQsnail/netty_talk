package com.server;

import com.handle.AuthHandler;
import com.handle.Spliter;
import com.handle.code.PacketDecoder;
import com.handle.code.PacketEncoder;
import com.handle.resquest.CreatGroupResquestHandle;
import com.handle.resquest.JoinGroupResquestHandle;
import com.handle.resquest.LoginRequestHandler;
import com.handle.resquest.MessageRequestHandler;
import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

/**
 * @Class NettyService
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/18 8:56
 **/
public class NettyService {

    private static final int PORT = 8080;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {


        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();


        ServerBootstrap server = new ServerBootstrap();
        server.group(boss,work)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new AuthHandler());
                        ch.pipeline().addLast(new MessageRequestHandler());
                        ch.pipeline().addLast(new CreatGroupResquestHandle());
                        ch.pipeline().addLast(new JoinGroupResquestHandle());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });

        bind(server, PORT,HOST);

    }
    private static void bind(final ServerBootstrap serverBootstrap, final int port,final String host) {
        serverBootstrap.bind(host,port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        });
    }
}
