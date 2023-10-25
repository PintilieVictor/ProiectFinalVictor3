package Journal.Application.Pintilie.Victor.Configuration;

import Journal.Application.Pintilie.Victor.Entities.Role;
import Journal.Application.Pintilie.Victor.Entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends org.springframework.security.core.userdetails.User {
    private User user;

    public CustomUserDetails(User user) {
        super(user.getUsername(), user.getPassword(), getAuthorities(user));
        this.user = user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        }
        return authorities;
    }

    public User getUser() {
        return user;
    }
}


