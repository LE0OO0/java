package trabajoPracticoClase5;

public class Carrito {
	
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	
	public Carrito(Producto pr1, Producto pr2, Producto pr3) {
		this.producto1=pr1;
		this.producto2=pr2;
		this.producto3=pr3;
		
	}
	
	public int precio() {
		
		return producto1.getPrecio() + producto2.getPrecio() + producto3.getPrecio(); 
	}
	
	
	
}
