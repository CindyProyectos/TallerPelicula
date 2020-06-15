package com.ortiz.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ortiz.ejercicio.models.entities.Pelicula;
import com.ortiz.ejercicio.models.services.IPeliculaService;

@Controller
@RequestMapping(value="/pelicula")
public class PeliculaController {
	
	@Autowired 
	private IPeliculaService srvPelicula;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Pelicula p = new Pelicula();
		model.addAttribute("title", "Registro de nueva película");
		model.addAttribute("pelicula", p);
		return "pelicula/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Pelicula p = srvPelicula.findById(id);
		model.addAttribute("pelicula", p);
		return "pelicula/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Pelicula p = this.srvPelicula.findById(id);
		model.addAttribute("pelicula", p);
		model.addAttribute("title", "Actualizando el registro de la pelíula");
		return "pelicula/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvPelicula.delete(id);
		return "redirect:/pelicula/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Pelicula> p = this.srvPelicula.findAll();
		model.addAttribute("peliculas", p);
		model.addAttribute("title", "Listado de películas");
		return "pelicula/list";
	}
	
	
	@PostMapping(value="/save") 
	public String save(Pelicula p, Model model) {
		this.srvPelicula.save(p);
		return "redirect:/pelicula/list";
	}
}
