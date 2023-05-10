package modelo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Configuracion {
	// LECTURA DEL ARCHIVO "configuracioncsv" QUE TIENE REGISTROS DE LA FORMA :
	// driver a utilizar,url de conexion,usuario de la base de datos, contraseña de la base de datos,
	// puntaje por partido ganado, puntos extra
		    private String driver;
		    private String url;
		    private String usuario;
		    private String contraseña;
		    private Integer puntosASumar;
			private Integer puntosExtra;
			
		    public Configuracion(String archivo) {
				String lectura;
		    	String [] auxiliar;
		    	Path rutaEntrada=Paths.get(archivo);
		    	try {		    		
		    		lectura=Files.readString(rutaEntrada);		    			
					auxiliar=lectura.split(",");
					this.setDriver(auxiliar[0]);
					this.setUrl(auxiliar[1]);
					this.setUsuario(auxiliar[2]);
					this.setContraseña(auxiliar[3]);
					this.setPuntosASumar(Integer.parseInt(auxiliar[4]));
					this.setPuntosExtra(Integer.parseInt(auxiliar[5]));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		    public String getDriver() {
				return driver;
			}
			public void setDriver(String driver) {
				this.driver = driver;
			}
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
			public String getUsuario() {
				return usuario;
			}
			public void setUsuario(String usuario) {
				this.usuario = usuario;
			}
			public String getContraseña() {
				return contraseña;
			}
			public void setContraseña(String contraseña) {
				this.contraseña = contraseña;
			}
			public Integer getPuntosASumar() {
				return puntosASumar;
			}
			public void setPuntosASumar(Integer puntosASumar) {
				this.puntosASumar = puntosASumar;
			}
			public Integer getPuntosExtra() {
				return puntosExtra;
			}
			public void setPuntosExtra(Integer puntosExtra) {
				this.puntosExtra = puntosExtra;
			}
}
