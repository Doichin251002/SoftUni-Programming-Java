package com.example.bookshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany
    private Set<Book> books;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFullNameAndBooksCount() {
        return getFullName() + " " + this.books.size();
    }
}
