package Journal.Application.Pintilie.Victor.Services;

import Journal.Application.Pintilie.Victor.Entities.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
}
