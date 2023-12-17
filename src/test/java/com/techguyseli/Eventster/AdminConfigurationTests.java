package com.techguyseli.Eventster;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techguyseli.Eventster.configurations.AdminConfiguration;
import com.techguyseli.Eventster.entities.Admin;

@SpringBootTest
public class AdminConfigurationTests {
    @Autowired
    private AdminConfiguration adminConf;

    @Test
    void adminLoads(){
        Admin admin = adminConf.getAdmin();

        assertTrue(!admin.getUsername().isEmpty());
        assertTrue(!admin.getPassword().isEmpty());
    } 
    
}