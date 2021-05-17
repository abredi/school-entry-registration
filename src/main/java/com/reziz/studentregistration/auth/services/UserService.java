package com.reziz.studentregistration.auth.services;

import com.reziz.studentregistration.auth.models.User;
import com.reziz.studentregistration.auth.models.dto.UserCreateRequest;
import com.reziz.studentregistration.auth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserCreateRequest ur) {
        Optional<User> byUsername = userRepository.findByUsername(ur.getUsername());
        if (byUsername.isPresent()) {
           throw new RuntimeException("User already registered. Please use different username.");
        }
        var userModel = new User(ur.getFirstName(), ur.getLastName(), ur.getUsername(),
                passwordEncoder.encode(ur.getPassword()), ur.getRoles());
       return userRepository.save(userModel);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUserPass(User user, UserCreateRequest userReq) {
        if (user != null && passwordEncoder.matches(userReq.getPrevPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(userReq.getPassword()));
            return userRepository.save(user);
        }

        return null;
    }

    public User findById(Long id) {
        return  userRepository.findById(id).orElseGet(User::new);
    }
}

