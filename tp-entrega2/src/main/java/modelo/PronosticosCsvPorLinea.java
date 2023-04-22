package modelo;


import com.opencsv.bean.CsvBindByPosition;

public class PronosticosCsvPorLinea {
	
	// LECTURA DEL ARCHIVO "pronosticos.csv" QUE TIENE REGISTROS DE LA FORMA :
	// |participante|equipo1	|gana1|empate|gana2|equipo2			|
	// | mariana	|argentina	|  x  |      |     |arabia saudita	|
	
	@CsvBindByPosition(position = 0)
    private String participante;
    @CsvBindByPosition(position = 1)
    private String equipo1;
    @CsvBindByPosition(position = 2)
    private String gana1;
    @CsvBindByPosition(position = 3)
    private String empata;
    @CsvBindByPosition(position = 4)
    private String gana2;
    @CsvBindByPosition(position = 5)
    private String equipo2;
    
	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	public String getEquipo1() {
		return equipo1;
	}
	
	public String getGana1() {
		return gana1;
	}
	
	public String getEmpata() {
		return empata;
	}
	
	public String getGana2() {
		return gana2;
	}

	public String getEquipo2() {
		return equipo2;
	}

}
