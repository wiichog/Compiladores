import java.io.*;
import java.util.*;

public class CodeGenerator{
	
	public void CrearCodigo(BufferedWriter bw){
		try{
		bw.write("import java.io.*;\n");
		bw.write("import java.util.*;\n");
		bw.write("public class AnalizadorDeCadenas {\n");
		bw.write("  public static void main(String[] args)  {\n");
		bw.write("	ArrayList TokensNames = new ArrayList();\n");
		bw.write("	ArrayList<Transicion> CaminosAFN = new ArrayList<Transicion>();\n");
		bw.write("	Map<String, AFN> Automatas = new HashMap<String, AFN>();\n");
		bw.write("	String cadena = \"\";\n");
		bw.write("	String Nombre = \"\";\n");
		bw.write("	int EstadoInicial = 0;\n");
		bw.write("	int EstadoFinal = 0;\n");
		bw.write("	try{\n");
		bw.write("	BufferedReader b = new BufferedReader(new FileReader(new File(\"Lenguaje.txt\")));\n");
		bw.write("	while((cadena = b.readLine())!=null) {\n");
		bw.write("		if(!(cadena.contains(\"ƒ\"))){\n");
		bw.write("			String[] Nombres = cadena.split(\"æ\");\n");
		bw.write("			Nombre = Nombres[0];\n");
		bw.write("			TokensNames.add(Nombre);\n");
		bw.write("			EstadoInicial=Integer.valueOf(Nombres[1]);\n");
		bw.write("			EstadoFinal=Integer.valueOf(Nombres[2]);\n");
		bw.write("			AFN afn = new AFN();\n");
		bw.write("			afn.SetEstadoInicial(EstadoInicial);\n");
		bw.write("			afn.SetEstadoFinal(EstadoFinal);\n");
		bw.write("			for(int i=0;i<CaminosAFN.size();i++){\n");
		bw.write("				afn.SetArray(CaminosAFN.get(i));\n");
		bw.write("			}\n");
		bw.write("			Automatas.put(Nombre,afn);\n");
		bw.write("			CaminosAFN.clear();\n");
		bw.write("		}\n");
		bw.write("		else{\n");
		bw.write("			String[] Transicion = cadena.split(\"ƒ\");\n");
		bw.write("			Transicion camino = new Transicion();\n");
		bw.write("			camino.SetEstadoInicial(Integer.valueOf(Transicion[0]));\n");
		bw.write("			camino.SetEstadoFinal(Integer.valueOf(Transicion[2]));\n");
		bw.write("			camino.SetSimbolo(Transicion[1]);\n");
		bw.write("			CaminosAFN.add(camino);\n");
		bw.write("		}\n");
		bw.write("	}\n");
		bw.write("	}catch(Exception e){}	\n");
		bw.write("	try{\n");
		bw.write("		String linea = \"\";\n");
		bw.write("		BufferedReader b = new BufferedReader(new FileReader(new File(\"Archivo2.txt\")));\n");
		bw.write("		while((linea = b.readLine())!=null) {\n");
		bw.write("			for(int i=0;i<TokensNames.size();i++){\n");
		bw.write("				AFN afn =Automatas.get(TokensNames.get(i));\n");
		bw.write("				SimulacionAFN Simulacion = new SimulacionAFN();\n");
		bw.write("				System.out.println(\"**************************\");\n");
		bw.write("				System.out.println(\"Para \"+linea+ \" el resultado de \"+ TokensNames.get(i) +\" es \"+Simulacion.SimulacionFinal(afn,linea));\n");
		bw.write("				System.out.println(\"**************************\");\n");
		bw.write("			}			\n");
		bw.write("			}\n");
		bw.write("		}\n");
		bw.write("		catch(Exception e){}	\n");
		bw.write("}}");
		}catch(Exception e){}
			
		}
		
		
	public void CreadorDeAutomatas(BufferedWriter bw,AFN afn,String Nombre){
		try{
		ArrayList<Transicion> CaminosAFN = afn.GetCaminos();
		for(int t=0;t<CaminosAFN.size();t++){
				Transicion Camino = CaminosAFN.get(t);
				bw.write(Camino.GetEstadoInicial()+"ƒ"+Camino.GetSimbolo()+"ƒ"+Camino.GetEstadoFinal()+"\n");
			}
		bw.write(Nombre+"æ"+afn.GetEstadoInicial()+"æ"+afn.GetEstadoFinal()+"\n");
		}catch(Exception e){}
		
		
	}
	
	
	
	public void CodigoTercerProyecto(BufferedWriter bw,ArrayList FunctionNames,ArrayList Variables){
		try{
			bw.write("//Juan Luis Garcia\n");
			bw.write("//14189\n");
			bw.write("\n");
			bw.write("public class Lexer {\n");
			bw.write("  public static void main(String[] args)  {\n");
			for(int i=0;i<FunctionNames.size();i++){
				bw.write("\n");
				bw.write("public " + FunctionNames.get(i) + " { \n");
				for(int j=0;j<Variables.size();j++){
					String VariablesYTipos = (String)Variables.get(j);
					String[] ConjuntoVariables = VariablesYTipos.split(",");
					String Tipo = ConjuntoVariables[0];
					String NombreFuncion = ConjuntoVariables[1];
					if (NombreFuncion.equals(FunctionNames.get(i))){
						for(int y=2; y<ConjuntoVariables.length;y++){
							bw.write(Tipo + " " + ConjuntoVariables[y] + "\n");
						}
						
					}
				}
				bw.write("}\n");
			}
			
			bw.write("}\n");
			bw.write("}\n");
		}catch(Exception e){}
			
		}
			
	
	
}