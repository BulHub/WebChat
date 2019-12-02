package ru.bulat.repositories;

public class User {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private String position;

    public User(Long id, String nickname, String email, String password, String position) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
