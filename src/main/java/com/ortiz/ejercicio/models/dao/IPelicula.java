package com.ortiz.ejercicio.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.ortiz.ejercicio.models.entities.Pelicula;

public interface IPelicula extends CrudRepository<Pelicula, Integer>{

}
