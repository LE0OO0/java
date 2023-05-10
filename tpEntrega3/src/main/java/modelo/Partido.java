package modelo;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private Integer golesEquipo1;
	private Integer golesEquipo2;
	
	public Partido (Equipo unEquipo,Equipo otroEquipo,Integer goles1, Integer goles2) {
		this.equipo1=unEquipo;
		this.equipo2=otroEquipo;
		this.golesEquipo1=goles1;
		this.golesEquipo2=goles2;		
	} 
	
	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Integer getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(Integer golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public Integer getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(Integer golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public ResultadoEnum resultado(Equipo equipo){
		ResultadoEnum resultado=null;
		
		
		return resultado;
	}
		
	}

