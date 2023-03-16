package trabajoPracticoClase4;
import java.util.Scanner;
public class Ejercicio1c {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int vector[] = new int [3];
		System.out.println("Ejercicio 1-c)\n\n");
		
		vector=stringAVectorEntero(vector);
		mostrarVector(vector);
		
		vector=criterioDeOrdenamiento(vector);
		mostrarVector(vector);
		scn.close();
	}
	
////////////EN ESTA FUNCION SE MUESTRA EL VECTOR POR PANTALLA ///////////////
private static void mostrarVector(int [] vector) {
	System.out.println("A continuacion se muestra el contenido del vector : ");
			for (int num : vector) {
				System.out.println(num);
			}
			
}

//////////// EN ESTA FUNCION SE PROCESA EL STRING QUE RECIBE Y DEVUELVE UN VECTOR CON NUMEROS ///////////////
private static int [] stringAVectorEntero(int [] vector) {
	char separador=' ';
	String auxiliar="";
	int b=-1;	
	Scanner scn = new Scanner(System.in);
	
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
	scn.close();
	return vector;
}


////////////EN ESTA FUNCION SE ORDENA EL VECTOR EN FORMA ASCENDENTE ///////////////
private static int [] ordenarAscendente(int [] vector) {
	int b;
	int auxiliar=0;
	
	for (int a=0;a<vector.length-1;a++) {					
		for (b=a+1;b<vector.length;b++) {		
			
				if (vector[b]<=vector[a]) {
				auxiliar=vector[a];	
				vector[a]=vector[b];
				vector[b]=auxiliar;
				}
			}			
	}
	return vector;
}





////////////EN ESTA FUNCION SE ORDENA EL VECTOR EN FORMA ASCENDENTE ///////////////
private static int [] ordenarDescendente(int [] vector) {
int b;
int auxiliar=0;

for (int a=0;a<vector.length-1;a++) {					
for (b=a+1;b<vector.length;b++) {		

	if (vector[b]>=vector[a]) {
		auxiliar=vector[a];	
		vector[a]=vector[b];
		vector[b]=auxiliar;
		}}			
}
return vector;
}



////////////EN ESTA FUNCION SE ESTABLECE EL CRITERIO DE ORDENAMIENTO Y SE ORDENA EL VECTOR ///////////////
private static int [] criterioDeOrdenamiento(int [] vector) {
char ascendente='a';
char descendente='d';
Scanner scn = new Scanner(System.in);

System.out.println("\nAhora ingrese el criterio de ordenamiento : 'a' para ascedente y 'd' para descendente ");
String criterio = scn.nextLine();
		if (criterio.toLowerCase().charAt(0)==ascendente) {
			System.out.println("Su ingreso fue 'a' - ascendente.");
			vector=ordenarAscendente(vector);
			} else {
					if (criterio.toLowerCase().charAt(0)==descendente) {
						System.out.println("Su ingreso fue 'd' - descendente.");
						vector=ordenarDescendente(vector);
						}
			}

		scn.close();
System.out.println("VECTOR ORDENADO!!");
return vector;
}

}
