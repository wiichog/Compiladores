import java.util.*;
public class AFNtoAFD{
		
		SimulacionAFN Simulacion = new SimulacionAFN();
		ArrayList<ArrayList<Integer>> EstadosAFD = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> ArrayMover= new ArrayList<Integer>();
		ArrayList<Integer> ArrayEclousure= new ArrayList<Integer>();
		ArrayList<TransicionAFD> EstadosFinalesAFD= new ArrayList<TransicionAFD>();
		public String z = "";
		
		public ArrayList<TransicionAFD> ThompsonToAFD(AFN afn,ArrayList<String> Alfabeto,ArrayList<Integer> Estado,int Identificador){
			if(Identificador==0){
				EstadosAFD.add(Estado);}
			for(int i=0; i<Alfabeto.size();i++){
						z = Alfabeto.get(i);
						System.out.println("LA LETRA ES " +z);
						//primero tenemos que hacer mover
								Simulacion.Estados.clear();//vaciamos los arraylist
								Simulacion.DesmarcarAFN(afn);//para poder recorrer el arbol
								Simulacion.Mover.clear();//vaciamos arraylist
						ArrayMover.addAll(Simulacion.Mover(afn,Estado,z));//Aqui tenemos mover
						for(int k=0;k<ArrayMover.size();k++){//vamos a recorrer mover para enviarlo a eclousure
								int Numero = ArrayMover.get(i);
								Simulacion.Estados.clear();//vaciamos los arraylist
								Simulacion.DesmarcarAFN(afn);//para poder recorrer el arbol
								Simulacion.Mover.clear();//vaciamos arraylist
								ArrayEclousure.addAll(Simulacion.ECerraduraEstado(afn,ArrayMover.get(k),ArrayMover.get(k),0));//hacemos eclousure de mover y lo agregamos a un vector
						}
						System.out.println("********************");
						for(int t=0;t<ArrayEclousure.size();t++){System.out.println("Numero en ArrayEclousure "+ArrayEclousure.get(t));}
						System.out.println("********************");
				if(!(EstadosAFD.contains(ArrayEclousure)) && (ArrayEclousure.size()!=0)){
					EstadosAFD.add(ArrayEclousure);
					TransicionAFD Transicion = new TransicionAFD();
					Transicion.SetInicio(Estado);
					Transicion.SetFinal(ArrayEclousure);
					Transicion.SetSimbolo(z);
					EstadosFinalesAFD.add(Transicion);
					ArrayMover.clear();
					Estado.clear();
					Estado.addAll(ArrayEclousure);
					ArrayEclousure.clear();
					}	
				}
			
			
						
				return EstadosFinalesAFD;
			}
			
			}
			