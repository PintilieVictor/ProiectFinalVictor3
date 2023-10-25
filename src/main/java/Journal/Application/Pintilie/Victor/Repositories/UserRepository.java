package Journal.Application.Pintilie.Victor.Repositories;

import Journal.Application.Pintilie.Victor.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
