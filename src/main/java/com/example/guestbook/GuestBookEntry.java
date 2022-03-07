package com.example.guestbook;

public class GuestBookEntry {
    private String nick;
    private String content;

    public GuestBookEntry(String nick, String content) {
        this.nick = nick;
        this.content = content;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return nick + ": " + content;
    }
}
