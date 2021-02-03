package com.RickieProject.FlashCardCreater.Database;

import com.RickieProject.FlashCardCreater.Model.Role;
import com.RickieProject.FlashCardCreater.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User save(User user, UserRepo repo){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        //setup user with roles
        Set<Role> roles = user.getRoles();
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setDescription("none");
        roles.add(role);
        user.setRoles(roles);
        //setup role with users
        Set<User> users = role.getUsers();
        users.add(user);
        role.setUsers(users);

        return repo.save(user);
    }
}
