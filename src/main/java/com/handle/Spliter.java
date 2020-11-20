package com.handle;

import com.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @Class Spliter
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 15:07
 **/

public class Spliter extends LengthFieldBasedFrameDecoder {

    public static final int lengthFieldOffset = 7;
    public static final int lengthFieldLength = 4;

    public Spliter() {
        super(Integer.MAX_VALUE, lengthFieldOffset, lengthFieldLength);
    }

    //协议魔数判断
    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {

//        byte b = in.readByte();
//        int inInt = in.getInt(b);
        int i = in.readerIndex();
        int inInt = in.getInt(i);
        if(inInt != PacketCodeC.MAGIC_NUMBER){
            ctx.channel().close();
            return null;
        }
        return super.decode(ctx, in);
    }
}
