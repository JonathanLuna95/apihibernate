package com.krakdev.peliculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private ServicioPelicula servicio;

	@PostMapping
	public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula) {
		return ResponseEntity.ok(servicio.crear(pelicula));
	}

	@GetMapping
	public ResponseEntity<List<Pelicula>> listar() {
		return ResponseEntity.ok(servicio.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
		pelicula.setId(id);
		return ResponseEntity.ok(servicio.actualizar(pelicula));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> eliminar(@PathVariable Long id) {
		return ResponseEntity.ok(servicio.eliminar(id));
	}

	@GetMapping("/genero")
	public ResponseEntity<List<Pelicula>> buscarPorGenero(@RequestParam String genero) {
		return ResponseEntity.ok(servicio.buscarPorGenero(genero));
	}

	@GetMapping("/disponible")
	public ResponseEntity<List<Pelicula>> buscarPorDisponible(@RequestParam boolean disponible) {
		return ResponseEntity.ok(servicio.buscarPorDisponible(disponible));
	}

}
