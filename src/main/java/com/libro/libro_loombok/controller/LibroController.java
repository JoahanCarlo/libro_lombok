package com.libro.libro_loombok.controller;

import com.libro.libro_loombok.dto.LibroDTO;
import com.libro.libro_loombok.model.Libro;
import com.libro.libro_loombok.repository.ILibroRepository;
import com.libro.libro_loombok.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @Autowired
    private ILibroRepository libroRepository;

    @PostMapping
    public ResponseEntity<Libro> createLibro(@Valid @RequestBody LibroDTO libroDTO){
        Libro saveLibro = libroService.saveLibro(libroDTO);
        return ResponseEntity.ok(saveLibro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroAcrtivoById(@PathVariable Long id){
        return libroService.getById(id)
                .filter(Libro::getEstado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{title}")
    public ResponseEntity<?> buscarPorID(@PathVariable String title){
        Optional<Libro> libro = libroService.buscarPorNombre(title);
        return libro.isPresent() ? ResponseEntity.ok(libro.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerLibrosActivos(){
        List<Libro> librosActivos = libroRepository.findByEstadoTrue();
        return ResponseEntity.ok(librosActivos);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarLibro(@PathVariable Long id,
                                             @RequestBody Libro libroActualizado){
        Optional<Libro> libroExistente = libroRepository.findById(id);
        return libroExistente.<ResponseEntity<?>>map(libro->{
                    libro.setTitle(libroActualizado.getTitle());
                    libro.setAuthor(libroActualizado.getAuthor());
                    libro.setIsbn(libroActualizado.getIsbn());
                    libro.setPublishedYear(libroActualizado.getPublishedYear());
                    libro.setPrice(libroActualizado.getPrice());
                    libro.setEmail(libroActualizado.getEmail());
                    libroRepository.save(libro);
                    return ResponseEntity.ok(libro);
                }).orElseGet(()->
                        ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Libro no encontrado"));
    }

    @PutMapping("eliminar/{id}")
    public ResponseEntity<Libro> cambiarEstado(@PathVariable Long id){
        Optional<Libro> libroOpt = libroRepository.findById(id);
        if (libroOpt.isPresent()){
            Libro libro = libroOpt.get();
            libro.setEstado(false);
            libroRepository.save(libro);
            return ResponseEntity.ok(libro);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
