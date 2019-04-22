package com.molice.entity;

import java.io.Serializable;

/**
 * @author molice
 * @date 2019/4/22
 **/
public class Order implements Serializable {

    private static final long serialVersionUID = -107293322990163984L;

    private String id;

    private String name;

    private String messageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}