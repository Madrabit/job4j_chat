package job4j.chat.security;

import job4j.chat.domain.Person;
import job4j.chat.repositories.UserStore;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author madrabit on 13.11.2020
 * @version 1$
 * @since 0.1
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserStore userStore;

    public UserDetailsServiceImpl(UserStore userStore) {
        this.userStore = userStore;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = userStore.findUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
