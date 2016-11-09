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
						System.out.println("Simbolo "+Recorriendo.GetSimbolo()+ " Lo que viene "+c);
						Mover.add(Recorriendo.GetEstadoFinal());
						}}
						
				}if(Mover.size()==0){System.out.println(" Lo que viene "+c);}
		return Mover;
		}
	
		public void DesmarcarAFN(AFN afn){
			ArrayList<Transicion> Recorridos = afn.GetCaminos();
			for(int j=0;j<Recorridos.size();j++){
					Transicion Recorriendo = Recorridos.get(j);
					Recorriendo.SetMarcado(false);
				}
		}	
		
		
		
		public Boolean SimulacionFinal(AFN afn,String c){
			ArrayList<Integer> S = new ArrayList<Integer>();
			ArrayList<Integer> S1 = new ArrayList<Integer>();
			Estados.clear();
			DesmarcarAFN(afn);
			Mover.clear();
			ArrayList<Integer> S0 = ECerraduraEstado(afn,afn.GetEstadoInicial(),afn.GetEstadoInicial(),0);
			MostrarDatos mostrar = new MostrarDatos();
			//mostrar.MostrarArrayList(S0);
			c = c + "%";
			//*******Algoritmo Pagina 156 Libro de Dragon
			for(int i=0; i<c.length();i++)
			{
				String z = Character.toString(c.charAt(i));
				
				if(!z.equals("%")){
					S.addAll(Mover(afn,S0,z));//Aqui tenemos mover del estado inicial
					for(int j=0;j<S.size();j++){
						Estados.clear();//vaciamos los arraylist
						DesmarcarAFN(afn);//para poder recorrer el arbol
						Mover.clear();//vaciamos arraylist
						S1.addAll(ECerraduraEstado(afn,S.get(j),S.get(j),0));//hacemos eclousure de mover y lo agregamos a un vector
				S0.clear();
				S0.addAll(S1);
				S1.clear();
				S.clear();
				}
				
			}			
			}
			if(S0.contains(afn.GetEstadoFinal())){return true;}
			else{return false;}	
			
		}
			
}