package com.example.bookshop;

import com.example.bookshop.services.AuthorService;
import com.example.bookshop.services.BookService;
import com.example.bookshop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

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
        this.seedService.seedAllData();
        this.bookService.getAllBooksAfterYear(LocalDate.of(2000, 1, 1));
        //this.authorService.getAllAuthorsWithBooksBeforeYear(LocalDate.of(1990, 1,1));
        //this.authorService.getAllAuthorsOrderByBooksDesc();
    }

    private void printAllBooksByAuthorName() {
        System.out.println("Enter Author full name");
        final String[] inputName = this.scanner.nextLine().split(" ");

        this.bookService
                .getAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(inputName[0], inputName[1])
                .forEach(b -> System.out.println(b.getTitleReleaseDateCopiesFormat()));
    }
}
