import java.util.*;
public class Thompson{
	
	Estado EstadoInicial = new Estado();
	Estado EstadoFinal = new Estado();
	
	public void Thompson(){
		
	}
	
	
	public AFN Construccion(int Opcion,int Identificador,String Simbolo,AFN a,AFN b){
		if (Opcion ==1){//letra
			AFN afn = new AFN();
			Transicion camino = new Transicion();
			afn.SetEstadoInicial(Identificador);
			afn.SetEstadoFinal(Identificador+1);
			camino.SetEstadoInicial(Identificador);
			camino.SetEstadoFinal(Identificador+1);
			camino.SetSimbolo(Simbolo);
			afn.SetArray(camino);
			return afn;
		}
		else if(Opcion == 2){//or
			AFN afn = new AFN();
			Transicion camino = new Transicion();
			Transicion camino1 = new Transicion();
			Transicion camino2 = new Transicion();
			Transicion camino3 = new Transicion();
			afn.SetEstadoInicial(Identificador);
			afn.SetEstadoFinal(Identificador);
			camino.SetEstadoInicial(Identificador);
			camino.SetEstadoFinal(a.GetEstadoInicial());
			camino.SetSimbolo("▓");//epsilon para mi sera alt 178
			afn.SetArray(camino);
			camino1.SetEstadoInicial(Identificador);
			camino1.SetEstadoFinal(b.GetEstadoInicial());
			camino1.SetSimbolo("▓");
			ArrayList<Transicion> Caminosa = a.GetCaminos();
			for(int i=0; i<Caminosa.size(); i++){
				afn.SetArray(Caminosa.get(i));
			}
			ArrayList<Transicion> Caminosb = b.GetCaminos();
			for(int i=0; i<Caminosa.size(); i++){
				afn.SetArray(Caminosb.get(i));
			}
			afn.SetArray(camino1);
			camino2.SetEstadoInicial(a.GetEstadoFinal());
			camino2.SetEstadoFinal(EstadoFinal.GetIdentificador());
			camino2.SetSimbolo("▓");
			afn.SetArray(camino2);
			camino3.SetEstadoInicial(b.GetEstadoFinal());
			camino3.SetEstadoFinal(EstadoFinal.GetIdentificador());
			camino3.SetSimbolo("▓");
			afn.SetArray(camino3);
			return afn;
			}
		else if(Opcion == 3){//concatenacion
			AFN afn = new AFN();
			b.SetEstadoInicial(a.GetEstadoFinal());
			b.SetEstadoFinal(Identificador+1);
			ArrayList<Transicion> Caminosa = a.GetCaminos();
			for(int i=0; i<Caminosa.size(); i++){
				afn.SetArray(Caminosa.get(i));
			}
			ArrayList<Transicion> Caminosb = b.GetCaminos();
			for(int i=0; i<Caminosa.size(); i++){
				afn.SetArray(Caminosb.get(i));
			}
			afn.SetEstadoInicial(Identificador);
		}
		else if(Opcion==4){//kleene
			Transicion camino = new Transicion();
			Transicion camino1 = new Transicion();
			Transicion camino2 = new Transicion();
			Transicion camino3 = new Transicion();
			EstadoInicial.SetIdentificador(Identificador);
			EstadoFinal.SetIdentificador(a.GetEstadoFinal() +1);
			camino.SetEstadoInicial(Identificador);
			camino.SetEstadoFinal(a.GetEstadoInicial());
			camino.SetSimbolo("▓");
			camino1.SetEstadoInicial(a.GetEstadoFinal());
			camino1.SetEstadoFinal(a.GetEstadoInicial());
			camino1.SetSimbolo("▓");
			camino2.SetEstadoInicial(Identificador);
			camino2.SetEstadoFinal(Identificador+1);
			camino2.SetSimbolo("▓");
			camino3.SetEstadoInicial(a.GetEstadoFinal());
			camino3.SetEstadoFinal(Identificador+1);
			camino3.SetSimbolo("▓");
		}
		return null;
	}
	
		public int GetEstadoInicial(){
			return EstadoInicial.GetIdentificador();
		}
		
		public int GetEstadoFinal(){
			return EstadoFinal.GetIdentificador();
		}
		
		public void SetEstadoInicial(int Identificador){
			EstadoInicial.SetIdentificador(Identificador);
		}
		public void SetEstadoFinal(int Identificador){
			EstadoFinal.SetIdentificador(Identificador);
		}
	
	
	
	
	
	
}