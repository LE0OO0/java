package modelo;

import com.opencsv.bean.CsvBindByPosition;

public class RondaDePartidos {

    @CsvBindByPosition(position = 0)
    private String equipo1;
    @CsvBindByPosition(position = 1)
    private String gana1;
    @CsvBindByPosition(position = 2)
    private String empata;
    @CsvBindByPosition(position = 3)
    private String gana2;
    @CsvBindByPosition(position = 4)
    private String equipo2;
    
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
