package unfv.edu.pe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import unfv.edu.pe.model.Persona;

@Service
public class PersonaService {

	public List<Persona> lstPersonas = new ArrayList<Persona>();
	
	public PersonaService() {
		
		lstPersonas.add(new Persona(1, "Eleazar Alfredo Alfriadez Yriarte", 40));
		lstPersonas.add(new Persona(2, "Doris Pilar Coronado Rodriguez", 40));
		lstPersonas.add(new Persona(3, "Sebastian Alfredo Alfriadez Coronado", 23));
		lstPersonas.add(new Persona(4, "Santiago Nicolas Alfriadez Coronado", 10));
	}
	
	public List<Persona> listarPersonas(){
		
		return lstPersonas;
	}
	
	public Optional<Persona> buscarPorId(Integer id){
		
		for (Persona persona : lstPersonas) {
			if(persona.getId().equals(id)) {
				return Optional.of(new Persona(persona.getId(), persona.getNombre(), persona.getEdad()));
			}
		}
		return Optional.empty();
	}
	
	public Persona registrarPersona(Persona persona) {
		lstPersonas.add(persona);
		return persona;
	}
	
	public Persona eliminarPersona(Persona persona) {
		lstPersonas.remove(persona);
		return persona;
	}
	
	public void eliminarTodosPersona(Persona persona) {
		lstPersonas.removeAll(lstPersonas);
	}
}
