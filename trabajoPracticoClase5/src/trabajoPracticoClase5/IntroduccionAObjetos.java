package trabajoPracticoClase5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IntroduccionAObjetos {

	public static void main(String[] args) {		 
		 String entrada="C:\\CARPETA\\ARCHIVO.TXT";
		 System.out.print("Leyendo el archivo : "+entrada+"\n\n");
		 Path rutaEntrada=Paths.get(entrada);
		 
		 Producto pr1=new Producto();
		 Producto pr2=new Producto();
		 Producto pr3=new Producto();
		 	
			try {
				String [] auxiliar;
				int a=0;
				System.out.print("cant"+"\t\tPrecio Unitario"+"\t\tProducto"+"\n");
				Carrito carrito1 = new Carrito(pr1,pr2,pr3);
				for (String linea : Files.readAllLines(rutaEntrada)) {
					auxiliar=linea.split(",");
							a++;		
							if (a==1) 
							{
								pr1.setCantidad(Integer.parseInt(auxiliar[0]));
								pr1.setPrecioUnitario(Integer.parseInt(auxiliar[1]));
								pr1.setNombre(auxiliar[2]);
								System.out.println(pr1.getCantidad()+"\t\t\t"+pr1.getPrecioUnitario()+"\t\t "+pr1.getNombre());
							}
						
							if (a==2){
								pr2.setCantidad(Integer.parseInt(auxiliar[0]));
								pr2.setPrecioUnitario(Integer.parseInt(auxiliar[1]));
								pr2.setNombre(auxiliar[2]);
								System.out.println(pr2.getCantidad()+"\t\t\t"+pr2.getPrecioUnitario()+"\t\t"+pr2.getNombre());
								}
							
							if (a==3) {
								pr3.setCantidad(Integer.parseInt(auxiliar[0]));
								pr3.setPrecioUnitario(Integer.parseInt(auxiliar[1]));
								pr3.setNombre(auxiliar[2]);
								System.out.println(pr3.getCantidad()+"\t\t\t"+pr3.getPrecioUnitario()+"\t\t"+pr3.getNombre());
								carrito1=new Carrito(pr1,pr2,pr3);
							}
						}
				System.out.println("\nCosto Final : "+carrito1.precio());
					} catch (IOException e) {

						e.printStackTrace();
					}
			
	}
}
