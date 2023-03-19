package trabajoPracticoClase5;

public class Producto {
	
	private String nombre;
	private int cantidad;
	private int precioUnitario;
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
			
	public int getPrecio() {
		return precioUnitario * cantidad;
	}
	
}
