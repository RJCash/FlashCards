package com.RickieProject.FlashCardCreater.Service;

import com.RickieProject.FlashCardCreater.Model.Role;
import com.RickieProject.FlashCardCreater.Model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CustomUserDetails implements UserDetails {

    private User user;
    long id;
    String name;
    String username;
    String password;
    private Set<Authority> _grntdAuths = new HashSet<>();


    CustomUserDetails(User user) {
        this.user = user;
        this._grntdAuths = getAuthorities();
        this.id = this.user.getUserID();
        this.name = this.user.getName();
        this.username = getUsername();
        this.password = getPassword();

        //Display role to console (test)
//        Iterator<Authority> itr = _grntdAuths.iterator();
//        while(itr.hasNext()){
//            System.out.println( itr.next().getAuthority() );
//        }


    }

    @Override
    public Set<Authority> getAuthorities() {
        for (Role role:this.user.getRoles()) {
            _grntdAuths.add(new Authority(role));
        }
        return _grntdAuths;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "user=" + user +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", _grntdAuths=" + _grntdAuths +
                '}';
    }

    @Override
    public String getPassword() {
        if (this.user == null) {
            return null;
        }
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        if (this.user == null) {
            return null;
        }
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return this.user;
    }
}