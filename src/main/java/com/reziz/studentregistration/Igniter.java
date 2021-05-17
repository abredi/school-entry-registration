package com.reziz.studentregistration;

import com.reziz.studentregistration.auth.models.dto.UserCreateRequest;
import com.reziz.studentregistration.auth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Igniter implements CommandLineRunner {
    private final UserService userService;

    @Override
    public void run(String... args) {
        userService.createUser(new UserCreateRequest("Abdulaziz", "Ali", "admin", "admin",null,"Admin"));
        userService.createUser(new UserCreateRequest("Ree", "Ziz", "faculty", "faculty",null,"faculty"));
    }
}
