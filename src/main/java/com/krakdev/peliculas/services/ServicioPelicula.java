package com.krakdev.peliculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.repository.PeliculaRepository;

@Service
public class ServicioPelicula {
	
	@Autowired
	private PeliculaRepository repository;

	public Pelicula crear(Pelicula pelicula) {
		return repository.save(pelicula);
	}

	public List<Pelicula> listar() {
		return repository.findAll();
	}

	public Pelicula buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Pelicula actualizar(Pelicula pelicula) {
		return repository.save(pelicula);
	}

	public boolean eliminar(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Pelicula> buscarPorGenero(String genero) {
		return repository.findByGenero(genero);
	}

	public List<Pelicula> buscarPorDisponible(boolean disponible) {
		return repository.findByDisponible(disponible);
	}

}
