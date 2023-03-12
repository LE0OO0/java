package trabajoPracticoClase1;

public class Clase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//a. Utilizando la sentencia while, imprima todos los números entre 2 variables “a”
		//y “b”. Su código puede arrancar (por ejemplo)
		//int numeroInicio = 5;
		//int numeroFin = 14;		
		// Se deberían mostrar los números:
		//5,6,7,8,9,10,11,12,13,14
		
		
		int numeroInicio = 5;
		int numeroFin = 14;
		
		System.out.println("Ejercicio 1-a)\n");
		
		while(numeroInicio<=numeroFin) {
			System.out.println(numeroInicio);
			numeroInicio++;
		}		
		
		
		
		
		
		// b. A lo anterior, solo muestre los números pares
		System.out.println("\nEjercicio 1-b)\n");
		
		numeroInicio = 5;
		
		while(numeroInicio<=numeroFin) {
		if (numeroInicio % 2==0) {
			System.out.println(numeroInicio);}		
			numeroInicio++;
		}
		
		
		//c. A lo anterior, con una variable extra, elija si se deben mostrar los números
		//pares o impares
		System.out.println("\nEjercicio 1.c)\n");

		boolean pares=false;
		

		numeroInicio = 5;
		
		while(numeroInicio<=numeroFin) {
		if (pares) {
					if (numeroInicio % 2==0) {
						System.out.println(numeroInicio);
						}		
					numeroInicio++;
				}
		 		else {
		 				if (numeroInicio % 2!=0) {
		 					System.out.println(numeroInicio);
		 					}		
					numeroInicio++;
				}	
		}
		
		//d. Utilizando la sentencia for, hacer lo mismo que en (b) pero invirtiendo el orden

		System.out.println("\nEjercicio 1.d)\n");

		numeroInicio = 5;
		
		for(numeroFin=14;numeroFin>=numeroInicio;numeroFin--) {
			if (numeroFin % 2==0) {
						System.out.println(numeroFin);
						}
				}	
		
		
		//2. Dado el siguiente texto, vamos a atacar el siguiente problema: “determinar si una
		//persona pertenece al segmento de ingresos altos”. Del i al iii, la idea es hacerlo en
		//papel y lápiz y sólo implementar el cuarto.
		//“Son hogares que declaran reunir alguna de las siguientes condiciones, considerando a
		//todas y todos los convivientes:
		//● Ingresos mensuales totales del hogar equivalentes o superiores a $489.083
		//(3,5 canastas básicas para un hogar tipo 2 según el INDEC).
		//● Tener 3 o más vehículos con una antigüedad menor a 5 años.
		//● Tener 3 o más inmuebles.
		//● Poseer una embarcación, una aeronave de lujo o ser titular de activos
		//societarios que demuestren capacidad económica plena.”


		System.out.println("\nEjercicio 2.d)\n");

		 
		//para probar que si pertenece
		 
		float ingresosMensuales=489083;
		double canastasBasicas=3.5;
		int vehiculosAntiguedadMenor=3;
		int inmuebles=3;
		boolean lujoOActivos=true;		 
		 

		/*
		 
		 //para probar que no pertenece
		  
		float ingresosMensuales=481083;
		double canastasBasicas=3.1;
		int vehiculosAntiguedadMenor=2;
		int inmuebles=2;
		boolean lujoOActivos=false;
		*/
		
		if ((ingresosMensuales>=489083) || (canastasBasicas>=3.5) || (vehiculosAntiguedadMenor>=3) || (inmuebles>=3) || (lujoOActivos)) {
			System.out.println("Pertenece al segmento de ingresos altos");
		} else {
			System.out.println("No pertenece al segmento de ingresos altos");
		}
		
		
		

		
		
		
		int numeros[] = new int[]{1,37,16};
		 String separado = "3_tristes tigres_del_13\\";
		 System.out.println("longitud : "+separado);
		 System.out.println("longitudaaaaaaa : "+numeros[2]);
		 
		}
		
		
	}


