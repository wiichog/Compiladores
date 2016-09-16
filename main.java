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
        String ExpresionRegular =("ab|");
		for (int i=0; i<ExpresionRegular.length(); i++) { 
			char posicion = ExpresionRegular.charAt(i); 
			String Simbolo = Character.toString(posicion);
			if (Character.isLetter(posicion)){
				//AFN.Construccion(1,i,Simbolo,null,null);
				st.push(new Thompson(1,i,Simbolo,null,null));
			}
			else if(Simbolo.equals("|")){
				Thompson b = (Thompson) st.pop();
				Thompson a = (Thompson) st.pop();
				System.out.println(b.GetEstadoInicial());
				System.out.println(b.GetEstadoFinal());
				System.out.println(a.GetEstadoInicial());
				System.out.println(b.GetEstadoFinal());
				st.push(new Thompson(2,i,Simbolo,a,b));
			}
			else if(Simbolo.equals("^")){
				Thompson b = (Thompson) st.pop();
				Thompson a = (Thompson) st.pop();
				st.push(new Thompson(3,i,Simbolo,a,b));
			}
			else if(Simbolo.equals("*")){
				Thompson a = (Thompson) st.pop();
				st.push(new Thompson(4,i,Simbolo,a,null));
			}
		}	
		
}}
