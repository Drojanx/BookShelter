package com.actividadaprendizaje.bookshelter.service;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.Review;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.exception.BookNotFoundException;
import com.actividadaprendizaje.bookshelter.exception.UserNotFoundException;

import java.util.List;

public interface ReviewService {

    boolean addReview(Review review);
    List<Review> findByBook(Book book) throws BookNotFoundException;
    Review findByUserAndBook(User user, Book book);
    boolean modifyReview(Review review, Review formReview);
}
