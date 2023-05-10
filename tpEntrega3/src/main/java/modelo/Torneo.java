package modelo;

import java.util.ArrayList;
import java.util.List;

/*
import modelo.Ronda;
import modelo.Persona;
*/

public class Torneo {

	private String nombreDelTorneo;
	private List <Ronda> rondas;
	private List <Persona> personas;
	
	public Torneo(String nombre) {
		this.nombreDelTorneo=nombre;
		this.rondas=new ArrayList<Ronda>();
		this.personas=new ArrayList<Persona>();
		
	}

	public List<Ronda> getRondas() {
		return rondas;
	}

	public void setRondas(List<Ronda> rondas) {
		this.rondas = rondas;
	}

	public Ronda buscarRonda(Integer numero, Ronda unaRonda) {
		for (Ronda buscar : rondas) {
    		if (numero.equals(buscar.getNro())) {
    			return buscar;    			
    		}
    	}
		rondas.add(unaRonda);
		return unaRonda;
	}

	public String getNombreDelTorneo() {
		return nombreDelTorneo;
	}

	public void setNombreDelTorneo(String nombreDelTorneo) {
		this.nombreDelTorneo = nombreDelTorneo;
	}

	public List <Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List <Persona> personas) {
		this.personas = personas;
	}
	

	public Persona buscarPersona(String nombre, Persona unaPersona) {
		for (Persona buscar : personas) {
			
    		if (nombre.equals(buscar.getNombre())) {    			
    			return buscar;    			
    		}
    	}
		personas.add(unaPersona);
		return unaPersona;
	}


	

	public void buscarPersona2(String nombre, Pronostico unPronostico) {
		for (Persona buscar : personas) {
			
    		if (nombre.equals(buscar.getNombre())) {
    			buscar.agregarPronostico(unPronostico);
    			return;    			
    		}
    	}
		Persona unaPersona = new Persona(nombre);
		unaPersona.agregarPronostico(unPronostico);
		personas.add(unaPersona);
		return;
	}

	
	
	
	
	
	/*
	public void saberResultado(Pronostico pro, Partido par) {
		String nombre1pro=pro.getPartido().getEquipo1().getNombre();
		String nombre1par=par.getEquipo1().getNombre();
		
		String nombre2pro=pro.getPartido().getEquipo2().getNombre();
		String nombre2par=par.getEquipo2().getNombre();

		System.out.println("\nPARTIDO : "+nombre1pro+" VS "+nombre2pro);

		System.out.println("PRONOSTICO     : "+nombre1pro+" "+pro.getPartido().getGolesEquipo1()+" - "+nombre2pro+" "+pro.getPartido().getGolesEquipo2());
		System.out.println("RESULTADO REAL : "+nombre1pro+" "+par.getGolesEquipo1()+" - "+nombre2pro+" "+par.getGolesEquipo2());

										//	if	(pronosticaba que el equipo1 ganaba el partido) and 
										//		(realmente el equipo1 ganó el partido)

		
		if ((pro.getPartido().getGolesEquipo1()>pro.getPartido().getGolesEquipo2()) &&
				(par.getGolesEquipo1()>par.getGolesEquipo2())) {
				pro.sumarPunto();
				System.out.println("suma 1 punto porque gana "+nombre1pro);
				}
	else {
			if ((pro.getPartido().getGolesEquipo2()>pro.getPartido().getGolesEquipo1()) &&
				(par.getGolesEquipo2()>par.getGolesEquipo1())) {
				pro.sumarPunto();
				System.out.println("suma 1 punto porque gana "+nombre1par);
				}
		else {
			if ((pro.getPartido().getGolesEquipo2()==pro.getPartido().getGolesEquipo1()) &&
				(par.getGolesEquipo2()==par.getGolesEquipo1())) {										
				pro.sumarPunto();
				System.out.println("suma 1 punto porque empatan");
				}
			}
	}
	}
*/
	

	public void saberResultado(Pronostico pro, Partido par) {
		String nombre1pro=pro.getPartido().getEquipo1().getNombre();
		String nombre1par=par.getEquipo1().getNombre();
		
		String nombre2pro=pro.getPartido().getEquipo2().getNombre();
		String nombre2par=par.getEquipo2().getNombre();

		System.out.println("\nPARTIDO : "+nombre1pro+" VS "+nombre2pro);

		System.out.println("PRONOSTICO     : "+nombre1pro+" "+pro.getPartido().getGolesEquipo1()+" - "+nombre2pro+" "+pro.getPartido().getGolesEquipo2());
		System.out.println("RESULTADO REAL : "+nombre1pro+" "+par.getGolesEquipo1()+" - "+nombre2pro+" "+par.getGolesEquipo2());

										//	if	(pronosticaba que el equipo1 ganaba el partido) and 
										//		(realmente el equipo1 ganó el partido)

		
		if ((pro.getPartido().getGolesEquipo1()>pro.getPartido().getGolesEquipo2()) &&
				(par.getGolesEquipo1()>par.getGolesEquipo2())) {
				pro.sumarPunto();
				System.out.println("suma 1 punto porque gana "+nombre1pro);
				}
	else {
			if ((pro.getPartido().getGolesEquipo2()>pro.getPartido().getGolesEquipo1()) &&
				(par.getGolesEquipo2()>par.getGolesEquipo1())) {
				pro.sumarPunto();
				System.out.println("suma 1 punto porque gana "+nombre1par);
				}
		else {
			if ((pro.getPartido().getGolesEquipo2()==pro.getPartido().getGolesEquipo1()) &&
				(par.getGolesEquipo2()==par.getGolesEquipo1())) {										
				pro.sumarPunto();
				System.out.println("suma 1 punto porque empatan");
				}
			}
	}
	}

	
	
}
