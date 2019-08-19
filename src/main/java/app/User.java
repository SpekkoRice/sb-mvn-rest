package app;

import java.util.Random;

class User {

    private String name;
    private String email;
    private Integer age;
    private String ageStatus;

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
    public String getAgeStatus() { return ageStatus; }

    User setAge(Integer age) throws Exception {
        if (age < 0) throw new Exception("Age cannot be less than 0");
        this.age = age;
        if (age < 30) {
            this.ageStatus = "Young";
        } else if (age < 60) {
            this.ageStatus = "Middle Aged";
        } else {
            this.ageStatus = "Old";
        }
        return this;
    }

    User setEmail(String email) {
        this.email = email;
        return this;
    }

    User setName(String name) {
        this.name = name;
        return this;
    }
}
