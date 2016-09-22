import java.util.*;
import java.io.*;
public class AFN{
	
	Estado EstadoInicial=new Estado();
	Estado EstadoFinal= new Estado();
	ArrayList<Transicion> array= new ArrayList<Transicion>();
	
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
	public void SetArray(Transicion camino){
		array.add(camino);
	}
	
	public ArrayList<Transicion> GetCaminos(){
		return array;
	}
	
	
}