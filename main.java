/*
    Proyecto 1 Compiladores 1
    Agosto 2016
*/

import java.util.*;

public class main{

    public static void main(String args[]){
        //Objetos
        Scanner teclado = new Scanner (System.in);
        //Variables
            Boolean bandera = true;
        //Pedir numeros al usuario
        System.out.println("|Ingrese la expresion Regular|");
		postfix converter = new postfix();
        String ExpresionRegular =(teclado.nextLine());
		String postfix = converter.convertToPostfix(ExpresionRegular); //de aqui obtenemos nuestra cadena ya en postfix
		
        System.out.println("|Ingrese la cadena|");
        String Cadena =(teclado.nextLine());
		
		
}}

