package com.actividadaprendizaje.bookshelter.service;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.exception.BookNotFoundException;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    Book findBook(long id) throws BookNotFoundException;
    List<Book> findByCategory(String categoryName);

    void addBook(Book book);
    List<String> allCategories();
}
