import java.io.*;
import java.util.*;
public class LeerFichero {
    public static void main(String[] args)  {
		ArrayList Names = new ArrayList();
		MostrarDatos Mostrar =  new MostrarDatos();
		ArrayList TokensNames = new ArrayList();
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
		if((cadena.indexOf("=")!=-1) && CHARACTERS==true){
				if((cadena.indexOf("CHR")!=-1) && (cadena.indexOf("+")!=-1)){
					String[] Contenido = cadena.split(" ");
					String  CadenaDeCaracteres = Contenido[2];
					if((CadenaDeCaracteres.indexOf("'")!=-1)){CadenaDeCaracteres = CadenaDeCaracteres + " '.";}
					String ContenidoLimpio = generator.SpecialCasePlus(CadenaDeCaracteres,Names,map);
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
				System.out.println(CadenaDeCaracteres);
				Automatas.put(Contenido[0],generator.CreateAFN(post.infixToPostfix(CadenaDeCaracteres)));
		}
		}
		}
		catch(Exception e){}
		// MostrarDatos mostrar = new MostrarDatos();
		// mostrar.MostrarArrayList(TokensNames,"Nombres de Tokens ");
		// AFN afn1 = Automatas.get("white");
		// SimulacionAFN Simulacion2 = new SimulacionAFN();
		// System.out.println("Prueba "+Simulacion2.SimulacionFinal(afn1,"78979845"));
		
		
		// LETS SCAN THE NEW FILE
		// try{
		// String cadena = "";
		// BufferedReader b = new BufferedReader(new FileReader(new File("Archivo2.txt")));
		// while((cadena = b.readLine())!=null) {
		// System.out.println("************");
		// for(int i=0;i<TokensNames.size();i++){
			// String Nombre =(String) TokensNames.get(i);
			// AFN afn = Automatas.get(Nombre);
			// SimulacionAFN Simulacion = new SimulacionAFN();
			// if(Simulacion.SimulacionFinal(afn,cadena)==true){System.out.println("La palabra "+cadena+" para el AFN de "+Nombre+" resulto ser verdadera ");}
			// else if(Simulacion.SimulacionFinal(afn,cadena)==false){System.out.println("La palabra "+cadena+" para el AFN de "+Nombre+" resulto ser falsa ");}
			// else{System.out.println("La palabra "+cadena+" no es correcta en ningun AFN ");}
		// }
		// System.out.println("************");
			// }
		// }
		// catch(Exception e){}
		AFN Final = Automatas.get("white");
		Mostrar.MostrarAFN(Final);
		ArrayList<Transicion> CaminosAFN = Final.GetCaminos();
		try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Lenguaje.txt")));
		for(int t=0;t<CaminosAFN.size();t++){
			Transicion Camino = CaminosAFN.get(t);
			bw.write(Camino.GetEstadoInicial()+"ƒ"+Camino.GetSimbolo()+"ƒ"+Camino.GetEstadoFinal()+"\n");
		}
        bw.close();}
		catch(Exception e){}
    	}
    }