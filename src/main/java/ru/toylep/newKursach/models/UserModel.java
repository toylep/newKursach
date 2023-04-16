package ru.toylep.newKursach.models;

import lombok.Data;

@Data
public class UserModel {
    private Long id;
    private String groups;
    private String name;
    private String lastName;
    private String login;
    private String password;

    public UserModel() {}

    public UserModel(String groups, String name, String lastName, String login, String password) {
        this.groups = groups;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

























}
