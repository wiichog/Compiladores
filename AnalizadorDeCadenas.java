import java.io.*;
import java.util.*;
public class AnalizadorDeCadenas {
  public static void main(String[] args)  {
	ArrayList TokensNames = new ArrayList();
	ArrayList<Transicion> CaminosAFN = new ArrayList<Transicion>();
	Map<String, AFN> Automatas = new HashMap<String, AFN>();
	String cadena = "";
	String Nombre = "";
	int EstadoInicial = 0;
	int EstadoFinal = 0;
	try{
	BufferedReader b = new BufferedReader(new FileReader(new File("Lenguaje.txt")));
	while((cadena = b.readLine())!=null) {
		if(!(cadena.contains("ƒ"))){
			String[] Nombres = cadena.split("æ");
			Nombre = Nombres[0];
			TokensNames.add(Nombre);
			EstadoInicial=Integer.valueOf(Nombres[1]);
			EstadoFinal=Integer.valueOf(Nombres[2]);
			AFN afn = new AFN();
			afn.SetEstadoInicial(EstadoInicial);
			afn.SetEstadoFinal(EstadoFinal);
			for(int i=0;i<CaminosAFN.size();i++){
				afn.SetArray(CaminosAFN.get(i));
			}
			Automatas.put(Nombre,afn);
			CaminosAFN.clear();
		}
		else{
			String[] Transicion = cadena.split("ƒ");
			Transicion camino = new Transicion();
			camino.SetEstadoInicial(Integer.valueOf(Transicion[0]));
			camino.SetEstadoFinal(Integer.valueOf(Transicion[2]));
			camino.SetSimbolo(Transicion[1]);
			CaminosAFN.add(camino);
		}
	}
	}catch(Exception e){}	
	try{
		String linea = "";
		BufferedReader b = new BufferedReader(new FileReader(new File("Archivo2.txt")));
		while((linea = b.readLine())!=null) {
			for(int i=0;i<TokensNames.size();i++){
				AFN afn =Automatas.get(TokensNames.get(i));
				SimulacionAFN Simulacion = new SimulacionAFN();
				System.out.println("**************************");
				System.out.println("Para "+linea+ " el resultado de "+ TokensNames.get(i) +" es "+Simulacion.SimulacionFinal(afn,linea));
				System.out.println("**************************");
			}			
			}
		}
		catch(Exception e){}	
}}