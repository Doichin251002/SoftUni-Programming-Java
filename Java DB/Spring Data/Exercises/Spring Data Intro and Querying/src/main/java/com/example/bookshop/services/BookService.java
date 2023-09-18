package com.example.bookshop.services;

import com.example.bookshop.entities.Book;
import com.example.bookshop.model.BookPrintInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    boolean isDataSeeded();
    void seedBooks(List<Book> books);

    List<Book> getAllBooksAfterYear(LocalDate year);

    List<Book> getAllBooksBeforeYear(LocalDate year);

    List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> getAllByAgeRestriction(String ageRestriction);

    List<Book> getAllByEditionTypeWithCopiesLessThan(String editionType, Integer copies);

    List<Book> getAllByPriceOutOfBounds(BigDecimal lowerBoundary, BigDecimal upperBoundary);

    List<Book> getAllByNotReleasedYear(Integer year);

    List<Book> getAllByReleasedDateBefore(LocalDate date);

    List<Book> getAllByTitleContaining(String contains);

    List<Book> getAllByAuthorLastNameStartsWith(String prefix);

    Integer getCountBooksWithTitleLengthGreaterThan(Integer titleLength);

    List<BookPrintInfo> findAllByTitle(String title);

    @Modifying
    @Transactional
    void increaseBookCopiesByGivenNumber(Integer addedCopies, LocalDate date);

    int deleteByCopiesLessThan(Integer copies);

    int getBooksCountByAuthorFirstNameAndAuthorLastName(String fullName);
}
