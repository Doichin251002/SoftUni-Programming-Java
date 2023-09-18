package com.example.bookshop.repositories;

import com.example.bookshop.entities.Book;
import com.example.bookshop.enums.AgeRestriction;
import com.example.bookshop.enums.EditionType;
import com.example.bookshop.model.BookPrintInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findAllByReleaseDateAfter(LocalDate date);
    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);
    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBoundary, BigDecimal upperBoundary);

    @Query("select b from Book b where year(b.releaseDate) != :year")
    List<Book> findAllByReleaseDateYearNot(Integer year);
    List<Book> findAllByTitleContaining(String contains);
    List<Book> findAllByAuthorLastNameStartsWith(String prefix);

    @Query("select count(b) from Book b where length(b.title) > :titleLength")
    Integer getCountBooksByTitleLengthGreaterThan(Integer titleLength);

    @Query("select new com.example.bookshop.model.BookPrintInfo" +
            "(b.title, b.editionType, b.ageRestriction, b.price) " +
            "from Book b where b.title = :title")
    List<BookPrintInfo> findAllByTitle(String title);

    List<Book> findAllByCopiesLessThan(Integer copies);

    @Transactional
    int deleteByCopiesLessThan(Integer copies);

    @Procedure(value = "get_books_written_by")
    int getBooksCountByAuthorFirstNameAndAuthorLastName(String fullName);
}
