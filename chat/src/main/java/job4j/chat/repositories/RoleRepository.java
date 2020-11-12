package job4j.chat.repositories;

import job4j.chat.domain.Role;
import job4j.chat.domain.Room;
import org.springframework.data.repository.CrudRepository;

/**
 * @author madrabit on 09.11.2020
 * @version $
 * @since 0.1
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
}

