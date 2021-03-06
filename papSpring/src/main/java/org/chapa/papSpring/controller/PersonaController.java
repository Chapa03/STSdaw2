package org.chapa.papSpring.controller;

import java.util.List;

import org.chapa.papSpring.entities.Persona;
import org.chapa.papSpring.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {
	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/persona/r")
	public String r(
			ModelMap m			
			) {
		List<Persona> personas = personaRepository.findAll();
		
		m.put("personas", personas);
		m.put("view", "/persona/r");
		return "_t/frame";
	}
	
	
	@GetMapping("/persona/c")
	public String c(ModelMap m) {
		m.put("view", "/persona/c");
		return "_t/frame";
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
