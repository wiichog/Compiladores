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
        String ExpresionRegular =("(ab)(b|b)*");
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

			AFN prueba5 = (AFN) st.pop();
			System.out.println("NodoInicial " + prueba5.GetEstadoInicial());
			System.out.println("NodoFinal " + prueba5.GetEstadoFinal());
			ArrayList<Transicion> Caminosa = prueba5.GetCaminos();//en este array vamos a guardar todos los caminos del primer caracter para el or
			
			for(int j=0; j<Caminosa.size(); j++){
				Transicion prueba2 = Caminosa.get(j);
				System.out.println("");
				System.out.println("CaminoInicio " + prueba2.GetEstadoInicial());
				System.out.println("CaminoFinal " + prueba2.GetEstadoFinal());
				System.out.println("Simbolo " + prueba2.GetSimbolo());
				System.out.println("");
			
				
				
		}	
		
}}
