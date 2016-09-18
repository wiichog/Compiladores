import java.util.*;
public class SimulacionAFN{
	
	public AFN ECerraduraEstado(AFN afn){
		ArrayList<Transicion> Transiciones = afn.GetCaminos();
		
		Stack st = new Stack();
		for(int i=0;i<Transiciones.size();i++){
			Transicion Camino = Transiciones.get(i);
			int EstadoInicial = Camino.GetEstadoInicial();
			int EstadoFinal = Camino.GetEstadoFinal();
			System.out.println("****************");
			for(int j=0;j<Transiciones.size();j++){
				Transicion Caminos = Transiciones.get(j);
				if((Caminos.GetEstadoInicial()==EstadoFinal || Caminos.GetEstadoInicial()==EstadoInicial) && (Caminos.GetSimbolo().equals("«"))){
					System.out.println("EstadoFinal   " + Caminos.GetEstadoFinal());
					System.out.println("Simbolo  " + Caminos.GetSimbolo());
					st.push(Caminos);
				}

			}
		
				
			}
			return null;
		}
	}
	
