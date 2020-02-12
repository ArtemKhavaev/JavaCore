package com.domain.lesson16Lambda;

import java.util.function.Consumer;

public class UserConsumer {
    public static void main(String[] args) {
        //UserFactory<User> factory = (name, age) -> new User(name, age);// равнозначная запись ->
        UserFactory<User> factory = User::new;//ссылка на конструктор
        User user1 = factory.create("Tom", 38);
        User user2 = factory.create("Tim", 44);

        Consumer<User> update = user -> { // void accept (T, t);
            user.setAge(22);
            user.setName("Paul");
        };
        update.accept(user1);// вызов метода
    }
}

@FunctionalInterface
interface UserFactory<T extends User>{
    T create(String name, int age);
}



class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
