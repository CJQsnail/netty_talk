package com.serialize;

/**
 * @Interface Serialize
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 15:33
 **/
public interface Serialize {


//    Serialize s = new SerializeImpl();


    //序列化算法
    byte getSerialize();


    //对象转二进制
    byte[] ObjectToByte(Object object);


    //二进制转对象
    <T> T ByteToObject(Class<T> clazz,byte[] bytes);


}
