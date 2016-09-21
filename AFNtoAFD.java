import java.util.*;
public class AFNtoAFD{
		
		SimulacionAFN Simulacion = new SimulacionAFN();
		ArrayList<ArrayList<Integer>> EstadosAFD = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> ArrayMover= new ArrayList<Integer>();
		ArrayList<Integer> ArrayEclousure= new ArrayList<Integer>();
		ArrayList<TransicionAFD> EstadosFinalesAFD= new ArrayList<TransicionAFD>();
		public String z = "";
		
		public ArrayList<ArrayList<Integer>> ThompsonToAFD(AFN afn,ArrayList<String> Alfabeto,ArrayList<Integer> Estado,int Identificador){
			for(int i=0; i<Alfabeto.size();i++){
						z = Alfabeto.get(i);
						//primero tenemos que hacer mover
								Simulacion.Estados.clear();//vaciamos los arraylist
								Simulacion.DesmarcarAFN(afn);//para poder recorrer el arbol
								Simulacion.Mover.clear();//vaciamos arraylist
						ArrayMover.addAll(Simulacion.Mover(afn,Estado,z));//Aqui tenemos mover
						for(int k=0;k<ArrayMover.size();k++){//vamos a recorrer mover para enviarlo a eclousure
								int Numero = ArrayMover.get(k);
								Simulacion.Estados.clear();//vaciamos los arraylist
								Simulacion.DesmarcarAFN(afn);//para poder recorrer el arbol
								Simulacion.Mover.clear();//vaciamos arraylist
								ArrayEclousure.addAll(Simulacion.ECerraduraEstado(afn,ArrayMover.get(k),ArrayMover.get(k),0));//hacemos eclousure de mover y lo agregamos a un vector
						}
						ArrayList<Integer> Prueba55 = new ArrayList<Integer>();
						Prueba55.addAll(ArrayEclousure);
						EstadosAFD.add(Prueba55);
						ArrayEclousure.clear();
						ArrayMover.clear();
				}	
				return EstadosAFD;
			}
			
			}
			