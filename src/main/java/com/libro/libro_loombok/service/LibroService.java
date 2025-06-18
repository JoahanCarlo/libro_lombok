package com.libro.libro_loombok.service;

import com.libro.libro_loombok.dto.LibroDTO;
import com.libro.libro_loombok.model.Libro;
import com.libro.libro_loombok.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    ILibroRepository libroRepository;

    public ArrayList<Libro> getLibros(){
        return (ArrayList<Libro>) libroRepository.findAll();
    }

    public Libro updateEstado(Long id,Long nuevoEstado){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Libro no encontrado"));
        libro.setEstado(nuevoEstado != null  && nuevoEstado == 1L);
        return libroRepository.save(libro);
    }

    public Libro saveLibro(LibroDTO libroDTO){
        Libro libro = new Libro(libroDTO);
        return libroRepository.save(libro);
    }


    public Optional<Libro> buscarPorNombre(String title){
        return libroRepository.findByTitle(title);
    }

    public Optional<Libro> getById(Long id){
        return libroRepository.findById(id);
    }


}
