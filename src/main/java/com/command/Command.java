package com.command;

/**
 * @Interface Command
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:20
 **/
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

    Byte CREAT_GROUP_REQUEST = 5;

    Byte CREAT_GROUP_RESPONSE = 6;

    Byte JOIN_GROUP_REQUEST= 7;

    Byte JOIN_GROUP_RESPONSE = 8;

}
