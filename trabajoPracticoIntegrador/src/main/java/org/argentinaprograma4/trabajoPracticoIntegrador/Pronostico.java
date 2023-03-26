package org.argentinaprograma4.trabajoPracticoIntegrador;

public class Pronostico {
	
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	
	public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {		
		setPartido(partido);
		setEquipo(equipo);
		setResultado(resultado);
	}
	
	
	public Partido getPartido() {
		return partido;
	}


	public void setPartido(Partido partido) {
		this.partido = partido;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public ResultadoEnum getResultado() {
		return resultado;
	}


	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}

	public int puntos() {
		
		return 0;
	}
	

}
