package Journal.Application.Pintilie.Victor.Services;

import Journal.Application.Pintilie.Victor.Entities.User;
import Journal.Application.Pintilie.Victor.Exceptions.UserNotFoundException;
import Journal.Application.Pintilie.Victor.Exceptions.UserRegistrationException;
import Journal.Application.Pintilie.Victor.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserRegistrationException("Username already exists");
        }

        // You can add more validation checks here, e.g., for password strength

        // If validation passes, save the user
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        // Check if the user exists
        if (!userRepository.existsById(user.getId())) {
            throw new UserNotFoundException("User not found");
        }

        // Add validation and update logic here

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        // Check if the user exists
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User not found");
        }

        // Add logic to handle user deletion
        userRepository.deleteById(userId);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Other user-related methods
}


