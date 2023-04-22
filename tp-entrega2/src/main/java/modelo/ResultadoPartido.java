package modelo;


public class ResultadoPartido {

/*
 * private	boolean resultado;
 


public int Resultado(Partido ) {	
if (p.getGolesEquipo1()>p.getGolesEquipo2()) {return 1;} //retorna "1" indicando que gano el equipo 1	
if (p.getGolesEquipo1()<p.getGolesEquipo2()) {return 2;} //retorna "2" indicando que gano el equipo 2
return 0; //retorna "0" indicando que empataron
}

*/
	
	private String resultado;
	
	public ResultadoPartido(Partido p) {	
		if (p.getGolesEquipo1()>p.getGolesEquipo2()) {this.resultado="GANA1"; return;}	
		if (p.getGolesEquipo1()<p.getGolesEquipo2()) {this.resultado="GANA2"; return;}
		this.resultado="EMPATE";
		}

	



}
