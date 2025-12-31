//package com.myprojects.product.service;
//
//import com.myprojects.product.entity.User;
//import com.myprojects.product.repository.UserRepository;
//import com.myprojects.product.security.UserPrincipal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public User createUser(User user) {
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        return userRepository.save(user);//It will save user details in DB
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//        if(user.isEmpty()) {
//            throw new UsernameNotFoundException("Username not found");
//        }
//
//        return new UserPrincipal(user.get());
//    }
//}
