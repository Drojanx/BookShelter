package com.actividadaprendizaje.bookshelter.service;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.Review;
import com.actividadaprendizaje.bookshelter.domain.User;

import java.util.List;

public interface ReviewService {

    void addReview(User user, Book book, float review);
    List<Review> findByUser(User user);
    List<Review> findAllReviews();
    List<Review> findPurchases(User user);
}
