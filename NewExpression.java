import java.util.*;

public class NewExpression{
	
	String Nombre;
	String Tipo;
	String Contenido;
	
	public NewExpression(String Nombre, String Tipo, String Contenido) {
		this.Nombre= Nombre;
		this.Tipo = Tipo;
		this.Contenido = Contenido;
	}
	
	public String GetNombre(){
		return Nombre;
	}
	
	
	public String GetTipo(){
		return Tipo;
	}
	
	public String GetContenido(){
		return Contenido;
	}
	
	
	
}