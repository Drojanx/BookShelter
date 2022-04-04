package com.actividadaprendizaje.bookshelter.controller;

import com.actividadaprendizaje.bookshelter.domain.Review;
import com.actividadaprendizaje.bookshelter.service.BookService;
import com.actividadaprendizaje.bookshelter.service.ReviewService;
import com.actividadaprendizaje.bookshelter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller

public class ReviewController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/rate-book")
    public String rateBook(@ModelAttribute Review review, Model model){
        model.addAttribute("review", review);
        return "/rate-book";
    }
}
