import java.io.*;
import java.util.*;
public class LeerFichero {
    public static void main(String[] args)  {
		ArrayList Names = new ArrayList();
		MostrarDatos Mostrar =  new MostrarDatos();
		Stack StackAutomatas = new Stack();
		Map<String, String> map = new HashMap<String, String>();
		Map<String, AFN> Automatas = new HashMap<String, AFN>();
		ScannerValidations Scanner = new ScannerValidations();
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
		BufferedReader b = new BufferedReader(new FileReader(new File("Archivo.txt")));
		while((cadena = b.readLine())!=null) {
			if(cadena.indexOf("CHARACTERS")!=-1){
				CHARACTERS = true;
				KEYWORDS = false;
				TOKENS = false;
			}
			if(cadena.indexOf("KEYWORDS")!=-1){
				CHARACTERS = false;
				KEYWORDS = true;
				TOKENS = false;
			}
			if(cadena.indexOf("TOKENS")!=-1){
				CHARACTERS = false;
				KEYWORDS = false;
				TOKENS = true;
			}
		if((cadena.indexOf("=")!=-1) && CHARACTERS==true){
				if((cadena.indexOf("CHR")!=-1) && (cadena.indexOf("+")!=-1)){
					String[] Contenido = cadena.split(" ");
					String  CadenaDeCaracteres = Contenido[2];
					if((CadenaDeCaracteres.indexOf("'")!=-1)){CadenaDeCaracteres = CadenaDeCaracteres + " '.";}
					AFNGenerator generator = new AFNGenerator();
					String ContenidoLimpio = generator.SpecialCasePlus(CadenaDeCaracteres,Names,map);
					Names.add(Contenido[0]);
					map.put(Contenido[0],ContenidoLimpio);
				}
				else{
				String[] Contenido = cadena.split(" ");
				String CadenaDeCaracteres = Contenido[2];
				if((CadenaDeCaracteres.indexOf("'")!=-1)){CadenaDeCaracteres = CadenaDeCaracteres + " '.";}
				AFNGenerator generator = new AFNGenerator();
				String ContenidoLimpio = generator.MakeString(CadenaDeCaracteres,true,false);
				Names.add(Contenido[0]);
				map.put(Contenido[0],ContenidoLimpio);}
		}
		if((cadena.indexOf("=")!=-1) && KEYWORDS==true){
				String[] Contenido = cadena.split(" ");
				String  CadenaDeCaracteres = Contenido[2];
				AFNGenerator generator = new AFNGenerator();
				String ContenidoLimpio = generator.MakeString(CadenaDeCaracteres,false,true);
				Names.add(Contenido[0]);
				map.put(Contenido[0],ContenidoLimpio);
		}
		if((cadena.indexOf("=")!=-1) && TOKENS==true){
				String[] Contenido = cadena.split(" ");
				ArrayList Caracteres = new ArrayList();
				String  CadenaDeCaracteres = Contenido[2];
				AFNGenerator generator = new AFNGenerator();
				CadenaDeCaracteres = generator.LimpiarCadena(CadenaDeCaracteres);
				for(int i=0; i< Names.size();i++){
					if(CadenaDeCaracteres.contains((String)Names.get(i))){CadenaDeCaracteres = CadenaDeCaracteres.replace((String)Names.get(i),map.get((String)Names.get(i)));}
				}
				Postfix post = new Postfix();
				Automatas.put(Contenido[0],generator.CreateAFN(post.infixToPostfix(CadenaDeCaracteres)));
				StackAutomatas.push(generator.CreateAFN(post.infixToPostfix(CadenaDeCaracteres)));
				
		}
		}
		}
		catch(Exception e){}
		
		// LETS SCAN THE NEW FILE
		try{
		String cadena = "";
		BufferedReader b = new BufferedReader(new FileReader(new File("Archivo.txt")));
		while((cadena = b.readLine())!=null) {
			if((cadena.indexOf("=")!=-1)){
			String[] Contenido = cadena.split(" ");
			String Ident = Contenido[0];
			AFN afn = Automatas.get("ident");
			SimulacionAFN Simulacion = new SimulacionAFN();
			System.out.println("**************************");
			System.out.println("Para "+Contenido[0]+ " el resultado es "+Simulacion.SimulacionFinal(afn,Ident));
			System.out.println("**************************");
			
			}
			}
		}
		catch(Exception e){}
		
		
		
		
		//LETS JOIN THE AUTOMS
		// Thompson afn = new Thompson();
		// while(!(StackAutomatas.size()==1)){
			// AFN a = (AFN)StackAutomatas.pop();
			// AFN b = (AFN)StackAutomatas.pop();
			// StackAutomatas.push(afn.Construccion(2,"«",a,b));
		// }
		AFN Final = Automatas.get("ident");
		// AFN Final = (AFN)StackAutomatas.pop();
		ArrayList<Transicion> CaminosAFN = Final.GetCaminos();
		try{
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Lenguaje.txt")));
		for(int t=0;t<CaminosAFN.size();t++){
			Transicion Camino = CaminosAFN.get(t);
			if(!(Camino.GetSimbolo().equals("«"))){
			bw.write(Camino.GetEstadoInicial()+"ƒ"+Camino.GetSimbolo()+"ƒ"+Camino.GetEstadoFinal()+"\n");}
		}
        bw.close();}
		catch(Exception e){}
    	}
    }  
