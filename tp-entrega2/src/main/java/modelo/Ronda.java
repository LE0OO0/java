package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

private	Integer nro;
private List<Partido> partidos;

public Ronda(Integer ronda) {	
	this.nro=ronda;
	this.partidos=new ArrayList<Partido>();
	}

public void agregarPartidos(Partido unPartido) {
	this.partidos.add(unPartido);
	
}
	
public Integer getNro() {
	return nro;
}

public void setNro(Integer nro) {
	this.nro = nro;
}

public List<Partido> getPartidos() {
	return partidos;
}

public void setPartidos(List<Partido> partidos) {
	this.partidos = partidos;
}

public Integer puntos() {
	return 0;
}	

public void mostrarRonda(Ronda r) {	
	for (Partido p : r.partidos) {		
	System.out.printf("|%-20s|%-20s|%-7s|%-7s|%-20s|\n",r.nro,p.getEquipo1().getNombre(),p.getGolesEquipo1(),
			p.getGolesEquipo2(),p.getEquipo2().getNombre());
	}
}
	
}
