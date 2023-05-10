package modelo;
import modelo.ResultadoPartido;

public class Pronostico {
	
	private Partido partido;
	private ResultadoPartido resultado;
	private Integer puntos=0;
	
	public Pronostico(Partido unPartido){
		this.setPartido(unPartido);
	}
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public ResultadoPartido getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoPartido resultado) {
		this.resultado = resultado;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	public void sumarPunto() {
		this.puntos = 1;
	}

}
