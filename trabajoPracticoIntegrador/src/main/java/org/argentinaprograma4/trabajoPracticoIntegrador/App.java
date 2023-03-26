package org.argentinaprograma4.trabajoPracticoIntegrador;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import modelo.Resultados;
import modelo.RondaDePartidos;

public class App 
{
    public static void main( String[] args )
    {

    	// LLENADO MANUAL PARA PRUEBAS
    	
    	Equipo equipo1=new Equipo("Argentina","equipo1");
    	Equipo equipo2=new Equipo("Arabia saudita","equipo2");
    	Partido partido1=new Partido(equipo1,equipo2,1,2);
    	
    	Equipo equipo3=new Equipo("Polonia","equipo1");
    	Equipo equipo4=new Equipo("Mexico","equipo2");
    	Partido partido2=new Partido(equipo3,equipo4,0,0);
    	
    	Ronda ronda1Juego1 = new Ronda("Primera ronda",partido1);
    	Ronda ronda1Juego2 = new Ronda("Primera ronda",partido2);
    	
    	// FIN DE LLENADO MANUAL DE PRUEBAS
    	
    	
      //En la variable args va a viajar la ruta del archivo que queremos que abra el programa
        if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningún archivo como argumento!");
            System.out.println("RECUERDA que debes ingresar 2 archivos de entrada como parametro.");
            System.out.println("DEBES INGRESAR - PARAMETRO 1 - : la ruta y el nombre de un archivo de partidos.");
            System.out.println("DEBES INGRESAR - PARAMETRO 2 - : la ruta y el nombre de un archivo de resultados.");
            System.exit(88);
        }
        
        if(args.length == 1){
            System.out.println("ERROR: Cantidad de parametros insuficientes!");
            System.out.println("RECUERDA que debes ingresar 2 archivos de entrada como parametro.");
            System.out.println("DEBES INGRESAR - PARAMETRO 1 - : la ruta y el nombre de un archivo de partidos.");
            System.out.println("DEBES INGRESAR - PARAMETRO 2 - : la ruta y el nombre de un archivo de resultados.");
            System.exit(88);
        }
     
        
        
        System.out.println("\n");
        
        List <RondaDePartidos> listaDeRondaDePartidos;
        List <Resultados> listaDeResultados;
        int puntos=0,goles1,goles2;
        
        try {
            // LEER LOS PRONOSTICOS
           listaDeRondaDePartidos = new CsvToBeanBuilder(new FileReader(args[0]))
                      // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(RondaDePartidos.class)
                    .build()
                    .parse();

           System.out.println(completarCadena("EQUIPO 1")+completarCadena("GANA 1")+completarCadena("EMPATA")+completarCadena("GANA 2")+completarCadena("EQUIPO 2"));

            for (RondaDePartidos ronda : listaDeRondaDePartidos) {
                System.out.println(completarCadena(ronda.getEquipo1()) + completarCadena(ronda.getGana1()) +
                		completarCadena(ronda.getEmpata()) + completarCadena(ronda.getGana2()) + completarCadena(ronda.getEquipo2()));
            	}

            System.out.println("\n");
            
            // LEER LOS RESULTADOS
                listaDeResultados = new CsvToBeanBuilder(new FileReader(args[1]))
                           // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                         .withType(Resultados.class)
                         .build()
                         .parse();
         
                System.out.println(completarCadena("EQUIPO 1") + completarCadena("GOLES EQUIPO 1") + completarCadena("GOLES EQUIPO 2") + completarCadena("EQUIPO 2"));

                 for (Resultados resultado : listaDeResultados) {
                     System.out.println(completarCadena(resultado.getEquipo1()) + completarCadena(resultado.getGolesEquipo1())  +
                     		completarCadena(resultado.getGolesEquipo2()) + completarCadena(resultado.getEquipo2()));
                 }
                 
                 
            //AQUI SE REALIZA LA COMPARACION CON 2 CICLOS FOR ANIDADOS ENTRE RESULTADOS Y PRONOSTICOS
                 System.out.println("\n");
                 

                 for (Resultados resultado : listaDeResultados) {

                	 for (RondaDePartidos ronda : listaDeRondaDePartidos) {
                    	 
                    	 goles1=Integer.parseInt(resultado.getGolesEquipo1());
                    	 goles2=Integer.parseInt(resultado.getGolesEquipo2());

                    	 if (
                    			 resultado.getEquipo1().equals(ronda.getEquipo1()) || 
                    			 resultado.getEquipo2().equals(ronda.getEquipo1()) &&
                    			 resultado.getEquipo1().equals(ronda.getEquipo2()) || 
                    			 resultado.getEquipo2().equals(ronda.getEquipo2()))                    			 
                    		 {
                    		 if (ronda.getGana1()=="x" && goles1>goles2) {puntos++;}
                    		 if (ronda.getGana2()=="x" && goles2>goles1) {puntos++;}
                    		 if (ronda.getEmpata().equals("x")) {puntos++;}
                    		 }
                      }

                 }
                 
        } catch (IOException e) {
            e.printStackTrace();
    }   
        System.out.println("Puntaje : " + puntos);
        
    }
    
////////////ESTA FUNCION RELLENA UNA CADENA CON ESPACIOS HASTA COMPLETAR 20 CARACTERES //////////
////////// SI LA LONGITUD DE LA CADENA ES MENOR A 20, SOLO PARA PRESENTACION EN PANTALLA //////////
private static String completarCadena(String cadena) {
	if (cadena.length()<20) {
		for (int a=cadena.length();a<20;a++) {
			cadena=cadena+" ";			
		}
	}
	return cadena;
}

}
