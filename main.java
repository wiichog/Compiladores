/*
    Proyecto 1 Compiladores 1
    Agosto 2016
*/

import java.util.*;

public class main{

    public static void main(String args[]){
        //Objetos
        Scanner teclado = new Scanner (System.in);
		Stack st = new Stack();
		Thompson AFN = new Thompson();
		Postfix post = new Postfix();
		ArrayList<Integer> S0 = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> AFD = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<String> Alfabeto = new ArrayList<String>();
		ArrayList<Integer> Mover = new ArrayList<Integer>();
		ArrayList<Integer> EstadosAFN = new ArrayList<Integer>();
		SimulacionAFN Simulacion = new SimulacionAFN();
		AFNtoAFD AFNAFD = new AFNtoAFD();
	//YA NOS MAS OBJETOS!
		String ExpresionRegular =("(a|b)*abb");
        String Postfix = post.infixToPostfix(ExpresionRegular);
		int contador = 0;
		for (int i=0; i<Postfix.length(); i++) { 
			char posicion = Postfix.charAt(i); 
			String Simbolo = Character.toString(posicion);
			if (Character.isLetter(posicion)){
				st.push(AFN.Construccion(1,Simbolo,null,null));
			}
			else if(Simbolo.equals("|")){
				AFN b = (AFN) st.pop();
				AFN a = (AFN) st.pop();
				st.push(AFN.Construccion(2,Simbolo,a,b));	
			}
			else if(Simbolo.equals(".")){
				AFN b = (AFN) st.pop();
				AFN a = (AFN) st.pop();
				st.push(AFN.Construccion(3,Simbolo,a,b));
			}
			else if(Simbolo.equals("*")){
				AFN a = (AFN) st.pop();
				st.push(AFN.Construccion(4,Simbolo,a,null));
			}
			}
			//***********************************SIMULACION DE AFN******************************
			AFN afn = (AFN) st.pop();
			ArrayList<Transicion> CaminosAFN = afn.GetCaminos();
			ArrayList<Integer> Prueba = new ArrayList<Integer>();
			ArrayList<Integer> S1 = new ArrayList<Integer>();
			ArrayList<Integer> S = new ArrayList<Integer>();
			//PARA VOLVER A UTILIZAR ECLOUSURE SIEMPRE LE TENEMOS QUE DESMARCAR EL ARBOL Y LIMPIAR ESTADOS
			//Simulacion.Estados.clear();
			//Simulacion.DesmarcarAFN(afn);
			//for(int t=0;t<Aarray.size();t++){}
						Simulacion.Estados.clear();
						Simulacion.DesmarcarAFN(afn);
						Simulacion.Mover.clear();
			S0 = Simulacion.ECerraduraEstado(afn,afn.GetEstadoInicial(),afn.GetEstadoInicial(),0);
			String c = "aaabba";
			c = c + "%";
			//*******Algoritmo Pagina 156 Libro de Dragon
			for(int i=0; i<c.length();i++)
			{
				String z = Character.toString(c.charAt(i));
				
				if(!z.equals("%")){
					System.out.println("El simbolo es "+ z);
					S.addAll(Simulacion.Mover(afn,S0,z));//Aqui tenemos
					for(int t=0;t<S.size();t++){System.out.println("Numero en S (Mover) "+S.get(t));}
					for(int j=0;j<S.size();j++){
						Simulacion.Estados.clear();
						Simulacion.DesmarcarAFN(afn);
						Simulacion.Mover.clear();
						S1.addAll(Simulacion.ECerraduraEstado(afn,S.get(j),S.get(j),0));
						}	
				S0.clear();
				S0.addAll(S1);
				for(int t=0;t<S0.size();t++){System.out.println("Numero en S0 "+S0.get(t));}
				S1.clear();
				S.clear();
				}
			}
			
			// for(int i=0;i<CaminosAFN.size();i++){
				// Transicion Numero = CaminosAFN.get(i);
				// int EstadoInicial = Numero.GetEstadoInicial();
				// int EstadoFinal = Numero.GetEstadoFinal();
				// if(!(CaminosAFN.contains(EstadoInicial)) || !(CaminosAFN.contains(EstadoFinal))){
					// EstadosAFN.add(EstadoInicial);
				// }
			// }
			// S0.addAll(Simulacion.ECerraduraEstado(CaminosAFN,afn.GetEstadoInicial(),afn.GetEstadoInicial(),0));
			// for(int h=0;h<S0.size();h++){System.out.println(S0.get(h));}
			// AFD.add(S0);
			// Simulacion.Estados.clear();
			// String Cadena = ("a");
			// Cadena = Cadena + "%"; //EOF va a ser %
			// for(int i=0;i<Cadena.length();i++){
				// String c = Character.toString(Cadena.charAt(i));
				// if(!(c.equals("%"))){
					// if(!Alfabeto.contains(c)){Alfabeto.add(c);}
					// Mover.addAll(Simulacion.Mover(afn,S0,c));
				// }
				// Simulacion.Estados.clear();
				// Simulacion.DesmarcarAFN(afn);
				// for(int j=0;j<Mover.size();j++){
					// if(!(c.equals("%"))){
						// Simulacion.Estados.clear();
						// S0 = Simulacion.ECerraduraEstado(afn,Mover.get(j),Mover.get(j),0);
					// }
				// }
			// }		
			// System.out.println("Holis");
			
			
			//System.out.println("RESULTADO DE LA SIMULACION "+Simulacion.Interseccion(S0,EstadosAFN));
			//AFNAFD.ThompsonToAFD(afn,Alfabeto,AFD);
			
			
			}


}
