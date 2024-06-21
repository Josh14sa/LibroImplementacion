package com.example.examen.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.examen.entity.Libro;

public interface LibroRepository extends MongoRepository<Libro, String>{
	
	@Query("{ 'categories' : { $regex: ?0, $options: 'i' } }")
    List<Libro> buscarPorCategoria(String categoria);

}
