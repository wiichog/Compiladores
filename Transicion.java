public class Transicion{
	
	int EstadoInicial;
	int EstadoFinal;
	String Simbolo;
	
	public void Transicion(){
		EstadoInicial = 0;
		EstadoFinal = 0;
		Simbolo = "";
	}
	
	public void SetEstadoInicial(int EstadoInicial){
		this.EstadoInicial = EstadoInicial;
	}
	
	public void SetEstadoFinal(int EstadoFinal){
		this.EstadoFinal = EstadoFinal;
	}
	
	public int GetEstadoInicial(){
		return EstadoInicial;
	}
	
	public int GetEstadoFinal(){
		return EstadoFinal;
	}
	
	public void SetSimbolo(String Simbolo){
		this.Simbolo = Simbolo;	
	}
	
	public String GetSimbolo(){
		return Simbolo;
	}
		
}