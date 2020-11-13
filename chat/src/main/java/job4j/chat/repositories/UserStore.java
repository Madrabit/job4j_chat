package job4j.chat.repositories;

import job4j.chat.domain.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author madrabit on 13.11.2020
 * @version 1$
 * @since 0.1
 */
@Component
public class UserStore {
    private final ConcurrentHashMap<String, Person> users = new ConcurrentHashMap<>();

    public void save(Person person) {
        users.put(person.getUsername(), person);
    }

    public Person findUserByName(String username) {
        return users.get(username);
    }

    public List<Person> findAll() {
        return  new ArrayList<>(users.values());
    }
}
