import java.util.*;
public class SimulacionAFN{
	
	public ArrayList<Integer> Estados = new ArrayList<Integer>();
	
	public ArrayList<Integer> ECerraduraEstado(AFN afn, int Estado,int PrimerEstado){
		ArrayList<Transicion> Recorridos = afn.GetCaminos();
		for(int j=0;j<Recorridos.size();j++){
			Transicion Recorriendo = Recorridos.get(j);
			System.out.println("Estado Inicial" + Recorriendo.GetEstadoInicial());
			System.out.println("Estado Final" + Recorriendo.GetEstadoFinal());
			System.out.println("Estado" + Estado);
			System.out.println("");
			if(Recorriendo.GetEstadoInicial()==Estado && Recorriendo.GetSimbolo().equals("«") && Recorriendo.GetMarcado()==false){
				System.out.println("Entro a la primera y metio " + Recorriendo.GetEstadoFinal() + " con simbolo " + Recorriendo.GetSimbolo());
					Recorriendo.SetMarcado(true);
					Estados.add(Recorriendo.GetEstadoFinal());
					ECerraduraEstado(afn,Recorriendo.GetEstadoFinal(),PrimerEstado);
					return Estados;
				}
			if(Recorriendo.GetEstadoInicial()==Estado && !(Recorriendo.GetSimbolo().equals("«"))){
					Estado = Recorriendo.GetEstadoInicial();
					System.out.println("Entro a la segunda y va mandar" + PrimerEstado);
					ECerraduraEstado(afn,PrimerEstado,PrimerEstado);
					return Estados;
			}
			//Recorridos.remove(j);
			}
		return null;}
	}