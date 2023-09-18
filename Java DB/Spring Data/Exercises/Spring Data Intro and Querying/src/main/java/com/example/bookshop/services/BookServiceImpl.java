package com.example.bookshop.services;

import com.example.bookshop.entities.Author;
import com.example.bookshop.entities.Book;
import com.example.bookshop.enums.AgeRestriction;
import com.example.bookshop.enums.EditionType;
import com.example.bookshop.model.BookPrintInfo;
import com.example.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAllAndFlush(books);
    }

    @Override
    public List<Book> getAllBooksAfterYear(LocalDate date) {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(date).get();

        books.forEach(b -> System.out.println(b.getTitle()));

        return books;
    }

    @Override
    public List<Book> getAllBooksBeforeYear(LocalDate date) {
        List<Book> books = this.bookRepository
                .findAllByReleaseDateBefore(date)
                .orElseThrow(NoSuchElementException::new);

        books.forEach(b -> System.out.println(b.getTitleEditionTypeAndPrice()));

        return books;
    }

    @Override
    public List<Book> getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        List<Book> books = this.bookRepository
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);

        books.stream().map(Book::getTitle).forEach(System.out::println);

        return books;
    }

    @Override
    public List<Book> getAllByAgeRestriction(String ageRestriction) {
        List<Book> books = this.bookRepository
                .findAllByAgeRestriction
                        (AgeRestriction.valueOf(ageRestriction.toUpperCase()));

        books.stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

        return books;
    }

    @Override
    public List<Book> getAllByEditionTypeWithCopiesLessThan(String editionType, Integer copies) {
        List<Book> books = this.bookRepository.findAllByEditionTypeAndCopiesLessThan
                (EditionType.valueOf(editionType.toUpperCase()), copies);

        books.stream()
                .map(Book::getTitle)
                .forEach(System.out::println);

        return books;
    }

    @Override
    public List<Book> getAllByPriceOutOfBounds(BigDecimal lowerBoundary, BigDecimal upperBoundary) {
        List<Book> books = this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lowerBoundary, upperBoundary);

        books.forEach(b -> System.out.println(b.getTitlePrice()));

        return books;
    }

    @Override
    public List<Book> getAllByNotReleasedYear(Integer year) {
        List<Book> books = this.bookRepository
                .findAllByReleaseDateYearNot(year);

        books.forEach(b -> System.out.println(b.getTitle()));
        return books;
    }

    @Override
    public List<Book> getAllByReleasedDateBefore(LocalDate date) {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date).get();

        books.forEach(b -> System.out.println(b.getTitleEditionTypeAndPrice()));

        return books;
    }

    @Override
    public List<Book> getAllByTitleContaining(String contains) {
        List<Book> books = this.bookRepository.findAllByTitleContaining(contains);

        books.forEach(b -> System.out.println(b.getTitle()));

        return books;
    }

    @Override
    public List<Book> getAllByAuthorLastNameStartsWith(String prefix) {
        List<Book> books = this.bookRepository.findAllByAuthorLastNameStartsWith(prefix);

        books.forEach(b -> System.out.println(b.getTitle()));

        return books;
    }

    @Override
    public Integer getCountBooksWithTitleLengthGreaterThan(Integer titleLength) {
        Integer countBooks = this.bookRepository
                .getCountBooksByTitleLengthGreaterThan(titleLength);

        System.out.println(countBooks);

        return countBooks;
    }

    @Override
    public List<BookPrintInfo> findAllByTitle(String title) {
        List<BookPrintInfo> booksPrintInfo = this.bookRepository.findAllByTitle(title);

        booksPrintInfo.forEach(System.out::println);

        return booksPrintInfo;
    }

    @Override
    public void increaseBookCopiesByGivenNumber(Integer addedCopies, LocalDate date) {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(date).get();

        books.forEach(b -> b.setCopies(b.getCopies() + addedCopies));
        this.bookRepository.saveAllAndFlush(books);

        System.out.println(addedCopies * books.size());
    }

    @Override
    public int deleteByCopiesLessThan(Integer copies) {
        int count = this.bookRepository.deleteByCopiesLessThan(copies);

        System.out.println(count);

        return count;
    }

    @Override
    public int getBooksCountByAuthorFirstNameAndAuthorLastName(String fullName) {
        int booksCount = this.bookRepository
                .getBooksCountByAuthorFirstNameAndAuthorLastName
                        (fullName);

        System.out.println(booksCount);

        return booksCount;
    }
}
