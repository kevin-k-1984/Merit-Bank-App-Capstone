package com.meritamerica.assignment7.services;

import com.meritamerica.assignment7.models.MyUserDetails;
import com.meritamerica.assignment7.models.User;
import com.meritamerica.assignment7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String temp = username;
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }

    public User StoreUser(User user) {
        if (!user.getRole().equals("ADMIN")) user.setRole("ROLE_ACCOUNTHOLDER");
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) throws UsernameNotFoundException {
        String temp = username;
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.get();
    }
}
