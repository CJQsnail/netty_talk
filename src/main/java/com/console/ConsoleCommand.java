package com.console;


import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Class ConsoleCommand
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/19 14:25
 **/
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
