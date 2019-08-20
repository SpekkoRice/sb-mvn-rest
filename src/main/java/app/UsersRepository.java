package app;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
    List<User> findByAge(String lastName);
}
