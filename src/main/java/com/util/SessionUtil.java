package com.util;

import com.attribute.Attribute;
import com.session.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.AttributeKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Class SessionUtil
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:50
 **/
public class SessionUtil {


    private static final Map<String,Channel> idChannelMap = new ConcurrentHashMap<>();

    private static final Map<String,ChannelGroup> channelGroupMap = new ConcurrentHashMap<>();

    public static void saveStutas(Session session, Channel channel) {
        //保存channel
        idChannelMap.put(session.getUserId(),channel);
        //保存session
        channel.attr(Attribute.Session).set(session);
    }


    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attribute.Session);
    }

    public static Channel getChannel(String id) {

        return idChannelMap.get(id);
    }

    public static Session getSession(Channel channel){
        return channel.attr(Attribute.Session).get();
    }



    public static void saveChannelGroup(String groupId,ChannelGroup channels) {
        channelGroupMap.put(groupId,channels);
    }

    public static ChannelGroup getChannelGroup(String groupId) {
        return channelGroupMap.get(groupId);
    }

    public static void removeChannel(String groupId) {
        channelGroupMap.remove(groupId);
    }
}
