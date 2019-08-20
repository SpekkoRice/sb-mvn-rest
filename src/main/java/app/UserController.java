package app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UsersRepository userRepository;

    public UserController(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    private List<User> getAllUsers() throws Exception {
        try {
            List<User> users = new ArrayList<>();
            userRepository.findAll().forEach(users::add);
            return users;
        } catch (Exception e) {
            throw new Exception("Woops something went wrong");
        }
    }

    @GetMapping(value = "/users", produces = "application/json")
    public @ResponseBody List<User> index() {
        try {
            return this.getAllUsers();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/users/{id}", produces = "application/json")
    public @ResponseBody User show(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping(value = "/users", produces = "application/json")
    public @ResponseBody User create(@RequestBody User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping(value = "/users/{id}", produces = "application/json")
    public @ResponseBody User update(@PathVariable Long id, @RequestBody User userData) {
        try {
            User user = userRepository.findById(id).get();
            if(userData.getAge() != null) user.setAge(userData.getAge());
            if(userData.getEmail() != null) user.setEmail(userData.getEmail());
            if(userData.getName() != null) user.setName(userData.getName());
            return userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping(value = "/users/{id}", produces = "application/json")
    public @ResponseBody List<User> remove(@PathVariable Long id) {
        try {
            User user = userRepository.findById(id).get();
            userRepository.delete(user);
            return this.getAllUsers();
        } catch (Exception e) {
            return null;
        }
    }

}