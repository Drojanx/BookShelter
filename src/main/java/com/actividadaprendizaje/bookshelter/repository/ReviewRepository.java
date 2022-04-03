package com.actividadaprendizaje.bookshelter.repository;

import com.actividadaprendizaje.bookshelter.domain.Purchase;
import com.actividadaprendizaje.bookshelter.domain.Review;
import com.actividadaprendizaje.bookshelter.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAll();
    List<Review> findByUser(User user);
}
