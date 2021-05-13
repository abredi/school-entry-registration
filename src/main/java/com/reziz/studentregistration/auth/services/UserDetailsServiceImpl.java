package com.reziz.studentregistration.auth.services;

import com.reziz.studentregistration.auth.models.User;
import com.reziz.studentregistration.auth.models.UserAuthDetails;
import com.reziz.studentregistration.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
		@Autowired
		UserRepository userRepository;
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		    Optional<User> user = userRepository.findByUsername(userName);
	    	user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
			List<String> roles = Arrays.stream(user.get().getRoles().split(",")).map(String::new)
                    .collect(Collectors.toList());
			return new UserAuthDetails(user.get(), roles);
		}
}
