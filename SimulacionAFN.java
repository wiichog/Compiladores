import java.util.*;
import java.io.*;
public class SimulacionAFN{
	
	public ArrayList<Integer> Estados = new ArrayList<Integer>();
	public ArrayList<Integer> EstadosLetras = new ArrayList<Integer>();
	public int EstadoAnterior = 0;
	public Stack<Integer> EstadosAnteriores = new Stack<Integer>();
	public ArrayList<Integer> Mover = new ArrayList<Integer>();
	
	public ArrayList<Integer> ECerraduraEstado(AFN afn, int Estado,int PrimerEstado,int Identificador){
		ArrayList<Transicion> Recorridos = afn.GetCaminos();
		for(int j=0;j<Recorridos.size();j++){
			Transicion Recorriendo = Recorridos.get(j);
			if(Recorriendo.GetEstadoInicial()==Estado && Recorriendo.GetSimbolo().equals("«") && Recorriendo.GetMarcado()==false){
					Recorriendo.SetMarcado(true);
					if(Identificador==0){
					EstadosAnteriores.push(Recorriendo.GetEstadoInicial());
					}
					if(!(Estados.contains(PrimerEstado))){
						Estados.add(PrimerEstado);
					}
					Estados.add(Recorriendo.GetEstadoFinal());
					ECerraduraEstado(afn,Recorriendo.GetEstadoFinal(),PrimerEstado,0);
					Identificador=0;
					return Estados;
				}
			if(Recorriendo.GetEstadoInicial()==Estado && !(Recorriendo.GetSimbolo().equals("«"))){
					Estado = Recorriendo.GetEstadoInicial();
					try{
					EstadoAnterior = EstadosAnteriores.pop();
					}
					catch(Exception e){Estados.add(PrimerEstado);  return Estados;}
					ECerraduraEstado(afn,EstadoAnterior,PrimerEstado,1);
					return Estados;
			}
			}
		if(Estado==afn.GetEstadoFinal()){
		Estados.add(afn.GetEstadoFinal());}
		return Estados;}
		
		
		public ArrayList<Integer> Mover(AFN afn,ArrayList<Integer> s,String c){
			for(int i=0; i<s.size(); i++){
				int Numero = s.get(i);
				ArrayList<Transicion> Recorridos = afn.GetCaminos();
				for(int j=0;j<Recorridos.size();j++){
					Transicion Recorriendo = Recorridos.get(j);
					if(Recorriendo.GetEstadoInicial()==Numero && Recorriendo.GetSimbolo().equals(c)){
						Mover.add(Recorriendo.GetEstadoFinal());
						}
					}
				}
		return Mover;
		}
	
		public void DesmarcarAFN(AFN afn){
			ArrayList<Transicion> Recorridos = afn.GetCaminos();
			for(int j=0;j<Recorridos.size();j++){
					Transicion Recorriendo = Recorridos.get(j);
					Recorriendo.SetMarcado(false);
				}
		}	
			
}