package org.curso_de_java.tpEntrega3;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import modelo.ResultadosCsvPorLinea;
import modelo.PronosticosCsvPorLinea;
import modelo.ResultadoPartido;
import modelo.Configuracion;
import modelo.Equipo;
import modelo.Persona;
import modelo.Pronostico;
import modelo.Partido;
import modelo.Ronda;
import modelo.Torneo;

import modelo.Pronostico;

public class App 
{
	static int puntosASumar=1;
	static int puntosExtra=0;

	public static void main( String[] args )
    {
    	verificarParametros(args);
    	Torneo mundial=new Torneo("mundial catar 2022");
    	
    	List <Persona> personas;
    	List <ResultadosCsvPorLinea> tablaResultadoCsv;
    	List <PronosticosCsvPorLinea> tablaPronosticoCsv;
    	
    	tablaPronosticoCsv=leerPronosticoDesdeTabla(mundial);
    	//tablaPronosticoCsv=leerPronosticoCsv(args[0],mundial);
    	
    	tablaResultadoCsv=leerResultadosCsv(args[1],mundial);
    	calcularPuntajes(mundial);
        System.out.println("\n");   
    }
			
/////////////////////////////////////////////////////////////////////////
//////////// SEPARA EN DISTINTAS CLASES LAS LINEAS CSV LEIDAS //////////
///////////////////////////////////////////////////////////////////////
public static void cadaLineaCsvEnUnaClase(List <PronosticosCsvPorLinea> tablaPronosticoCsv,Torneo mundial) {
int gol1=0,gol2=0;
Persona buscar;
for (PronosticosCsvPorLinea  lineaPronosticosCsv: tablaPronosticoCsv) {
	//Persona persona1=new Persona(lineaPronosticosCsv.getParticipante());      			

	Equipo uno=new Equipo(lineaPronosticosCsv.getEquipo1(),"");
	Equipo dos=new Equipo(lineaPronosticosCsv.getEquipo2(),"");      			

	if (lineaPronosticosCsv.getGana1().equals("x")) {gol1=1; gol2=0;}
	if (lineaPronosticosCsv.getGana2().equals("x")) {gol2=1; gol1=0;}
	if (lineaPronosticosCsv.getEmpata().equals("x")) {gol2=0; gol1=0;}

	Partido unoVsDos = new Partido(uno,dos,gol1,gol2);     
	ResultadoPartido res=new ResultadoPartido(unoVsDos);
	Pronostico p = new Pronostico(unoVsDos);

	Persona unaPersona = new Persona(lineaPronosticosCsv.getParticipante());
	buscar=null;

	buscar=mundial.buscarPersona(lineaPronosticosCsv.getParticipante(), unaPersona);      	    	
	buscar.agregarPronostico(p);
}
}	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////LEER ARCHIVO PRONOSTICOS.CSV ALMACENANDO LOS DATOS EN LAS INSTANCIAS DE LAS CLASES CORRRESPONDIENTES //////////
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

pantallaPronostico();
cadaLineaCsvEnUnaClase(tablaPronosticoCsv,mundial);

//EL SIGUIENTE FOR TOMA UNA LISTA DE PERSONAS DE UN PRONOSTICO, A SU VEZ TOMA CADA PERSONA DE ESA LISTA
//Y A CADA PERSONA SE LE SOLICITA LA LISTA DE PARTIDOS QUE TIENE ESA PERSONA PARA MOSTRARLA EN PANTALLA
for (Persona  persona: mundial.getPersonas()) {
persona.mostrarPronostico(persona);
}
} catch (IOException e) {
e.printStackTrace();
}
return tablaPronosticoCsv;
}


