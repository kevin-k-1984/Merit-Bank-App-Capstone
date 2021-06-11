package com.meritamerica.MeritBankAppCapstone.services;

import com.meritamerica.MeritBankAppCapstone.exceptions.UserNotFoundException;
import com.meritamerica.MeritBankAppCapstone.exceptions.UsernameAlreadyExistsException;
import com.meritamerica.MeritBankAppCapstone.models.MyUserDetails;
import com.meritamerica.MeritBankAppCapstone.models.User;
import com.meritamerica.MeritBankAppCapstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }

    public User StoreUser(User user) throws UsernameAlreadyExistsException {
        Optional<User> result = this.userRepository.findByUsername((user.getUsername()));

        if (!result.isPresent()) {
            return this.userRepository.save(user);
        } else {
            throw new UsernameAlreadyExistsException();
        }
    }

    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(username);

        user.orElseThrow(() -> new UserNotFoundException("Not found: " + username));

        return user.get();
    }
}
