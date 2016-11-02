import java.util.*;

public class NewExpression{
	
	String Nombre;
	String Tipo;
	AFN Contenido;
	
	public NewExpression(String Nombre, String Tipo, AFN Contenido) {
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
	
	public AFN GetContenido(){
		return Contenido;
	}
	
	
	
}