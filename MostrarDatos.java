import java.util.*;

public class MostrarDatos{
	
	public void MostrarAFN(AFN afn){
			ArrayList<Transicion> CaminosAFN = afn.GetCaminos();
			for(int t=0;t<CaminosAFN.size();t++){
				Transicion Camino = CaminosAFN.get(t);
				System.out.println("Estado Inicial "+Camino.GetEstadoInicial());
				System.out.println("Estado Final "+Camino.GetEstadoFinal());
				System.out.println("Simbolo "+Camino.GetSimbolo());
			}
		
	}
	
	public void MostrarArrayList(ArrayList a,String Mensaje){
			for(int i=0; i<a.size();i++){
				System.out.println(Mensaje + a.get(i));
			}
		
	}

}