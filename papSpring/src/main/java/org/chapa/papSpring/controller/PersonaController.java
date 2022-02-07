package org.chapa.papSpring.controller;

import java.util.List;

import org.chapa.papSpring.entities.Persona;
import org.chapa.papSpring.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PersonaController {
	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/persona/r")
	public String r(
			ModelMap m			
			) {
		List<Persona> personas = personaRepository.findAll();
		
		m.put("personas", personas);
		return "persona/r";
	}
	
	
	@GetMapping("/persona/c")
	public String c() {
		return "persona/c";
	}
	
	
	@PostMapping("/persona/c")
	public String cPost(@RequestParam("nombre") String nombre) { 
		String returnLocation = "";
		try {
			personaRepository.save(new Persona(nombre));
			returnLocation = "redirect:/persona/r";
		} catch (Exception e) {
			returnLocation = "redirect:/errorDisplay?msg=La persona con el nombre " + nombre + " ya existe.";
		}
		return returnLocation;
	}
}
