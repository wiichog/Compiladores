import java.io.*;
import java.util.*;
public class LeerFichero {
    public static void main(String[] args)  {
		ArrayList Names = new ArrayList();
		MostrarDatos Mostrar =  new MostrarDatos();
		ArrayList TokensNames = new ArrayList();
		ArrayList FunctionNames = new ArrayList();
		ArrayList Variables = new ArrayList();
		Map<String, String> map = new HashMap<String, String>();
		Map<String, AFN> Automatas = new HashMap<String, AFN>();
		ScannerValidations Scanner = new ScannerValidations();
		AFNGenerator generator = new AFNGenerator();
		Postfix post = new Postfix();
		try{
		File file = new File("Archivo.txt");
		if(Scanner.SpecialWords(file)==0){System.out.println("Estas Palabras no existen en el archivos");}}
		catch(Exception e){}
		try{
		File file = new File("Archivo.txt");
		if(Scanner.point(file)==0){System.out.println("Estas lineas deberian de tener un punto al final");}}
		catch(Exception e){}
		try{
		File file = new File("Archivo.txt");
		if (Scanner.GotNameCompiler(file).equals("o")){System.out.println("El nombre de COMPILER y END no son los mismos");}}
		catch(Exception e){}
		
		//Here we are gonna create the objects
		
		try{
		String cadena = "";
		boolean CHARACTERS = false;
		boolean KEYWORDS = false;
		boolean TOKENS = false;
		boolean PRODUCTIONS = false;
		BufferedReader b = new BufferedReader(new FileReader(new File("Archivo.txt")));
		while((cadena = b.readLine())!=null) {
			if(cadena.indexOf("CHARACTERS")!=-1){
				CHARACTERS = true;
				KEYWORDS = false;
				TOKENS = false;
				PRODUCTIONS = false;
			}
			if(cadena.indexOf("KEYWORDS")!=-1){
				CHARACTERS = false;
				KEYWORDS = true;
				TOKENS = false;
				PRODUCTIONS = false;
			}
			if(cadena.indexOf("TOKENS")!=-1){
				CHARACTERS = false;
				KEYWORDS = false;
				TOKENS = true;
				PRODUCTIONS = false;
			}
			if(cadena.indexOf("PRODUCTIONS")!=-1){
				CHARACTERS = false;
				KEYWORDS = false;
				TOKENS = false;
				PRODUCTIONS = true;
			}
			if(cadena.indexOf("END")!=-1){
				CHARACTERS = false;
				KEYWORDS = false;
				TOKENS = false;
				PRODUCTIONS = false;
			}
		if((cadena.indexOf("=")!=-1) && CHARACTERS==true){
				if((cadena.indexOf("CHR")!=-1) && (cadena.indexOf("+")!=-1)){
					String[] Contenido = cadena.split(" ");
					String  CadenaDeCaracteres = Contenido[2];
					if((CadenaDeCaracteres.indexOf("'")!=-1)){CadenaDeCaracteres = CadenaDeCaracteres + " '.";}
					String ContenidoLimpio = generator.SpecialCasePlus(CadenaDeCaracteres,Names,map);
					System.out.println("Contenido Limpio "+ContenidoLimpio);
					Names.add(Contenido[0]);
					map.put(Contenido[0],ContenidoLimpio);
				}
				else{
				String[] Contenido = cadena.split(" ");
				String CadenaDeCaracteres = Contenido[2];
				if((CadenaDeCaracteres.indexOf("'")!=-1)){CadenaDeCaracteres = CadenaDeCaracteres + " '.";}
				String ContenidoLimpio = generator.MakeString(CadenaDeCaracteres,true,false);
				Names.add(Contenido[0]);
				map.put(Contenido[0],ContenidoLimpio);}
		}
		if((cadena.indexOf("=")!=-1) && KEYWORDS==true){
				String[] Contenido = cadena.split(" ");
				String  CadenaDeCaracteres = Contenido[2];
				String ContenidoLimpio = generator.MakeString(CadenaDeCaracteres,false,true);
				Names.add(Contenido[0]);
				map.put(Contenido[0],ContenidoLimpio);
		}
		if((cadena.indexOf("=")!=-1) && TOKENS==true){
				String[] Contenido = cadena.split(" ");
				ArrayList Caracteres = new ArrayList();
				String CadenaDeCaracteres = Contenido[2];
				CadenaDeCaracteres = generator.LimpiarCadena(CadenaDeCaracteres);
				for(int i=0; i< Names.size();i++){
					if(CadenaDeCaracteres.contains((String)Names.get(i))){CadenaDeCaracteres = CadenaDeCaracteres.replace((String)Names.get(i),map.get((String)Names.get(i)));}
				}
				TokensNames.add(Contenido[0]);
				Automatas.put(Contenido[0],generator.CreateAFN(post.infixToPostfix(CadenaDeCaracteres)));
		}
		
		if(PRODUCTIONS==true){
			try{
		if(!(cadena.charAt(0)=='	')){
			String[] Contenido = cadena.split("=");
			String LadoDerecho = Contenido[0];
			System.out.println("LadoDerecho " + LadoDerecho);
			LadoDerecho = LadoDerecho.replace("<","(");
			LadoDerecho = LadoDerecho.replace(">",")");
			String LadoIzquierdo = "";
			for(int i=1;i<Contenido.length;i++){
				LadoIzquierdo = LadoIzquierdo + Contenido[i];
			}
			String Resultado = LadoIzquierdo.substring(LadoIzquierdo.indexOf('(')+2,LadoIzquierdo.indexOf(')')-2);
			String[] TipoYVariables = Resultado.split(",|\\ ");
			String TipoDeVariable = "";
			for(int i=1; i<TipoYVariables.length;i++){
				TipoYVariables[i] = TipoYVariables[i].substring(0,TipoYVariables[i].length()-1) + "=" + TipoYVariables[i].substring(TipoYVariables[i].length()-1,TipoYVariables[i].length());
				TipoDeVariable = TipoDeVariable + "," + TipoYVariables[i];
			}
			TipoDeVariable = TipoYVariables[0] + "," + LadoDerecho + TipoDeVariable;
			Variables.add(TipoDeVariable);
			FunctionNames.add(LadoDerecho);
		}}catch(Exception e){}
		
		
		}
		
		
		}
		CodeGenerator generador = new CodeGenerator();
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Lexer.java")));
		generador.CodigoTercerProyecto(bw,FunctionNames,Variables);
		bw.close();
		// CodeGenerator generador = new CodeGenerator();
		// BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Lenguaje.txt")));
		// for(int i=0; i<TokensNames.size();i++){
			// generador.CreadorDeAutomatas(bw,Automatas.get(TokensNames.get(i)),(String)TokensNames.get(i));
		// }
		// bw.close();
		
		
		// bw = new BufferedWriter(new FileWriter(new File("AnalizadorDeCadenas.java")));
		// generador.CrearCodigo(bw);
		// bw.close();
		}
		catch(Exception e){}
		
    	}
    }  