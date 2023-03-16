package trabajoPracticoClase4;

import java.util.Scanner;

public class Ejercicio1b {

	public static void main(String[] args) {		
		Scanner scn = new Scanner(System.in);
		int vector[] = new int [3];
		System.out.println("Ejercicio 1-b)\n\n");
		int b=-1;	
		char ascendente='a';
		char descendente='d';
		int aux=0;
		
		System.out.println("A continuacion se le solicita que ingrese el primero de 3 numeros.");
		
		System.out.println("Por favor ingrese el PRIMER numero y luego pulse ENTER : ");
		String numero1 = scn.nextLine();		
		System.out.println("Primer valor ingresado : "+numero1);
		b++;
		vector[b]=Integer.valueOf(numero1);

		System.out.println("\nPor favor ingrese el SEGUNDO numero y luego pulse ENTER : ");
		String numero2 = scn.nextLine();		
		System.out.println("Segundo valor ingresado : "+numero2);
		b++;
		vector[b]=Integer.valueOf(numero2);
		
		System.out.println("\nPor favor ingrese el TERCER numero y luego pulse ENTER : ");
		String numero3 = scn.nextLine();
		System.out.println("Tercer valor ingresado : "+numero3);
		b++;
		vector[b]=Integer.valueOf(numero3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
