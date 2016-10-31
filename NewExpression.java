import java.util.*;

public class NewExpression{
	
	String Nombre;
	String Tipo;
	ArrayList<String> Contenido = new ArrayList<String>();
	
	public NewExpression(String Nombre, String Tipo, ArrayList Contenido) {
		this.Nombre= Nombre;
		this.Tipo = Tipo;
		this.Contenido.addAll(Contenido);
	}
	
	public String GetNombre(){
		return Nombre;
	}
	
	
	public String GetTipo(){
		return Tipo;
	}
	
	public ArrayList GetContenido(){
		return Contenido;
	}
	
	
	
}