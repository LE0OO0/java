package modelo;

public class Equipo {
	private String nombre;
	private String descripcion;
	
	public Equipo(String unNombre, String unaDescripcion) {
		this.setNombre(unNombre);
		this.setDescripcion(unaDescripcion);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String unaDescripcion) {
		this.descripcion = unaDescripcion;
	}	
}
