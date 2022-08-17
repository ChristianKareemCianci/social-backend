package com.example.messages.entity;

public class MessageDto {

    private int id;

    private String text;

    private int fromUserId;

    private int toUserId;

    public MessageDto() {
    }

    public MessageDto( String text, int fromUserId, int toUserId) {
        this.text = text;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
    }

    public MessageDto( String text, int fromUserId, int toUserId, int id) {
        this.text = text;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }
}
