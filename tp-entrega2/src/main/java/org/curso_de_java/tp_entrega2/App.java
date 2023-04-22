package org.curso_de_java.tp_entrega2;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import modelo.ResultadosCsvPorLinea;
import modelo.PronosticosCsvPorLinea;
import modelo.ResultadoPartido;
import modelo.Equipo;
import modelo.Persona;
import modelo.Pronostico;
import modelo.Partido;
import modelo.Ronda;
import modelo.Torneo;

public class App 
{
	public static void main( String[] args )
    {
    	verificarParametros(args);
    	Torneo mundial=new Torneo("mundial catar 2022");
    	
    	List <Persona> personas;
    	List <ResultadosCsvPorLinea> tablaResultadoCsv;
    	List <PronosticosCsvPorLinea> tablaPronosticoCsv;
    	
    	tablaPronosticoCsv=leerPronosticoCsv(args[0],mundial);
    	tablaResultadoCsv=leerResultadosCsv(args[1],mundial);
    	calcularPuntajes(mundial);
        System.out.println("\n");   
    }
	
	
	
	public static int saberResultado(Pronostico pro, Partido par) {
		int gol1=pro.getPartido().getGolesEquipo1();
		int gol2=pro.getPartido().getGolesEquipo2();
		
		String nombre1pro=pro.getPartido().getEquipo1().getNombre();
		String nombre1par=par.getEquipo1().getNombre();
		
		String nombre2pro=pro.getPartido().getEquipo2().getNombre();
		String nombre2par=par.getEquipo2().getNombre();

		System.out.println("PARTIDO : "+nombre1pro+" VS "+nombre2pro);

		System.out.print("PRONOSTICO ");
		if (gol1==gol2) System.out.println("--> EMPATE");
		if (gol1>gol2) System.out.println("--> GANA : "+nombre1pro);
		if (gol2>gol1) System.out.println("--> GANA : "+nombre2pro);
		
		System.out.println("RESULTADO REAL : "+nombre1pro+" "+par.getGolesEquipo1()+" - "+nombre2pro+" "+par.getGolesEquipo2());

// en los siguientes "if" no hace falta el else porque cada uno tiene un return		
// if (pronosticaba que el equipo1 ganaba el partido) and 
// (realmente el equipo1 ganó el partido) retorna un punto
		
		if ((gol1>gol2) && (par.getGolesEquipo1()>par.getGolesEquipo2())) {
				pro.sumarPunto();
				System.out.println("suma 1 punto porque gana "+nombre1pro);
				return 1;
				}
	
		if ((gol2>gol1) && (par.getGolesEquipo2()>par.getGolesEquipo1())) {
				pro.sumarPunto();
				System.out.println("suma 1 punto porque gana "+nombre2pro);
				return 1;
				}
		
			if ((gol1==gol2) && (par.getGolesEquipo2()==par.getGolesEquipo1())) {										
				pro.sumarPunto();
				System.out.println("suma 1 punto porque empatan");
				return 1;
				}
	
		System.out.println("No suma ningun punto porque no acertó el pronóstico para este partido");
		return 0;
	}


///////////////////////////////////////////////////////////////////////////////////////////
////////////COMPARA CADA PARTIDO DEL PRONOSTICO CON EL PARTIDO REAL DE LA RONDA //////////
/////////////////////////////////////////////////////////////////////////////////////////
public static int partidoRonda(Pronostico pro,Ronda ron) {
	String nombre1pro=pro.getPartido().getEquipo1().getNombre();
	String nombre2pro=pro.getPartido().getEquipo2().getNombre();
	String nombre1par,nombre2par;
	for(Partido par:ron.getPartidos()) {				
		nombre1par=par.getEquipo1().getNombre();
		nombre2par=par.getEquipo2().getNombre();
		if ((nombre1pro.equals(nombre1par)) && (nombre2pro.equals(nombre2par))){		
			//AQUI SE CALCULAN LOS PUNTAJES
			return saberResultado(pro,par);
			}	
	}
	return 0;
}
	
//////////////////////////////////////////////////////////////////////////////////////////////
//////////// CRUZAR TODOS LOS PRONOSTICOS DE LA PERSONA CON PARTIDOS DE LAS RONDAS //////////
////////////////////////////////////////////////////////////////////////////////////////////
public static int cruzarPronosticosYPartidos(List <Pronostico> pronosticos,List <Ronda> rondas) {
	String nombre1pro,nombre1par,nombre2pro,nombre2par;
	int puntaje=0;
	for (Pronostico  pro: pronosticos) {
		nombre1pro=pro.getPartido().getEquipo1().getNombre();
		nombre2pro=pro.getPartido().getEquipo2().getNombre();

		for(Ronda ron:rondas) {
			puntaje=puntaje+partidoRonda(pro,ron);
		}
	}
return puntaje;
}	
	
////////////////////////////////////////////////////////////////////////////////////////
//////////// CALCULAR LOS PUNTAJES EN BASE A LOS PRONOSTICOS DE LAS PERSONAS //////////
//////////////////////////////////////////////////////////////////////////////////////
	public static void calcularPuntajes(Torneo mundial) {
		List <Pronostico> pronosticos=null;
		List <Ronda> rondas=null;		
		System.out.println("\nCALCULO DE PUNTAJE EN BASE A PRONOSTICOS");
		int puntaje=0;
		String nombre1pro,nombre1par,nombre2pro,nombre2par;
		Boolean salir;
		for (Persona  persona: mundial.getPersonas()) {	      		
				// me trae la lista de pronosticos de una persona
				pronosticos=persona.getPronosticos(persona);
				System.out.println("\nPronostico de : "+persona.getNombre()+"\n");
				salir=false;
				rondas=mundial.getRondas();
				puntaje=cruzarPronosticosYPartidos(pronosticos,rondas);
				persona.setPuntaje(puntaje);
	      		System.out.println("\nPuntaje total de : "+persona.getNombre()+" = "+puntaje);
	      		}
		puntaje=0;
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////// LEER ARCHIVO PRONOSTICOS.CSV ALMACENANDO LOS DATOS EN LAS INSTANCIAS DE LAS CLASES CORRRESPONDIENTES //////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static List leerPronosticoCsv(String archivo,Torneo mundial) {
    	List <PronosticosCsvPorLinea> tablaPronosticoCsv=null;
        System.out.println("\nLeyendo desde : "+archivo+"\n");   
	try {
		tablaPronosticoCsv = new CsvToBeanBuilder(new FileReader(archivo))
                // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
              .withType(PronosticosCsvPorLinea.class)
              .build()
              .parse();
    	
    	System.out.printf("|%-20s|%-20s|%-6s|%-6s|%-6s|%-20s|\n","PARTICIPANTE","EQUIPO 1","GANA 1","EMPATA","GANA 2","EQUIPO 2");
    	System.out.printf("|____________________|____________________|______|______|______|____________________|\n");
    	

    	  int gol1=0,gol2=0;
      		for (PronosticosCsvPorLinea  lineaPronosticosCsv: tablaPronosticoCsv) {
      			Persona persona1=new Persona(lineaPronosticosCsv.getParticipante());      			
      			
      			Equipo uno=new Equipo(lineaPronosticosCsv.getEquipo1(),"");
   				Equipo dos=new Equipo(lineaPronosticosCsv.getEquipo2(),"");      			
   				
      			if (lineaPronosticosCsv.getGana1().equals("x")) {gol1=1; gol2=0;}
      			if (lineaPronosticosCsv.getGana2().equals("x")) {gol2=1; gol1=0;}
      			if (lineaPronosticosCsv.getEmpata().equals("x")) {gol2=0; gol1=0;}
      			
   				Partido unoVsDos = new Partido(uno,dos,gol1,gol2);     
   				ResultadoPartido res=new ResultadoPartido(unoVsDos);
   				Pronostico p = new Pronostico(unoVsDos);
   
    			Persona unaPersona = new Persona(lineaPronosticosCsv.getParticipante());
      	    	Persona buscar=null;
    
      	    	buscar=mundial.buscarPersona(lineaPronosticosCsv.getParticipante(), unaPersona);      	    	
      	    	buscar.agregarPronostico(p);

// EL SIGUIENTE FOR TOMA UNA LISTA DE PERSONAS DE UN PRONOSTICO, A SU VEZ TOMA CADA PERSONA DE ESA LISTA
// Y A CADA PERSONA SE LE SOLICITA LA LISTA DE PARTIDOS QUE TIENE ESA PERSONA PARA MOSTRARLA EN PANTALLA
      	    	
      		}
      		for (Persona  persona: mundial.getPersonas()) {
		      		persona.mostrarPronostico(persona);
		      		}
      		    		} catch (IOException e) {
      		        							e.printStackTrace();
      											}
    	return tablaPronosticoCsv;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////// LEER ARCHIVO RESULTADOS.CSV ALMACENANDO LOS DATOS EN LAS INSTANCIAS DE LAS CLASES CORRRESPONDIENTES //////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   	//public static List leerResultadosCsv(String archivo) {
   		public static List leerResultadosCsv(String archivo,Torneo mundial) {
    	List <ResultadosCsvPorLinea> tablaResultadoCsv=null;
    	//Torneo mundial=new Torneo("mundial catar 2022");
    	System.out.println("\nLeyendo desde : "+archivo+"\n");
	try {		
		tablaResultadoCsv = new CsvToBeanBuilder(new FileReader(archivo))
                // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
              .withType(ResultadosCsvPorLinea.class)
              .build()
              .parse();
    	
    	System.out.printf("|%-20s|%-20s|%-7s|%-7s|%-20s|\n","RONDA","EQUIPO 1","GOLES 1","GOLES 2","EQUIPO 2");
    	  System.out.printf("|____________________|____________________|_______|_______|____________________|\n");
    	  Integer gol1,gol2;
      		for (ResultadosCsvPorLinea  lineaResultadosCsv: tablaResultadoCsv) {

      			Equipo uno=new Equipo(lineaResultadosCsv.getEquipo1(),"");
   				Equipo dos=new Equipo(lineaResultadosCsv.getEquipo2(),"");
   				gol1=Integer.parseInt(lineaResultadosCsv.getGoles1());
   				gol2=Integer.parseInt(lineaResultadosCsv.getGoles2());
      	    	Partido unoVsDos = new Partido(uno,dos,gol1,gol2);      	    	

      	    	Ronda unaRonda = new Ronda(lineaResultadosCsv.getRonda());
      	    	Ronda buscar=null;
      	    	
      	    	buscar=mundial.buscarRonda(lineaResultadosCsv.getRonda(), unaRonda);      	    	
      	    	buscar.agregarPartidos(unoVsDos);
      	    	      				} // CIERRA EL FOR

      		
// EL SIGUIENTE FOR TOMA UNA LISTA DE RONDAS DE UN TORNEO, A SU VEZ TOMA CADA RONDA DE ESA LISTA
// Y A CADA RONDA SE LE SOLICITA LA LISTA DE PARTIDOS QUE TIENE ESA RONDA PARA MOSTRARLA EN PANTALLA
      		for (Ronda  r: mundial.getRondas()) {

  	    	r.mostrarRonda(r);
      		}

    		} catch (IOException e) {
        							e.printStackTrace();
									}
    	return tablaResultadoCsv;
    }

    ///////////////////////////////////////////////////
    //////////       AGREGAR UNA RONDA      //////////
    //////////////////////////////////////////////////
    public static void agregarAUnaRonda(List <Ronda> rondas,Ronda unaRonda, Partido unPartido){
    	
    	unaRonda.setNro(null);
    	unaRonda.agregarPartidos(unPartido);

    	unaRonda.setNro(null);
    	unaRonda.agregarPartidos(unPartido);
    }
    
    

    /////////////////////////////////////////////////////
    ////////// VERIFICAR PARAMETROS DE ENTRADA //////////
    /////////////////////////////////////////////////////
    public static void verificarParametros(String[] args){
    	
        if(args.length == 0){
        	System.out.println(" ___________________________________________________________________________________");
            System.out.println("/ ERROR: No ingresaste ningún archivo como argumento!                               \\");
            System.out.println("\\___________________________________________________________________________________/");
        	}
        
        if(args.length == 1){
        	System.out.println(" ___________________________________________________________________________________");
        	System.out.println("/ ERROR: Cantidad de parametros insuficientes!                                      \\");
            System.out.println("\\___________________________________________________________________________________/");
        	}
        
        if(args.length < 2){
            System.out.println(" _________________________________________________________________________________________");            
            System.out.println("/ RECUERDA que debes ingresar 2 archivos de entrada como parametro.                       \\");
            System.out.println("\\ DEBES INGRESAR - PARAMETRO 1 - : la ruta y el nombre de un archivo \"pronostico.csv\"     /");
            System.out.println("/ DEBES INGRESAR - PARAMETRO 2 - : la ruta y el nombre de un archivo de \"resultados.csv\"  \\");
            System.out.println("\\_________________________________________________________________________________________/");
            System.exit(88);
        	}
    }
    
}
