package com.example.bookshop.services;

import com.example.bookshop.entities.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    boolean isDataSeeded();
    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterYear(LocalDate year);

    List<Book> getAllBooksBeforeYear(LocalDate year);

    List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

}
