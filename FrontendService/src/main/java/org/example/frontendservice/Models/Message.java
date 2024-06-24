package org.example.frontendservice.Models;

public class Message {
    private int id;
    private String text;
    private String encryptedText;

    public Message() {}

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", encryptedText='" + encryptedText + '\'' +
                '}';
    }

    public Message(int id, String text, String encryptedText) {
        this.id = id;
        this.text = text;
        this.encryptedText = encryptedText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }

}
