package com.serialize;

import com.alibaba.fastjson.JSON;

/**
 * @Class SerializeImpl
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 15:45
 **/
public class SerializeImpl implements Serialize {


    @Override
    public byte getSerialize() {
        return 1;
    }

    @Override
    public byte[] ObjectToByte(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T ByteToObject(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes,clazz);
    }
}
