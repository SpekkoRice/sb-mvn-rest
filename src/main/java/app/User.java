package app;

import java.util.Random;

public class User {

    private String name;
    private String email;
    private Integer age;

    User() {
        // constructor
    }

    User randomize() {
        this.age = this.randomAge();
        this.email = this.randomEmail();
        this.name = this.randomName();
        return this;
    }

    private int randomAge() {
        return this.randomNumber(99);
    }

    private String randomName() {
        String[] names = new String[] {
            "John",
            "Mary",
            "Sarah",
            "Felix",
            "Harry",
            "Scarlett",
        };
        return names[randomNumber(names.length)];
    }

    private String randomEmail() {
        String[] names = new String[] {
            "user1@example.com",
            "user2@example.com",
            "user3@example.com",
            "user4@example.com",
            "user5@example.com",
            "user6@example.com",
        };
        return names[this.randomNumber(names.length)];
    }

    private int randomNumber(int bounds) {
        Random r = new Random();
        return r.nextInt(bounds);
    }

    public Integer getAge() { return age; }
    public String getEmail() { return email; }
    public String getName() { return name; }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
