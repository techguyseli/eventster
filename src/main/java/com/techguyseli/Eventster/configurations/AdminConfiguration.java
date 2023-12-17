package com.techguyseli.Eventster.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.techguyseli.Eventster.entities.Admin;

import lombok.Setter;

@Component
@ConfigurationProperties("admin")
@Setter
public class AdminConfiguration {
    private String username;
    private String password;
    
    public Admin getAdmin(){
        return new Admin(username, password);
    }
}
