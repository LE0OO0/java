package trabajoPracticoClase3;

public class clase3ArraysYStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "palabra";
		char letra = 'a';
		int n=0;
		
		System.out.println("Ejercicio 1-a)\n");
		
		for (int i=0; i<cadena.length();i++) {
			if (cadena.charAt(i)==letra) {
				n++;
			}
			
			}
		System.out.println("Buscar en la cadena : " + cadena);
		System.out.println("Buscar la letra     : " + letra);
		System.out.println("Cantidad de apariciones de la letra " + "\"" + letra + "\"" + " : " + n);
		
		///////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\nEjercicio 1-b)\n");
		int vector[] = new int [] {41,4,55};		
		int b;
		int auxiliar=0;
		boolean creciente=true;		
		
		for (int a=0;a<vector.length-1;a++) {					
			for (b=a+1;b<vector.length;b++) {		
				
				if (creciente) {
					if (vector[b]<=vector[a]) {
					auxiliar=vector[a];	
					vector[a]=vector[b];
					vector[b]=auxiliar;
					}
				} else {
						if (vector[b]>=vector[a]) {
							auxiliar=vector[a];	
							vector[a]=vector[b];
							vector[b]=auxiliar;
							}
						}					
				}			
		}
		
		for(int num : vector) {
			System.out.println(num);
			}

		///////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\nEjercicio 1-c)\n");
		int vector2[] = new int [] {1,2,3};
		int numero=0;
		int suma=0;
		
		for (int a=0;a<vector2.length;a++) {
			if (vector2[a]>numero) {
				suma=suma+vector2[a];
				}
		}
		System.out.println("La suma total es : " + suma);
		
		///////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\nEjercicio 2)\n");
		
		
		String codificar="123";
		int ascii;
		char caracter;
		int desplazo=2;
		
		System.out.println("Cadena original   : " + codificar);
		System.out.println("Desplazamiento    : " + desplazo);
		System.out.print("Cadena codificada : ");
		for (int a=0;a<codificar.length();a++) {
			ascii=(int)codificar.charAt(a);
			ascii=ascii+desplazo;
					if (ascii>255) {
									ascii=ascii-256;
									}
			caracter=(char)ascii;
			System.out.print(caracter);
			}
		System.out.println("\n");
		System.out.println("El desplazamiento se puede cambiar modificando el valor de la variable desplazo.");
		}
	}


