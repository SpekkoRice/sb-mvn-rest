package app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    // We'll make the indexes their id's
    private ArrayList<User> users;

    public UserController() {
        this.users = new ArrayList<User>();
        for(int i = 0; i < 3; i++) {
            this.users.add(new User().randomize());
        }

    }

    @GetMapping(value = "/users", produces = "application/json")
    public @ResponseBody ArrayList<User> index() {
        return this.users;
    }

    @GetMapping(value = "/users/{index}", produces = "application/json")
    public @ResponseBody User show(@PathVariable Integer index) {
        try {
            return this.users.get(index);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(value = "/users", produces = "application/json")
    public @ResponseBody User create(@RequestBody User user) {
        try {
            this.users.add(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(value = "/users/{index}", produces = "application/json")
    public @ResponseBody User update(@PathVariable Integer index, @RequestBody User userData) {
        try {
            User user = this.users.get(index);
            if (userData.getAge() != null) user.setAge(userData.getAge());
            if (userData.getName() != null) user.setName(userData.getName());
            if (userData.getName() != null) user.setEmail(userData.getEmail());
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping(value = "/users/{index}", produces = "application/json")
    public @ResponseBody ArrayList<User> remove(@PathVariable Integer index) {
        try {
            this.users.remove(index.intValue());
            return this.users;
        } catch (Exception e) {
            return null;
        }
    }

}