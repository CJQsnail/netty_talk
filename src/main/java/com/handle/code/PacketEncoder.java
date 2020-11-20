package com.handle.code;

import com.protocol.packet.Packet;
import com.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Class PacketEncoder
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 17:11
 **/
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(out,msg);
    }
}
