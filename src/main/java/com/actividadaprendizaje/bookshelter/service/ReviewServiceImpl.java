package com.actividadaprendizaje.bookshelter.service;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.Purchase;
import com.actividadaprendizaje.bookshelter.domain.Review;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.repository.PurchaseRepository;
import com.actividadaprendizaje.bookshelter.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void addReview(User user, Book book, float stars) {
        Review review = new Review();
        review.setUser(user);
        review.setStars(stars);
        review.setBook(book);
        reviewRepository.save(review);
    }

    @Override
    public List<Review> findByUser(User user) {
        return reviewRepository.findByUser(user);
    }

    @Override
    public List<Review> findAllReviews() {
        return null;
    }

    @Override
    public List<Review> findPurchases(User user) {
        return null;
    }
}
