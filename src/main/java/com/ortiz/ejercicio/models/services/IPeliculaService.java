package com.ortiz.ejercicio.models.services;

import java.util.List;

import com.ortiz.ejercicio.models.entities.Pelicula;

public interface IPeliculaService {
	
	public void save(Pelicula p);
	
	public Pelicula findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Pelicula> findAll();

}
