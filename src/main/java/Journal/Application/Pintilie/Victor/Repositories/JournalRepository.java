package Journal.Application.Pintilie.Victor.Repositories;
import Journal.Application.Pintilie.Victor.Entities.User;
import Journal.Application.Pintilie.Victor.Entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findByUser(User user);
}

