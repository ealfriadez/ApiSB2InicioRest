package unfv.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unfv.edu.pe.exception.ResourceNotFoundException;
import unfv.edu.pe.model.Persona;
import unfv.edu.pe.service.PersonaService;

@RestController
@RequestMapping("/api/v1")
public class PeronaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/persona")
	public ResponseEntity<List<Persona>> listarPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		personaService.listarPersonas().forEach(personas::add);
		if (personas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(personas, HttpStatus.OK);
	}
	
	@GetMapping("/persona/{id}")
	public ResponseEntity<Persona> obtenerPersonaPorId(
			@PathVariable("id") Integer id
			) throws ResourceNotFoundException{
		Persona persona = personaService
				.buscarPorId(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso con el id: " + id + " no encontrado"));
	
		return new ResponseEntity<>(persona, HttpStatus.OK);
	}
	
	@PostMapping("/persona")
	public ResponseEntity<Persona> registrarPersona(
			@RequestBody Persona persona
			){
		Persona _persona = personaService.registrarPersona(persona);
		return new ResponseEntity<>(_persona, HttpStatus.CREATED);
	}
	
}