/////////////////////////////////////////////////////////////////////////////
//////////// LEER LOS PRONOSTICOS DE LAS PERSONAS DESDE UNA TABLA //////////
///////////////////////////////////////////////////////////////////////////
public static List leerPronosticoDesdeTabla(Torneo mundial) {
List <PronosticosCsvPorLinea> tablaPronosticoCsv=null;
String archivo="src\\main\\resources\\configuracion.txt";

Configuracion configuracion=new Configuracion(archivo);


pantallaPronostico();

try {
//registrar el driver
Class.forName(configuracion.getDriver());

//crear el objeto de conexion
Connection con = DriverManager.getConnection(configuracion.getUrl(),configuracion.getUsuario(),configuracion.getContraseña());

//crear la sentencia
Statement stmt = con.createStatement();

//ejecutamos y obtenemos los resultados de la sentencia
ResultSet rs = stmt.executeQuery("SELECT * FROM partido");

puntosASumar=configuracion.getPuntosASumar();
puntosExtra=configuracion.getPuntosExtra();

// recorrer el resultado que me devolvio
int gol1=0,gol2=0;

while (rs.next())
{	
//Persona persona1=new Persona(rs.getString(1));
Equipo uno=new Equipo(rs.getString(2),"");
Equipo dos=new Equipo(rs.getString(6),"");      			

if (rs.getString(3).equals("x")) {gol1=1; gol2=0;}
if (rs.getString(4).equals("x")) {gol1=0; gol2=0;}
if (rs.getString(5).equals("x")) {gol1=0; gol2=1;}

Partido unoVsDos = new Partido(uno,dos,gol1,gol2);     
ResultadoPartido res=new ResultadoPartido(unoVsDos);
Pronostico p = new Pronostico(unoVsDos);

mundial.buscarPersona2(rs.getString(1),p);
}
// cerrar la conexion
con.close();	

for (Persona  persona: mundial.getPersonas()) {
	persona.mostrarPronostico(persona);
}


System.out.println("\n__________    DATOS DE ARCHIVO DE CONFIGURACION   __________");
System.out.println("____________________________________________________________");
System.out.println("Puntos a sumar por cada coincidencia de pronostico : "+puntosASumar);
System.out.println("Puntos extra a sumar por acertar una ronda completa : "+puntosExtra);
System.out.println("____________________________________________________________");

} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
}
return tablaPronosticoCsv;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////COMPARA EL RESULTADO DE UN PRONOSTICO CON EL RESULTADO DE UN PARTIDO REAL DE LA RONDA //////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////
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

