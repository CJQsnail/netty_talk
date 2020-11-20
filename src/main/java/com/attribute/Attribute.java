package com.attribute;

import com.session.Session;
import io.netty.util.AttributeKey;

/**
 * @Class Attribute
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:55
 **/
public interface Attribute {


    AttributeKey<Session> Session =  AttributeKey.newInstance("session");
}
