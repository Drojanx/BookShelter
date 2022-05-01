package com.actividadaprendizaje.bookshelter.service.impl;

import com.actividadaprendizaje.bookshelter.domain.Role;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.exception.UserModificationException;
import com.actividadaprendizaje.bookshelter.exception.UserRegistrationException;
import com.actividadaprendizaje.bookshelter.repository.RoleRepository;
import com.actividadaprendizaje.bookshelter.repository.UserRepository;
import com.actividadaprendizaje.bookshelter.security.Constants;
import com.actividadaprendizaje.bookshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean add(User user) throws UserRegistrationException {
        try{
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setCreationDate(LocalDate.now());
            user.setActive(true);
            Role userRole = roleRepository.findByName(Constants.USER_ROLE);
            user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
            if(emailExists(user.getEmail()))
                throw new UserRegistrationException("Email ya en uso");
            if(usernameExists(user.getUsername()))
                throw new UserRegistrationException("Username ya en uso");
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex){
            return false;
        }
        return true;
    }

    @Override
    public User findByUsername(String username) { return userRepository.findByUsername(username); }

    @Override
    public boolean modifyUser(User user, User formUser) throws UserModificationException {
        try{
            user.setName(formUser.getName());
            user.setSurname(formUser.getSurname());
            user.setBirthDate(formUser.getBirthDate());
            userRepository.save(user);

        } catch (DataIntegrityViolationException ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

}