//en los siguientes "if" no hace falta el else porque cada uno tiene un return		
//if (pronosticaba que el equipo1 ganaba el partido) and 
//(realmente el equipo1 ganó el partido) retorna un punto
	
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
/////////// BUSCA EL PARTIDO EN TODA LA RONDA DE PARTIDOS REALES Y LO ENVIA A   //////////
//////////           COMPARAR SU RESULTADO CON EL RESULTADO DEL PRONOSTICO     //////////
////////////////////////////////////////////////////////////////////////////////////////
public static int partidoRonda(Pronostico pro,Ronda ron) {
	String nombre1pro=pro.getPartido().getEquipo1().getNombre();
	String nombre2pro=pro.getPartido().getEquipo2().getNombre();
	String nombre1par,nombre2par;
	for(Partido par:ron.getPartidos()) {				
		nombre1par=par.getEquipo1().getNombre();
		nombre2par=par.getEquipo2().getNombre();
		if ((nombre1pro.equals(nombre1par)) && (nombre2pro.equals(nombre2par))){	
			System.out.println();
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
	String nombre1pro,nombre1par,nombre2pro,nombre2par,auxiliar;
	int puntaje=0,resultado;
	boolean sumar;
	for(Ronda ron:rondas) {
		sumar=true;	
		for (Pronostico  pro: pronosticos) {
			nombre1pro=pro.getPartido().getEquipo1().getNombre();
			nombre2pro=pro.getPartido().getEquipo2().getNombre();
			resultado=0;
			
// aca mando a buscar un partido en toda la ronda y me trae el resultado //
					resultado=partidoRonda(pro,ron);
					if ((resultado==0) && (sumar)) {
						sumar=!sumar;
System.out.println("No suma puntos extra porque no acerto este partido de la ronda --> "+nombre1pro+" "+nombre2pro);
					}
					//puntaje=puntaje+partidoRonda(pro,ron);
					puntaje=puntaje+resultado;
					if (!sumar) System.out.println();
				}		

		if (sumar) {
			puntaje=puntaje+puntosExtra;			
			System.out.println("_________________________________________________________");
			auxiliar=" extra!!!!";
			if (puntosExtra>1) auxiliar="s extra!!!!"; 
			System.out.println("Acertó toda la Ronda asi que suma "+puntosExtra+" punto"+auxiliar);
			System.out.println("_________________________________________________________\n");
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
	
////////////////////////////////////////////////////////////////////////////////////////////
////////// COMPRUEBA EL CONTENIDO DE CADA LINEA LEIDA DEL ARCHIVO RESULTADOS.CSV //////////
//////////////////////////////////////////////////////////////////////////////////////////
public static boolean compruebaLineaResultados(ResultadosCsvPorLinea lineaResultadosCsv){
String auxiliar;
String expresionRegular="[0-9]";
int campos=0;

//comprueba que la ronda sea un numero mediante expresiones regulares
auxiliar=lineaResultadosCsv.getRonda();
if (!auxiliar.matches(expresionRegular)) return false;
campos++;

//comprueba que el nombre del equipo1 no este vacio
if (lineaResultadosCsv.getEquipo1()=="") return false;
campos++;

//comprueba que el nombre del equipo2 no este vacio
if (lineaResultadosCsv.getEquipo2()=="") return false;
campos++;

//comprueba mediante expresiones regulares que la cantidad de goles del equipo 1 sea un numero
auxiliar=lineaResultadosCsv.getGoles1();
if (!auxiliar.matches(expresionRegular)) return false;
campos++;

//comprueba mediante expresiones regulares que la cantidad de goles del equipo 2 sea un numero
auxiliar=lineaResultadosCsv.getGoles2();
if (!auxiliar.matches(expresionRegular)) return false;
campos++;

//comprueba que el numero de campos sea correcto
if (campos<5) return false;

return true;	
}

//////////////////////////////////////////////////////////////////////////////////////////////////////
////////// ALMACENA EL CONTENIDO DEL ARCHIVO RESULTADOS.CSV EN LAS CLASES CORRESPONDIENTES //////////
////////////////////////////////////////////////////////////////////////////////////////////////////
public static void compruebaYClasificaResultados(List <ResultadosCsvPorLinea> tablaResultadoCsv,Torneo mundial) {
System.out.printf("|%-20s|%-20s|%-7s|%-7s|%-20s|\n","RONDA","EQUIPO 1","GOLES 1","GOLES 2","EQUIPO 2");
System.out.printf("|____________________|____________________|_______|_______|____________________|\n");
Integer gol1,gol2,ronda;
for (ResultadosCsvPorLinea  lineaResultadosCsv: tablaResultadoCsv) { 
	
if (compruebaLineaResultados(lineaResultadosCsv)) {
	
Equipo uno=new Equipo(lineaResultadosCsv.getEquipo1(),"");
Equipo dos=new Equipo(lineaResultadosCsv.getEquipo2(),"");
gol1=Integer.parseInt(lineaResultadosCsv.getGoles1());
gol2=Integer.parseInt(lineaResultadosCsv.getGoles2());
Partido unoVsDos = new Partido(uno,dos,gol1,gol2);      	    	

ronda=Integer.parseInt(lineaResultadosCsv.getRonda());
Ronda unaRonda = new Ronda(ronda);
Ronda buscar=null;

buscar=mundial.buscarRonda(ronda, unaRonda);      	    	
buscar.agregarPartidos(unoVsDos);
}
} // CIERRA EL FOR
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////// LEER ARCHIVO RESULTADOS.CSV ALMACENANDO LOS DATOS EN LAS INSTANCIAS DE LAS CLASES CORRRESPONDIENTES //////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static List leerResultadosCsv(String archivo,Torneo mundial) {
List <ResultadosCsvPorLinea> tablaResultadoCsv=null;
System.out.println("\nLeyendo desde : "+archivo+"\n");
try {		
	tablaResultadoCsv = new CsvToBeanBuilder(new FileReader(archivo))
              .withType(ResultadosCsvPorLinea.class)
              .build()
              .parse();

compruebaYClasificaResultados(tablaResultadoCsv,mundial);
	
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

////////////////////////////////////////////////////////////////////////////////////
//////////// PRESENTACION EN PANTALLA DE LOS PRONOSTICOS DE LAS PERSONAS //////////
//////////////////////////////////////////////////////////////////////////////////
public static void pantallaPronostico() {	
System.out.println("\nLEYENDO PRONOSTICOS DESDE LA TABLA");
System.out.printf("|%-20s|%-20s|%-6s|%-6s|%-6s|%-20s|\n","PARTICIPANTE","EQUIPO 1","GANA 1","EMPATA","GANA 2","EQUIPO 2");
System.out.printf("|____________________|____________________|______|______|______|____________________|\n");
}

    
}
