package modelo;

import com.opencsv.bean.CsvBindByPosition;

public class ResultadosCsvPorLinea {
	
	// LECTURA DEL ARCHIVO "resultados.csv" QUE TIENE REGISTROS DE LA FORMA :
		// |ronda	|equipo1	|goles1	|goles2	|equipo2		|
		// | 1		|argentina	|  1	|   2	|arabia saudita	|
		
		@CsvBindByPosition(position = 0)
	    private Integer ronda;
	    @CsvBindByPosition(position = 1)
	    private String equipo1;
	    @CsvBindByPosition(position = 2)
	    private String goles1;
	    @CsvBindByPosition(position = 3)
	    private String goles2;
	    @CsvBindByPosition(position = 4)
	    private String equipo2;
	    
		public Integer getRonda() {
			return ronda;
		}
		public void setRonda(Integer ronda) {
			this.ronda = ronda;
		}
		public String getEquipo1() {
			return equipo1;
		}
		public void setEquipo1(String equipo1) {
			this.equipo1 = equipo1;
		}
		public String getGoles1() {
			return goles1;
		}
		public void setGoles1(String goles1) {
			this.goles1 = goles1;
		}
		public String getGoles2() {
			return goles2;
		}
		public void setGoles2(String goles2) {
			this.goles2 = goles2;
		}
		public String getEquipo2() {
			return equipo2;
		}
		public void setEquipo2(String equipo2) {
			this.equipo2 = equipo2;
		}
	    
}