package trabajoPracticoClase4;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long valor=0; //definido para la suma
		char sumar='s';
		char multiplicar='m';
		int longitud;
	    int aux=0;
	    String auxiliar;
		
		System.out.println("Ejercicio 2)\n\n");
		
		System.out.println("Por favor ingrese la ruta del archivo, por ejemplo 'C:\\CARPETA\\ARCHIVO.TXT'. Su ingreso es : ");
		String ruta = scn.nextLine();		
		System.out.println("Ruta ingresada : "+ruta);
		
		System.out.println("\nIngrese la operacion a realizar : 's' para suma y 'm' para multiplicacion");
		String operacion = scn.nextLine();		
		System.out.println("Operacion ingresada : " + operacion + "\n");
					if (operacion.toLowerCase().charAt(0)==multiplicar) {
							valor=1; //si eligieron multiplicacion defino el neutro de la multiplicacion
							}
		
		
		Path rutaDelArchivo = Paths.get(ruta);		
		
		try {
			for (String linea : Files.readAllLines(rutaDelArchivo)) {
				
				auxiliar=linea;
				aux=Integer.parseInt(auxiliar);			
				longitud=auxiliar.length();
				System.out.print("Valor leido : ");
				if (auxiliar.length()<5) {
					for(int n=auxiliar.length();n!=5; n++) { System.out.print(" "); }			
				}
				System.out.print(auxiliar + "\tResultado de la operacion : ");
				
				if (operacion.toLowerCase().charAt(0)==sumar) {
				valor=valor+Integer.parseInt(auxiliar);
				
				} else {
						if (operacion.toLowerCase().charAt(0)==multiplicar) {
						valor=valor*Integer.parseInt(auxiliar);						
						}
					
				}
				System.out.print(valor+"\n");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("\nRESULTADO DE LA OPERACION : " + valor);
		scn.close();

	}

}
