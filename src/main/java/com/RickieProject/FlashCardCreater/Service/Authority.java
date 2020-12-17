package com.RickieProject.FlashCardCreater.Service;

import com.RickieProject.FlashCardCreater.Model.Role;
import org.springframework.security.core.GrantedAuthority;



public class Authority implements GrantedAuthority {
    Role role;

    Authority(Role role){
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role.getName();
    }
}
