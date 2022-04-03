package com.actividadaprendizaje.bookshelter.service;

import com.actividadaprendizaje.bookshelter.domain.Book;
import com.actividadaprendizaje.bookshelter.domain.Purchase;
import com.actividadaprendizaje.bookshelter.domain.User;
import com.actividadaprendizaje.bookshelter.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public void addPurchase(Book book, User user) {
        Purchase purchase = new Purchase();
        purchase.setCreationDate(LocalDate.now());
        purchase.setBook(book);
        purchase.setUser(user);
        purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> findPurchases(User user) {
        return purchaseRepository.findByUser(user);
    }
}
