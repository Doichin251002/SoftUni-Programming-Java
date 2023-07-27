package com.example.bookshop.model;

import com.example.bookshop.enums.AgeRestriction;
import com.example.bookshop.enums.EditionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookPrintInfo {
    private String title;

    private EditionType editionType;

    private AgeRestriction ageRestriction;

    private BigDecimal price;

    public BookPrintInfo(String title, EditionType editionType, AgeRestriction ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.title + " "
                + this.editionType + " "
                + this.ageRestriction + " "
                + this.price;
    }
}