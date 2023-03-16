package trabajoPracticoClase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("\nEjercicio 3)\n");
		
		String operacion=solicitarOperacion();
		int desplazamiento=solicitarDesplazamiento();
		String entrada=solicitarEntrada();
		String salida=solicitarSalida();
		
		Path rutaEntrada=Paths.get(entrada);
		Path rutaSalida=Paths.get(salida);
		
		System.out.println("leyendo de " + entrada + " escribiendo en " + salida);
		System.out.println("Operacion a realizar : " + operacion + " desplazamiento " + desplazamiento);

		String linea="";		
		int ascii=0; 
		char carac;
		try {
			Files.writeString(rutaSalida, linea);
				for (byte content : Files.readAllBytes(rutaEntrada)) {
					
					if (operacion.toLowerCase().charAt(0)=='c') {
							ascii=content+desplazamiento;
								if (ascii>255) {
										ascii=ascii-256;
										}
					} else {						
							ascii=content-desplazamiento;
								if (ascii<0) {
									ascii=256+ascii;
										}
					}
					
					carac=(char)ascii;
					linea=linea+carac;
					System.out.println(carac + " " + content);
				    Files.writeString(rutaSalida, linea,StandardOpenOption.APPEND);
		            linea="";
		            }
		 } catch (IOException e) {
			e.printStackTrace();
		 }
		scn.close();
		}


//////////// EN ESTA FUNCION SE SOLICITA LA OPERACION QUE SE DESEA REALIZAR //////////
private static String solicitarOperacion() {
	Scanner scn = new Scanner(System.in);
	System.out.println("Por favor indique la operacion a realizar : 'c' codificacion y 'd' para decodificacion");
	String operacion = scn.nextLine();		
	System.out.println("Operacion ingresada : " + operacion + "\n");
	return operacion;
}
	
////////////EN ESTA FUNCION SE SOLICITA EL DESPLAZAMIENTO QUE SE DESEA REALIZAR //////////
private static int solicitarDesplazamiento() {
Scanner scn = new Scanner(System.in);
System.out.println("Indique el valor de desplazamiento, por ejemplo si elijió codificacion y ahora elige desplazamiento 1");
System.out.println("entonces una 'A' se codificara a 'B'");
System.out.println("Y si elijió decodificacion y ahora elige desplazamiento 1 entonces una 'B' se decodificara a 'A'");
int desplazamiento = Integer.parseInt(scn.nextLine());
return desplazamiento;
}

////////////EN ESTA FUNCION SE SOLICITA EL ARCHIVO DE ENTRADA QUE SE VA A LEER //////////
private static String solicitarEntrada() {
Scanner scn = new Scanner(System.in);
System.out.println("Por favor ingrese la ruta del archivo de 'entrada', por ejemplo 'C:\\CARPETA\\ENTRADA.TXT'. Su ingreso es : ");
String entrada = scn.nextLine();		
System.out.println("Ruta ingresada : " + entrada + "\n");
return entrada;
}

////////////EN ESTA FUNCION SE SOLICITA EL ARCHIVO DE SALIDA QUE SE VA A ESCRIBIR //////////
private static String solicitarSalida() {
Scanner scn = new Scanner(System.in);
System.out.println("Por favor ingrese la ruta del archivo de 'salida', por ejemplo 'C:\\CARPETA\\SALIDA.TXT'. Su ingreso es : ");
String salida = scn.nextLine();		
System.out.println("Ruta ingresada : " + salida + "\n");
scn.close();
return salida;
}


}
