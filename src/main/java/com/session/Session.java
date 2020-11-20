package com.session;

import lombok.Data;

/**
 * @Class Session
 * @Desc Todo
 * @Author CJQ
 * @Class 2020/11/17 16:52
 **/
@Data
public class Session {

    private String userId;
    private String userName;

    public Session(String id, String name) {
        this.userId = id;
        this.userName = name;
    }
}
