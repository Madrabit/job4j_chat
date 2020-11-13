package job4j.chat.controllers;

import job4j.chat.domain.Person;
import job4j.chat.repositories.UserStore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author madrabit on 13.11.2020
 * @version 1$
 * @since 0.1
 */

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserStore users;
    private final BCryptPasswordEncoder encoder;

    public UserController(UserStore users, BCryptPasswordEncoder encoder) {
        this.users = users;
        this.encoder = encoder;
    }

    @PostMapping("/sign-up")
    public void singUp(@RequestBody Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
        users.save(person);
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return users.findAll();
    }
}
