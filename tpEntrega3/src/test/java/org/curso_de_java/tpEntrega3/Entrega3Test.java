
package org.curso_de_java.tpEntrega3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.Test;

import modelo.Persona;
import modelo.PronosticosCsvPorLinea;
import modelo.ResultadosCsvPorLinea;
import modelo.Torneo;

public class Entrega3Test {
	

@Test
	public void puntajeDeUnaPersonaEnDosRondasConsecutivas() {
	System.out.println("Test número : 1");
	System.out.println("Testeando el puntaje de una persona en dos rondas consecutivas");
	
	Torneo mundial=new Torneo("mundial catar 2022");
	List <Persona> personas;
	List <ResultadosCsvPorLinea> tablaResultadoCsv;
	List <PronosticosCsvPorLinea> tablaPronosticoCsv;
	
	String resultado="src\\main\\resources\\resultadoTest.csv";
	String pronostico="src\\main\\resources\\pronosticoTest.csv";
	
	tablaPronosticoCsv=App.leerPronosticoCsv(pronostico,mundial);
	tablaResultadoCsv=App.leerResultadosCsv(resultado,mundial);
	
	App.calcularPuntajes(mundial);
	int puntaje=0, puntajeEsperado=6;
	
	for (Persona  persona: mundial.getPersonas()) {
  		puntaje=persona.getPuntaje();
  		}
	
	assertEquals(puntaje,puntajeEsperado);
	}
}
