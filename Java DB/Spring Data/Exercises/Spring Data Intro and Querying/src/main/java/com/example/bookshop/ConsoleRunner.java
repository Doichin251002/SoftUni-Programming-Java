package com.example.bookshop;

import com.example.bookshop.entities.Book;
import com.example.bookshop.services.AuthorService;
import com.example.bookshop.services.BookService;
import com.example.bookshop.services.SeedService;
import org.joda.time.Days;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final Scanner scanner;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run(String... args) throws Exception {
        this.authorService.getAllAuthorsWithBooksBeforeYear(LocalDate.of(1991, 1, 1));
//        this.authorService.getAllAuthorsOrderByBooksDesc();
//        this.bookService.getAllByAgeRestriction(firstInput);
//        this.bookService.getAllByEditionTypeAndCopiesOver("Gold", 5000);
//        this.bookService.getAllByPriceNotBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(40) );
//        this.bookService.getAllNotReleasedInYear(2000);
//        this.bookService.getAllBooksBeforeYear(LocalDate.of(Integer.parseInt(thirdInput),
//                Integer.parseInt(secondInput),
//                Integer.parseInt(firstInput)));
//        this.authorService.getAllByFirstNameEndingWith("e");
//        this.bookService.getAllByTitleContaining("sK");
//        this.bookService.getAllByAuthorLastNameStartsWith("Ric");
//        this.bookService.getAllByTitleLengthGreaterThan(12);
//        this.bookService.getAllByBookTitle("Things Fall Apart");
//        this.bookService
//                .increaseCopiesForBookReleasedAfter(100, LocalDate.of(2005, 10,12));
//        this.bookService.deleteAllByCopiesLessThan(10000);
//        System.out.println(this.bookService.getBooksCountByAuthorFirstNameAndAuthorLastName("Amanda Rice"));
    }
}
