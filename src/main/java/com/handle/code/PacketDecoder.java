package com.handle.code;

import com.protocol.packet.Packet;
import com.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Class PacketDecoder
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:41
 **/
public class PacketDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        Packet decode = PacketCodeC.INSTANCE.decode(in);
        out.add(decode);
    }
}
