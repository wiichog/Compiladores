import java.io.*;
import java.util.*;
public class LeerFichero {
    public static void main(String[] args)  {
		ArrayList Names = new ArrayList();
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
		File file = new File("Archivo.txt");
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
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
				String  CadenaDeCaracteres = Contenido[2];
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
				System.out.println(CadenaDeCaracteres);
				Postfix post = new Postfix();
				MostrarDatos Mostrar =  new MostrarDatos();
				//Mostrar.MostrarAFN(generator.CreateAFN(post.infixToPostfix(CadenaDeCaracteres)));
				Automatas.put(Contenido[0],generator.CreateAFN(post.infixToPostfix(CadenaDeCaracteres)));
		}
		}
		}
			
		catch(Exception e){}
		
		
		
    }
   
}