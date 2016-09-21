import java.util.*;
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
	
	
}