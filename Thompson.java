public class Thompson{
	
	Estado EstadoInicial = new Estado();
	Estado EstadoFinal = new Estado();
	
	public void Thompson(){
		
	}
	
	
	public void Construccion(int Opcion,int Identificador,String Simbolo,Thompson a,Thompson b){
		if (Opcion ==1){//letra
			Estado EstadoInicial = new Estado();
			Estado EstadoFinal = new Estado();
			Transicion camino = new Transicion();
			EstadoInicial.SetIdentificador(Identificador);
			System.out.println(EstadoInicial.GetIdentificador());
			EstadoFinal.SetIdentificador(Identificador+1);
			System.out.println(EstadoFinal.GetIdentificador());
			camino.SetEstadoFinal(Identificador);
			camino.SetEstadoFinal(Identificador+1);
			camino.SetSimbolo(Simbolo);
			System.out.println(camino.GetSimbolo());
			System.out.println("*************");
		}
		else if(Opcion == 2){//or
			Transicion camino = new Transicion();
			Transicion camino1 = new Transicion();
			Transicion camino2 = new Transicion();
			Transicion camino3 = new Transicion();
			EstadoInicial.SetIdentificador(Identificador);
			EstadoFinal.SetIdentificador(b.GetEstadoFinal() +1);
			camino.SetEstadoInicial(Identificador);
			camino.SetEstadoFinal(a.GetEstadoInicial());
			camino.SetSimbolo("▓");//epsilon para mi sera alt 178
			camino1.SetEstadoInicial(Identificador);
			camino1.SetEstadoFinal(b.GetEstadoInicial());
			camino1.SetSimbolo("▓");
			camino2.SetEstadoInicial(a.GetEstadoFinal());
			camino2.SetEstadoFinal(EstadoFinal.GetIdentificador());
			camino2.SetSimbolo("▓");
			camino3.SetEstadoInicial(b.GetEstadoFinal());
			camino3.SetEstadoFinal(EstadoFinal.GetIdentificador());
			camino3.SetSimbolo("▓");
			}
		else if(Opcion == 3){//concatenacion
			a.SetEstadoInicial(Identificador);
			b.SetEstadoInicial(a.GetEstadoFinal());
			b.SetEstadoFinal(Identificador+1);
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