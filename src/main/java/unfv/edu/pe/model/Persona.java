package unfv.edu.pe.model;

public class Persona {

	private Integer id;
	private String nombre;
	private Integer edad;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public Persona(Integer id, String nombre, Integer edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
}
