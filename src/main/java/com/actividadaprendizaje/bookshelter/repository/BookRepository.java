package com.actividadaprendizaje.bookshelter.repository;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
    Book findByName(String name);
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);
    List<Book> findByNameAndAuthorAndCategory(String name, String author, String category);

    @Query(value = "SELECT DISTINCT category FROM books")
    List<String> allCategories();
}
