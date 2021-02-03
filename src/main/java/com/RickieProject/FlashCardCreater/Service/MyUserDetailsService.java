package com.RickieProject.FlashCardCreater.Service;

import com.RickieProject.FlashCardCreater.Database.UserRepo;
import com.RickieProject.FlashCardCreater.Model.User;
import com.RickieProject.FlashCardCreater.Security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo repo;


    // Converts CustomUserDetails to spring.springframework.security.core.userdetails.User
    private User getUserFromCustomUserDetails(CustomUserDetails cUserDetails) {
        return (cUserDetails.getUser());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByusername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        //encrypt test users with unencrypted password
//        if(user.getUsername().equals("RJC@username") || user.getUsername().equals("bob@username")){
//            user.setPassword(SecurityConfig.encoder.encode(user.getPassword()));
//        }

        CustomUserDetails userDetails = new CustomUserDetails(user);
        System.out.println(userDetails.toString());
        return userDetails;
    }

    public UserDetails loadUserDetailsByUser(User user) throws UsernameNotFoundException {
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        user.toString();

        //encrypt test users with unencrypted password
//        if(user.getUsername().equals("RJC@username") || user.getUsername().equals("bob@username")){
//            user.setPassword(SecurityConfig.encoder.encode(user.getPassword()));
//        }

        CustomUserDetails userDetails = new CustomUserDetails(user);
        return userDetails;
    }


}
