package com.libro.libro_loombok.repository;

import com.libro.libro_loombok.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILibroRepository extends JpaRepository<Libro,Long> {
    List<Libro> findByEstadoFalse();
    List<Libro> findByEstadoTrue();
    Optional<Libro> findByTitle(String title);
}
