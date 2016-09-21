import java.util.*;
public class TransicionAFD{
	
	String Simbolo;
	
	public void TransicionAFD(){}
	
	public void SetInicio(ArrayList<Integer>Inicio){
		this.Inicio.addAll(Inicio);
	}
	
	public void SetFinal(ArrayList<Integer>Final){
		this.Inicio.addAll(Final);
	}
	
	public void SetSimbolo(String Simbolo){
		this.Simbolo=Simbolo;
	}
	
	public ArrayList<Integer> GetInicio(){
		return Inicio;
	}
	
	public ArrayList<Integer> GetFinal(){
		return Final;
	}
	
	public String GetSimbolo(){
		return Simbolo;
	}
	
	
	
	
	
}