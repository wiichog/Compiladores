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
			ArrayList<Integer> S1 = new ArrayList<Integer>();
			ArrayList<Integer> S = new ArrayList<Integer>();
			//PARA VOLVER A UTILIZAR ECLOUSURE SIEMPRE LE TENEMOS QUE DESMARCAR EL ARBOL Y LIMPIAR ESTADOS
			//Simulacion.Estados.clear();
			//Simulacion.DesmarcarAFN(afn);
			//for(int t=0;t<Aarray.size();t++){System.out.println();}
						Simulacion.Estados.clear();
						Simulacion.DesmarcarAFN(afn);
						Simulacion.Mover.clear();
			S0 = Simulacion.ECerraduraEstado(afn,afn.GetEstadoInicial(),afn.GetEstadoInicial(),0);
			String c = "abb";
			c = c + "%";
			//*******Algoritmo Pagina 156 Libro de Dragon
			for(int i=0; i<c.length();i++)
			{
				String z = Character.toString(c.charAt(i));
				
				if(!z.equals("%")){
					S.addAll(Simulacion.Mover(afn,S0,z));//Aqui tenemos mover del estado inicial
					for(int j=0;j<S.size();j++){
						Simulacion.Estados.clear();//vaciamos los arraylist
						Simulacion.DesmarcarAFN(afn);//para poder recorrer el arbol
						Simulacion.Mover.clear();//vaciamos arraylist
						S1.addAll(Simulacion.ECerraduraEstado(afn,S.get(j),S.get(j),0));//hacemos eclousure de mover y lo agregamos a un vector
				S0.clear();
				S0.addAll(S1);
				S1.clear();
				S.clear();
				}
				if(S0.contains(afn.GetEstadoFinal())){System.out.println("Si");}
				else{System.out.println("No");}	
			}			
			}
			//**************CONVERSION DE AFN A AFD
			for(int g=0;g<CaminosAFN.size();g++){
				Transicion Letra = CaminosAFN.get(g);
				if(!(Alfabeto.contains(Letra.GetSimbolo())) && !(Letra.GetSimbolo().equals("«")))
				{
					Alfabeto.add(Letra.GetSimbolo());
				}
			}
						ArrayList<Integer> Prueba = new ArrayList<Integer>();
						Simulacion.Estados.clear();//vaciamos los arraylist
						Simulacion.DesmarcarAFN(afn);//para poder recorrer el arbol
						Simulacion.Mover.clear();//vaciamos arraylist
						Prueba.addAll(Simulacion.ECerraduraEstado(afn,afn.GetEstadoInicial(),afn.GetEstadoInicial(),0));//hacemos eclousure de mover y lo agregamos a un vector
						//for(int t=0;t<Prueba.size();t++){System.out.println(Prueba.get(t));}
			AFNtoAFD Conversion = new AFNtoAFD();
			Stack<ArrayList<Integer>> AFDTransitorio = new Stack<ArrayList<Integer>>();
			AFDTransitorio.push(Prueba);
			ArrayList<ArrayList<Integer>> EstadosAFDTransitorios = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> EstadosFinalesAFD = new ArrayList<ArrayList<Integer>>();
			
			
			
			while(!(AFDTransitorio.isEmpty())){
			EstadosAFDTransitorios.addAll(Conversion.ThompsonToAFD(afn,Alfabeto,AFDTransitorio.pop(),0));
			for(int m=0;m<EstadosAFDTransitorios.size();m++){
					ArrayList<Integer> Sistema = EstadosAFDTransitorios.get(m);
					if(!(EstadosFinalesAFD.contains(Sistema))){
						EstadosFinalesAFD.add(Sistema);
						AFDTransitorio.push(Sistema);
					}
			}}
	//*************************SIMULACION AFD
	ArrayList<TransicionAFD> Caminos= new ArrayList<TransicionAFD>();
	for(int i=0; i<Caminos.size();i++){
		TransicionAFD Transicion = new TransicionAFD();
	}
	for(int i=0; i<c.length();i++){
		String z = Character.toString(c.charAt(i));
		
	}
}
}