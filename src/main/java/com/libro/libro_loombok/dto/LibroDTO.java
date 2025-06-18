package com.libro.libro_loombok.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class LibroDTO {
    @NotBlank(message = "El nombre del titulo no puede estar vacio")
    private String title;

    @NotBlank(message = "El nombre del autor no puede estar vacio")
    private String author;

    @NotBlank(message = "El nombre del código del libro no puede estar vacio")
    private String isbn;


    private Integer publishedYear;

    private Double price;



    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@unasam\\.com$",
            message = "El correo debe ser validado y terminar en @unasam.com"
    )
    private String email;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public Double getPrice() {
        return price;
    }

    public String getEmail() {
        return email;
    }
}
