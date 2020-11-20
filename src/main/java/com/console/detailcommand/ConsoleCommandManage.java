package com.console.detailcommand;


import com.console.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Class ConsoleCommandManage
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 14:26
 **/
public class ConsoleCommandManage implements ConsoleCommand {

    private Map<String,ConsoleCommand> commandMap = new HashMap<>();

    public ConsoleCommandManage(){
        commandMap.put("sendToUser",new SendToUser());
        commandMap.put("logout",new Logout());
        commandMap.put("cg",new GreatGroup());
        commandMap.put("login",new Login());
        commandMap.put("jg",new JoinGroup());
        commandMap.put("lg",new LeftGroup());
        commandMap.put("getNum",new GetGroupNum());
    }


    @Override
    public void exec(Scanner scanner, Channel channel) {

        //控制台获取指令
        String command = scanner.nextLine();

        //选择对应的指令类
        ConsoleCommand consoleCommand = commandMap.get(command);
        if (consoleCommand != null) {
            consoleCommand.exec(scanner,channel);
        }
//        else {
//            System.err.println("无法识别[" + command + "]指令，请重新输入!");
//        }


    }
}
