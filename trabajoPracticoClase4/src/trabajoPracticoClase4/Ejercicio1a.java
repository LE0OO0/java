package trabajoPracticoClase4;

import java.util.Scanner;

public class Ejercicio1a {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int vector[] = new int [3];
		System.out.println("Ejercicio 1-a)\n\n");
		char separador=' ';
		String auxiliar="";
		int b=-1;	
		char ascendente='a';
		char descendente='d';
		int aux=0;
		
		System.out.println("Por favor ingrese 3 numeros separados por un espacio y luego pulse ENTER : ");
		String numeros = scn.nextLine();
		
		for (int a=0;a<numeros.length();a++) {
			if (numeros.charAt(a)==separador) {
				
				// si encuentro un espacio en la cadena incremento el array y guardo el valueof del auxiliar en el vector
				b++;
				vector[b]=Integer.valueOf(auxiliar);
				//ahora auxiliar se inicializa a vacio para llenar otro string
				auxiliar="";						
			} else {				
				// si no encuentro un espacio voy llenando la cadena
				auxiliar=auxiliar + numeros.charAt(a);
			}
			
			if(a+1==numeros.length() && (auxiliar!=null)) {
				//si llegue al final de la cadena examinada debo procesar el string auxiliar aunque no haya un espacio final
				b++;
				vector[b]=Integer.valueOf(auxiliar);
				}
			}	// for (int a=0;a<numeros.length();a++) {
			
		System.out.println("LA CADENA DE TEXTO CON NUMEROS SEPARADOS POR ESPACIOS AHORA SE HA PROCESADO Y SE HA ALMACENADO EN UN VECTOR. ");
		System.out.println("CADA JUEGO DE NUMEROS SEPARADOS POR UN ESPACIO AHORA ES UN ELEMENTO DE UN VECTOR DE ENTEROS.");

		
		
		

		System.out.println("\nAhora ingrese el criterio de ordenamiento : 'a' para ascedente y 'd' para descendente ");
		String criterio = scn.nextLine();
				if (criterio.toLowerCase().charAt(0)==ascendente) {
					System.out.println("Su ingreso fue 'a' - ascendente.");
					for (int a=0;a<vector.length-1;a++) {					
						for (b=a+1;b<vector.length;b++) {		
							if (vector[b]<=vector[a]) {
							aux=vector[a];	
							vector[a]=vector[b];
							vector[b]=aux;
							}
						}
					} 
						
					} else {
					if (criterio.toLowerCase().charAt(0)==descendente) {
								System.out.println("Su ingreso fue 'd' - descendente.");
								for (int a=0;a<vector.length-1;a++) {					
									for (b=a+1;b<vector.length;b++) {
										if (vector[b]>=vector[a]) {
											aux=vector[a];	
											vector[a]=vector[b];
											vector[b]=aux;
											}
									}			
								}
						}
					}
		System.out.println("VECTOR ORDENADO!!");
		System.out.println("A continuacion se muestra el contenido del vector : ");
		for (int num : vector) {
			System.out.println(num);
		}
		scn.close();

	}

}
