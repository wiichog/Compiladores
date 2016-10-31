import java.io.*;
import java.util.*;
public class LeerFichero {
    public static void main(String[] args)  {
		Stack SCHARACTERS = new Stack();
		Stack SKEYWORDS = new Stack();
		Stack STOKENS = new Stack();
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
				System.out.println("CHARACTERS");
				CHARACTERS = true;
				KEYWORDS = false;
				TOKENS = false;
			}
			if(cadena.indexOf("KEYWORDS")!=-1){
				System.out.println(cadena);
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
				String[] Contenido = cadena.split(" ");
				ArrayList Caracteres = new ArrayList();
				String  CadenaDeCaracteres = Contenido[2];
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					char posicion = CadenaDeCaracteres.charAt(i); 
					if(!(posicion=='"') || !(posicion=='.')){Caracteres.add(posicion);}
				}
				NewExpression CharacterExpression =  new NewExpression(Contenido[0],"CHARACTERS",Caracteres);
				SCHARACTERS.push(CharacterExpression);
				
		}
		
		if((cadena.indexOf("=")!=-1) && KEYWORDS==true){
				String[] Contenido = cadena.split(" ");
				ArrayList Caracteres = new ArrayList();
				String  CadenaDeCaracteres = Contenido[2];
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					char posicion = CadenaDeCaracteres.charAt(i); 
					if(!(posicion=='"') || !(posicion=='.')){Caracteres.add(posicion);}
				}
				NewExpression CharacterExpression =  new NewExpression(Contenido[0],"KEYWORDS",Caracteres);
				SKEYWORDS.push(CharacterExpression);
				
		}
		
		if((cadena.indexOf("=")!=-1) && TOKENS==true){
				String[] Contenido = cadena.split(" ");
				ArrayList Caracteres = new ArrayList();
				String  CadenaDeCaracteres = Contenido[2];
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					char posicion = CadenaDeCaracteres.charAt(i); 
					if(!(posicion=='"') || !(posicion=='.')){Caracteres.add(posicion);}
				}
				NewExpression CharacterExpression =  new NewExpression(Contenido[0],"TOKENS",Caracteres);
				STOKENS.push(CharacterExpression);
				
		}
		}
		}
			
		catch(Exception e){}
		
		
		
    }
   
}