package com.actividadaprendizaje.bookshelter.controller;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.exception.BookNotFoundException;
import com.actividadaprendizaje.bookshelter.service.BookService;
import com.actividadaprendizaje.bookshelter.service.PurchaseService;
import com.actividadaprendizaje.bookshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping("/add-purchase/{bookId}")
    public String addPurchase(@PathVariable long bookId, HttpServletRequest request) throws BookNotFoundException {
        Book book = bookService.findBook(bookId);
        // TODO Cambiar cuando implementemos la parte de seguridad y login de usuarios
        String remoteUsername = request.getRemoteUser();
        User remoteUser = userService.findByUsername(remoteUsername);
        purchaseService.addPurchase(book, remoteUser);
        return "redirect:/book/"+bookId;
    }
}
