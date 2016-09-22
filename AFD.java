import java.util.*;
import java.io.*;
public class AFD{
	
	ArrayList<TransicionAFD> array= new ArrayList<TransicionAFD>();
	ArrayList<Integer> Inicio = new ArrayList<Integer>();
	ArrayList<Integer> Final = new ArrayList<Integer>();
	
	public void SetArray(TransicionAFD camino){
		array.add(camino);
	}
	
	public ArrayList<TransicionAFD> GetCaminos(){
		return array;
	}
	
	public void SetFinal(ArrayList<Integer>Final){
		this.Final.addAll(Final);
	}
	
	public void SetInicio(ArrayList<Integer>Inicio){
		this.Inicio.addAll(Inicio);
	}
	
	public ArrayList<Integer> GetInicio(){
		return Inicio;
	}
	
	public ArrayList<Integer> GetFinal(){
		return Final;
	}
	
	
}