package modelo;

import java.util.ArrayList;
import java.util.List;

public class Persona {

	private String nombre;
	private List<Pronostico> pronosticos;
	private Integer puntaje;
	//private Pronostico pronostico;
	
	public Persona(String unNombre) {
		this.nombre=unNombre;
		this.pronosticos=new ArrayList<Pronostico>();
		this.setPuntaje(0);
	}
	
	public void agregarPronostico(Pronostico unPronostico) {
		pronosticos.add(unPronostico);		
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	public void mostrarPersona(Persona unaPersona) {	
		for (Partido p : unaPersona.pronosticos) {		
		System.out.printf("|%-20s|%-20s|%-7s|%-7s|%-20s|\n",r.nro,p.getEquipo1().getNombre(),p.getGolesEquipo1(),
				p.getGolesEquipo2(),p.getEquipo2().getNombre());
		}
	}
	*/

	public List<Pronostico> getPronosticos(Persona unaPersona) {
		return unaPersona.pronosticos;
	}

	public void mostrarPronostico(Persona unaPersona) {
		int gol1=0,gol2=0;
		String pron=" ";
		for (Pronostico p : unaPersona.pronosticos) {		

			gol1=p.getPartido().getGolesEquipo1();
			gol2=p.getPartido().getGolesEquipo2();
			
			System.out.printf("|%-20s|%-20s|",unaPersona.getNombre(),p.getPartido().getEquipo1().getNombre());

			pron=" ";
			if (gol1==1) pron="X";
			System.out.printf("%-6s|",pron);
			
			pron=" ";
			if ((gol1==0) && (gol2==0)) pron="X";
			System.out.printf("%-6s|",pron);
			
			pron=" ";
			if (gol2==1) pron="X";
			System.out.printf("%-6s|",pron);
			
			System.out.printf("%-20s|\n",p.getPartido().getEquipo2().getNombre());
	}
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
}
