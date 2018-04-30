package ru.bars.test.client.dto;

public class Credentials {

    private String user;
    private int hash;


    public Credentials() {
    }

    public Credentials(String user, int hash) {

        this.user = user;
        this.hash = hash;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
}
