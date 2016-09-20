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
		String ExpresionRegular =("a");
        String Postfix = post.infixToPostfix(ExpresionRegular);
		System.out.println(Postfix);
		
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
			
			AFN afn = (AFN) st.pop();
			ArrayList<Transicion> DTRAN = afn.GetCaminos();
			for(int i=0;i<DTRAN.size();i++){
				Transicion Numero = DTRAN.get(i);
				int EstadoInicial = Numero.GetEstadoInicial();
				int EstadoFinal = Numero.GetEstadoFinal();
				if(!(DTRAN.contains(EstadoInicial)) || !(DTRAN.contains(EstadoFinal))){
					EstadosAFN.add(EstadoInicial);
				}
			}
			
			S0.addAll(Simulacion.ECerraduraEstado(afn,afn.GetEstadoInicial(),afn.GetEstadoInicial(),0));
			AFD.add(S0);
			Simulacion.Estados.clear();
			String Cadena = ("a");
			Cadena = Cadena + "%"; //EOF va a ser %
			for(int i=0;i<Cadena.length();i++){
				String c = Character.toString(Cadena.charAt(i));
				if(!(c.equals("%"))){
					if(!Alfabeto.contains(c)){Alfabeto.add(c);}
					Mover.addAll(Simulacion.Mover(afn,S0,c));
				}
				Simulacion.Estados.clear();
				Simulacion.DesmarcarAFN(afn);
				for(int j=0;j<Mover.size();j++){
					if(!(c.equals("%"))){
						Simulacion.Estados.clear();
						S0 = Simulacion.ECerraduraEstado(afn,Mover.get(j),Mover.get(j),0);
					}
				}
			}		
			System.out.println("RESULTADO DE LA SIMULACION "+Simulacion.Interseccion(S0,EstadosAFN));
			AFNAFD.ThompsonToAFD(afn,Alfabeto,AFD);
			
			
			}


}
