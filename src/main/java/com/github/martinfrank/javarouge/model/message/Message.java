package com.github.martinfrank.javarouge.model.message;

public class Message {

    public enum Type {TEXT}

    public final Type type;
    public final Object content;

    public Message(Type type, Object content) {
        this.type = type;
        this.content = content;
    }

    public Message(Type type) {
        this(type, null);
    }
}
