package com.actividadaprendizaje.bookshelter.controller;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.Purchase;
import com.actividadaprendizaje.bookshelter.domain.Review;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.exception.UserModificationException;
import com.actividadaprendizaje.bookshelter.exception.UserRegistrationException;
import com.actividadaprendizaje.bookshelter.service.BookService;
import com.actividadaprendizaje.bookshelter.service.PurchaseService;
import com.actividadaprendizaje.bookshelter.service.UserService;
import com.actividadaprendizaje.bookshelter.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private FileService fileService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register-user")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register-user";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user, Model model) throws UserRegistrationException {
        boolean userAdded = userService.add(user);
        if (!userAdded){
            throw new UserRegistrationException("Error al registrar el usuario");
        }
        model.addAttribute("user", user);
        return "add-user";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpServletRequest request) {
        String remoteUsername = request.getRemoteUser();
        User remoteUser = userService.findByUsername(remoteUsername);
        List<Purchase> purchaseList = purchaseService.findPurchases(remoteUser);
        List<Book> myBooks = new ArrayList<>();
        for(Purchase purchase : purchaseList){
            myBooks.add(purchase.getBook());
        }
        model.addAttribute("user", remoteUser);
        model.addAttribute("myBooks", myBooks);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String changeUserData(@ModelAttribute("userModify") User formUser, HttpServletRequest request, Model model) throws UserModificationException {
        String remoteUsername = request.getRemoteUser();
        User remoteUser = userService.findByUsername(remoteUsername);
        boolean userModified = userService.modifyUser(remoteUser, formUser);
        if (!userModified){
            throw new UserModificationException();
        }
        remoteUser = userService.findByUsername(formUser.getUsername());
        model.addAttribute("user", remoteUser);
        return "redirect:/profile";
    }

    @ExceptionHandler(UserRegistrationException.class)
    public ModelAndView handleUserRegistrationException(HttpServletRequest request, UserRegistrationException exception) {
        logger.error("Error: " + exception.getMessage(), exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMessage());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(UserModificationException.class)
    public ModelAndView handleUserModificationException(HttpServletRequest request, UserModificationException exception) {
        logger.error("Error: " + exception.getMessage(), exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "No se ha podido modificar el usuario. Por favor contacte con soporte técnico");
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

}

