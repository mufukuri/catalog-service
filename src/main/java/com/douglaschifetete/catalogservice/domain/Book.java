package com.douglaschifetete.catalogservice.domain;

import com.douglaschifetete.catalogservice.persistence.PersistableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.time.Year;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends PersistableEntity {

    @NotBlank(message = "The book ISBN must be defined.")
    @Pattern(regexp = "^(97([89]))?\\d{9}(\\d|X)$", message = "The ISBN format must follow the standards ISBN-10 or ISBN-13.")
    private String isbn;

    @NotBlank(message = "The book title must be defined.")
    private String title;

    @NotBlank(message = "The book author must be defined.")
    private String author;

    @PastOrPresent(message = "The book cannot have been published in the future.")
    private Year publishingYear;

    @NotNull(message = "The book price must be defined.")
    @Positive(message = "The book price must be greater than zero.")
    private Double price;

    private String publisher;
}
