import java.util.*;
import java.io.*;
public class AFNtoAFD{
		
		SimulacionAFN Simulacion = new SimulacionAFN();
		ArrayList<ArrayList<Integer>> EstadosAFD = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> ArrayMover= new ArrayList<Integer>();
		ArrayList<Integer> ArrayEclousure= new ArrayList<Integer>();
		ArrayList<TransicionAFD> EstadosFinalesAFD= new ArrayList<TransicionAFD>();
		public String z = "";
		AFD afd = new AFD();
		
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
						if(i==0){
							afd.SetInicio(ArrayEclousure);
						}
						else if(i==Alfabeto.size()){
							afd.SetFinal(ArrayEclousure);
						}
						ArrayList<Integer> Prueba55 = new ArrayList<Integer>();
						Prueba55.addAll(ArrayEclousure);
						
						TransicionAFD Transicion = new TransicionAFD();
						Transicion.SetInicio(Estado);
						System.out.println("************ ESTADO DE INICIO ************");
						for(int t=0;t<Estado.size();t++){System.out.println(Estado.get(t));}
						System.out.println("******************************************");
						System.out.println("Simbolo de Transicion " + z);
						Transicion.SetFinal(Prueba55);
						Transicion.SetSimbolo(z);
						afd.SetArray(Transicion);
						System.out.println("************ ESTADO DE FINAL ************");
						for(int t=0;t<Prueba55.size();t++){System.out.println(Prueba55.get(t));}
						System.out.println("******************************************");
						
						EstadosAFD.add(Prueba55);
						ArrayEclousure.clear();
						ArrayMover.clear();
				}	
				return EstadosAFD;
			}
			
			}