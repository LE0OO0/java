package modelo;

import com.opencsv.bean.CsvBindByPosition;

public class Resultados {

    @CsvBindByPosition(position = 0)
    private String equipo1;
    @CsvBindByPosition(position = 1)
    private String golesEquipo1;
    @CsvBindByPosition(position = 2)
    private String golesEquipo2;
    @CsvBindByPosition(position = 3)
    private String equipo2;
    
	public String getEquipo1() {
		return equipo1;
	}
	
	public String getGolesEquipo1() {
		return golesEquipo1;
	}
	
	public String getEquipo2() {
		return equipo2;
	}
	
	public String getGolesEquipo2() {
		return golesEquipo2;
	}
}
