package com.example.examen.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.examen.entity.Libro;
import com.example.examen.service.LibroService;

@RestController
@RequestMapping("/rest/libro")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/ListarLibrosPorCategoria/{categoria}")
    public ResponseEntity<List<Libro>> listarLibrosPorCategoria(@PathVariable String categoria) {
        List<Libro> libros = libroService.buscarLibrosPorCategoria(categoria);
        if (libros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}
