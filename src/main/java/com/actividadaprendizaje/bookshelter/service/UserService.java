package com.actividadaprendizaje.bookshelter.service;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.exception.UserModificationException;
import com.actividadaprendizaje.bookshelter.exception.UserRegistrationException;

public interface UserService {

    boolean add(User user) throws UserRegistrationException;
    User findByUsername(String username);
    boolean modifyUser(User user, User formUser) throws UserModificationException;
    boolean usernameExists(String username);
    boolean emailExists(String username);
}
