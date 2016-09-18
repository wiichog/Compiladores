import java.util.*;
public class SimulacionAFN{
	
	public AFN ECerraduraEstado(AFN afn){
		ArrayList<Transicion> Transiciones = afn.GetCaminos();
		ArrayList<Integer> CaminosFinales = new ArrayList<Integer>();
		Stack st = new Stack();
		for(int i=0;i<Transiciones.size();i++){
			Transicion Camino = Transiciones.get(i);
			int EstadoInicial = Camino.GetEstadoInicial();
			//System.out.println("EstadoInicial " +EstadoInicial);	
			int EstadoFinal = Camino.GetEstadoFinal();
			//recorremos el array para encontrar todos los finales
			//vaciamos antes la lista 
			CaminosFinales.clear();
			for(int j=0;j<Transiciones.size();j++){
				Transicion Caminos = Transiciones.get(j);
				if ((Caminos.GetEstadoInicial()==EstadoInicial) && (Caminos.GetSimbolo().equals("«"))){
					System.out.println("EstadoFinales" + Caminos.GetEstadoFinal());
					CaminosFinales.add(Caminos.GetEstadoFinal());
				}
			}
			Transiciones.remove(i);
			}
			return null;
		}
	}