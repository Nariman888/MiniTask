package com.task1foralabs.Task1ForAlabs.service.imp;

import com.task1foralabs.Task1ForAlabs.entity.Users;
import com.task1foralabs.Task1ForAlabs.repository.UserRepository;
import com.task1foralabs.Task1ForAlabs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Users addUser(Users user, String rePassword) {
        if (rePassword.equals(user.getPassword())){
            Users foundUser = userRepository.findByEmail(user.getEmail());
            if (foundUser==null){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);
            }
        }
        return null;
    }

    @Override
    public Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (Users) authentication.getPrincipal();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users foundUser= userRepository.findByEmail(username);
        if (foundUser!=null) {
            return foundUser;
        } else{
            throw new UsernameNotFoundException("User Not Found!");
        }
    }
}
