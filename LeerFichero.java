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
				String[] Contenido = cadena.split(" ");
				String  CadenaDeCaracteres = Contenido[2];
				AFNGenerator generator = new AFNGenerator();
				AFN afn = generator.MakeString(CadenaDeCaracteres);
				NewExpression CharacterExpression =  new NewExpression(Contenido[0],"CHARACTERS",afn);
				SCHARACTERS.push(CharacterExpression);
		}
		
		if((cadena.indexOf("=")!=-1) && KEYWORDS==true){
				String[] Contenido = cadena.split(" ");
				String  CadenaDeCaracteres = Contenido[2];
				String NuevaCadena ="";
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					char posicion = CadenaDeCaracteres.charAt(i); 
					if(!(posicion=='"') || !(posicion=='.')){NuevaCadena = NuevaCadena + Character.toString(posicion);}
				}
				//NewExpression CharacterExpression =  new NewExpression(Contenido[0],"KEYWORDS",NuevaCadena);
//SKEYWORDS.push(CharacterExpression);
				
		}
		
		if((cadena.indexOf("=")!=-1) && TOKENS==true){
				String[] Contenido = cadena.split(" ");
				String  CadenaDeCaracteres = Contenido[2];
				String NuevaCadena ="";
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					char posicion = CadenaDeCaracteres.charAt(i); 
					if(!(posicion=='"') || !(posicion=='.')){
						
						
						NuevaCadena = NuevaCadena + Character.toString(posicion);
						
						
						
						}
				}
				//NewExpression CharacterExpression =  new NewExpression(Contenido[0],"TOKENS",NuevaCadena);
				//STOKENS.push(CharacterExpression);
				
		}
		}
		}
			
		catch(Exception e){}
		
		NewExpression CharacterExpression = (NewExpression) SCHARACTERS.pop();
		System.out.println(CharacterExpression.GetContenido());
		
    }
   
}