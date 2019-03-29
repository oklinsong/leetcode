package com.sangang.test;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        User user1 = new User(1, "u1", 1);
        User user2 = new User(2, "u2", 2);
        User user3 = new User(3, "u3", 3);
        User user4 = new User(4, "u4", 3);
        User user5 = new User(5, "u5", 3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        Map<Integer, List<User>> listMap = users.stream().collect(Collectors.groupingBy(User::getParentId, Collectors.<User>toList()));
        listMap.forEach((k, v) -> {
            System.out.println(k + ":" + v.toString());
        });
        users.stream().sorted(Comparator.comparing(User::getId));
        System.out.println(users.stream().filter(u->u.getId()>3).count());
    }
}

class User {
    private int id;
    private String name;
    private int parentId;

    public User(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
