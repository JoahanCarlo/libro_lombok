package com.libro.libro_loombok.model;

import com.libro.libro_loombok.dto.LibroDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private Integer publishedYear;

    private Double price;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date fechaCreacion;

    private Boolean estado;

    public Libro(LibroDTO dto){
        int valor = 1;
        this.title = dto.getTitle();
        this.author = dto.getAuthor();
        this.isbn = dto.getIsbn();
        this.publishedYear = dto.getPublishedYear();
        this.price = dto.getPrice();
        this.email = dto.getEmail();
        this.fechaCreacion = new Date();
        this.estado = (valor==1);
    }

}
