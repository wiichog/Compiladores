import java.util.*;

public class main2{

public static void main(String args[]){
		ArrayList<Integer> estados = new ArrayList<Integer>();
		ArrayList<Integer> estados1 = new ArrayList<Integer>();
		ArrayList<Integer> estados2 = new ArrayList<Integer>();
		ArrayList<Integer> estados3 = new ArrayList<Integer>();
		ArrayList<Integer> estados4 = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> estadosFinales = new ArrayList<ArrayList<Integer>>();
		estados.add(2);
		estados1.add(3);
		estados2.add(1);
		estados3.add(7);
		estados4.add(9);
		estadosFinales.add(estados);
		estadosFinales.add(estados1);
		estadosFinales.add(estados2);
		estadosFinales.add(estados3);
		estadosFinales.add(estados4);
		
		 for (ArrayList<Integer> i: estadosFinales) {
			 System.out.println("Hola aqui estoy");
		 }
		 
		 
}

}