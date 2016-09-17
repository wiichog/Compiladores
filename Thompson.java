import java.util.*;
public class Thompson{
	
	Estado EstadoInicial = new Estado();
	Estado EstadoFinal = new Estado();
	
	public void Thompson(){
		
	}
	
	public AFN Construccion(int Opcion,String Simbolo,AFN a,AFN b){
		if (Opcion ==1){//letra
			AFN afn = new AFN();
			Transicion camino = new Transicion();
			afn.SetEstadoInicial(ContadorEstados.getContador());
			afn.SetEstadoFinal(ContadorEstados.getContador());
			camino.SetEstadoInicial(afn.GetEstadoInicial());
			camino.SetEstadoFinal(afn.GetEstadoFinal());
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
			//Ponemos estados inicial al nuevo automata
			afn.SetEstadoInicial(ContadorEstados.getContador());
			afn.SetEstadoFinal(ContadorEstados.getContador());
			//Iniciamos el primer camino
			camino.SetEstadoInicial(afn.GetEstadoInicial());
			camino.SetEstadoFinal(a.GetEstadoInicial());
			camino.SetSimbolo("«");//epsilon para mi sera alt 174
			afn.SetArray(camino);//ingresamos el camino al automata
			//iniciamos el segundo automata
			camino1.SetEstadoInicial(afn.GetEstadoInicial());
			camino1.SetEstadoFinal(b.GetEstadoInicial());
			camino1.SetSimbolo("«");
			afn.SetArray(camino1);//metemos el camino al automata
			ArrayList<Transicion> Caminosa = a.GetCaminos();//en este array vamos a guardar todos los caminos del primer caracter para el or
			for(int i=0; i<Caminosa.size(); i++){
				afn.SetArray(Caminosa.get(i));
			}
			ArrayList<Transicion> Caminosb = b.GetCaminos();//en este array vamos a guardar todos los caminos del segundo caracter para el or
			for(int i=0; i<Caminosb.size(); i++){
				afn.SetArray(Caminosb.get(i));
			}
			camino2.SetEstadoInicial(a.GetEstadoFinal());
			camino2.SetEstadoFinal(afn.GetEstadoFinal());
			camino2.SetSimbolo("«");
			afn.SetArray(camino2);
			camino3.SetEstadoInicial(b.GetEstadoFinal());
			camino3.SetEstadoFinal(afn.GetEstadoFinal());
			camino3.SetSimbolo("«");
			afn.SetArray(camino3);
			return afn;
			}
		else if(Opcion == 3){//concatenacion
			AFN afn = new AFN();
			afn.SetEstadoInicial(a.GetEstadoInicial());
			afn.SetEstadoFinal(b.GetEstadoFinal());
			Transicion camino = new Transicion();
			//Ponemos estados inicial al nuevo automata
			ArrayList<Transicion> Caminosa = a.GetCaminos();
			for(int i=0; i<Caminosa.size(); i++){
				afn.SetArray(Caminosa.get(i));
			}
			camino.SetEstadoInicial(a.GetEstadoFinal());
			camino.SetEstadoFinal(b.GetEstadoInicial());
			camino.SetSimbolo("«");
			afn.SetArray(camino);//ingresamos el camino al automata
			//Ponemos estados inicial al nuevo automata
			ArrayList<Transicion> Caminosb = b.GetCaminos();
			for(int i=0; i<Caminosb.size(); i++){
				afn.SetArray(Caminosb.get(i));
			}
			return afn;
		}
		else if(Opcion==4){//kleene
			AFN afn = new AFN();
			Transicion camino = new Transicion();
			Transicion camino1 = new Transicion();
			Transicion camino2 = new Transicion();
			Transicion camino3 = new Transicion();
			afn.SetEstadoInicial(ContadorEstados.getContador());
			afn.SetEstadoFinal(ContadorEstados.getContador());
			camino.SetEstadoInicial(afn.GetEstadoInicial());
			camino.SetEstadoFinal(a.GetEstadoInicial());
			camino.SetSimbolo("«");
			afn.SetArray(camino);//ingresamos el camino al automata
			camino2.SetEstadoInicial(afn.GetEstadoInicial());
			camino2.SetEstadoFinal(afn.GetEstadoFinal());
			camino2.SetSimbolo("«");
			afn.SetArray(camino2);//ingresamos el camino al automata
			camino1.SetEstadoInicial(a.GetEstadoFinal());
			camino1.SetEstadoFinal(a.GetEstadoInicial());
			camino1.SetSimbolo("«");
			ArrayList<Transicion> Caminosa = a.GetCaminos();//en este array vamos a guardar todos los caminos del segundo caracter para el or
			for(int i=0; i<Caminosa.size(); i++){
				afn.SetArray(Caminosa.get(i));
			}
			afn.SetArray(camino1);//ingresamos el camino al automata
			camino3.SetEstadoInicial(a.GetEstadoFinal());
			camino3.SetEstadoFinal(afn.GetEstadoFinal());
			camino3.SetSimbolo("«");
			afn.SetArray(camino3);//ingresamos el camino al automata
			return afn;
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