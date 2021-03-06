package com.actividadaprendizaje.bookshelter.service.impl;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.exception.BookNotFoundException;
import com.actividadaprendizaje.bookshelter.repository.BookRepository;
import com.actividadaprendizaje.bookshelter.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.actividadaprendizaje.bookshelter.repository.PurchaseRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBook(long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public List<Book> findByCategory(String categoryName) {
        List<Book> books = bookRepository.findByCategory(categoryName);
        return books;
    }

    @Override
    public void addBook(Book book) {

        bookRepository.save(book);
    }

    @Override
    public List<String> allCategories() {
        List<String> strings = bookRepository.allCategories();
        return strings;
    }

}
