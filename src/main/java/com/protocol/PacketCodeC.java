package com.protocol;


import com.protocol.packet.*;
import com.protocol.packet.request.*;
import com.protocol.packet.response.*;
import com.serialize.Serialize;
import com.serialize.SerializeImpl;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Map;

import static com.command.Command.*;

/**
 * @Class PacketCodeC
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 15:18
 **/

public class PacketCodeC {


    public static final int MAGIC_NUMBER = 0x1234567;

    private final Map<Byte,Class<? extends Packet>> packetTypeMap;
    private final Map<Byte,Serialize> serializerMap;

    public static final PacketCodeC INSTANCE = new PacketCodeC();


    PacketCodeC(){

        //初始化请求数据包类型
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);
        packetTypeMap.put(CREAT_GROUP_REQUEST, CreatGroupRequestPacket.class);
        packetTypeMap.put(CREAT_GROUP_RESPONSE, CreatGroupResponsePacket.class);
        packetTypeMap.put(JOIN_GROUP_REQUEST, JoinGroupRequestPacket.class);
        packetTypeMap.put(JOIN_GROUP_RESPONSE, JoinGroupResponsePacket.class);
        packetTypeMap.put(LEFT_GROUP_REQUEST, LeftGroupResquestPacket.class);
        packetTypeMap.put(LEFT_GROUP_RESPONSE, LeftGroupResponsePacket.class);
        packetTypeMap.put(GET_GROUPNUM_REQUEST,GetGroupResquestPacket.class);
        packetTypeMap.put(GET_GROUPNUM_RESPONSE,GetGroupResponsePacket.class);


        //初始化序列化算法
        serializerMap = new HashMap<>();
        Serialize serializer = new SerializeImpl();
        serializerMap.put(serializer.getSerialize(), serializer);




    }


    /**
     * 编码
     */
    public void encode(ByteBuf byteBuf, Packet packet){

        //1.对数据包序列化
        SerializeImpl serialize = new SerializeImpl();
        byte[] bytes = serialize.ObjectToByte(packet);
//        byte[] bytes = Serialize.s.ObjectToByte(packet);

        //2.编码
        //设置魔数
       byteBuf.writeInt(MAGIC_NUMBER);
       //设置版本
       byteBuf.writeByte(packet.getVersion());
       //设置序列化算法
       byteBuf.writeByte(serialize.getSerialize());
       //设置指令
       byteBuf.writeByte(packet.getCommand());
       /*
          TODO：错误点 设置数据长度。导致server端的handle无法往下传值
          byteBuf.writeByte(bytes.length);
       */
       byteBuf.writeInt(bytes.length);
       //设置数据
       byteBuf.writeBytes(bytes);
    }


    /**
     * 解码
     */
    public Packet decode(ByteBuf byteBuf){

        //跳过魔数
        byteBuf.skipBytes(4);

        //跳过版本号
        byteBuf.skipBytes(1);

        //获取序列化算法
        byte serializeAlgorithm = byteBuf.readByte();

        //获取指令
        byte command = byteBuf.readByte();

        //获取数据包长度
        int length = byteBuf.readInt();


        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);


        //获取到指令的类型
        Class<? extends Packet> requestType = getRequestType(command);
        //获取到序列化算法
        Serialize serializer = getSerializer(serializeAlgorithm);
        if(requestType != null && serializer != null){
            return serializer.ByteToObject(requestType,bytes);
        }
        return null;
    }



    private Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }

    private Serialize getSerializer(byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }
}
