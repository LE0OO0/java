package org.argentinaprograma4.trabajoPracticoIntegrador;

public class Ronda {

	private String ronda;
	private Partido partido;
	private Integer puntos;
	
	
	public Ronda(String ronda,Partido partido) {
		setRonda(ronda);
		setPartido(partido);		
	}
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public String getRonda() {
		return ronda;
	}

	public void setRonda(String ronda) {
		this.ronda = ronda;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	
}
