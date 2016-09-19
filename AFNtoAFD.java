import java.util.*;
public class AFNtoAFD{
		
		SimulacionAFN Simulacion = new SimulacionAFN();
		ArrayList<ArrayList<Integer>> ComparacionEstados = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> EstadoDespuesDeMover = new ArrayList<Integer>();
		ArrayList<Integer> EstadosDespuesDeEclousure= new ArrayList<Integer>();
		
		public void ThompsonToAFD(AFN afn,ArrayList<String> Alfabeto,ArrayList<ArrayList<Integer>> EstadoInicial){
			ArrayList<Transicion> Caminos = afn.GetCaminos();
			for(int i=0;i<EstadoInicial.size();i++){
				ArrayList<Integer> Estado = new ArrayList<Integer>();
				Estado.addAll(EstadoInicial.get(i));
				for(int j=0;j<Alfabeto.size();j++){
					String Letra = Alfabeto.get(j);
						for(int k=0;k<Estado.size();k++){
							int Numero = Estado.get(k);
							if ((Simulacion.MoverLetra(afn,Numero,Letra)!=-1)){
								EstadoDespuesDeMover.add(Simulacion.MoverLetra(afn,Numero,Letra));}
						}
					}
						for(int r=0; r<EstadoDespuesDeMover.size();r++){
							int Numero = EstadoDespuesDeMover.get(r);
							EstadosDespuesDeEclousure.addAll(Simulacion.ECerraduraEstado(afn,Numero,Numero,0));
						}						
				
					if(!(ComparacionEstados.contains(EstadosDespuesDeEclousure))){
						ComparacionEstados.add(EstadosDespuesDeEclousure);
					}
					else{
						System.out.println("YA TENES TU AFD");
					}}
			}






}