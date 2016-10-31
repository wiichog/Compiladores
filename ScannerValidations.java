import java.io.*;
import java.util.Scanner;

public class ScannerValidations{
	
	public int SpecialWords(File file){
		try{
		Scanner scanner = new Scanner(file);
		int COMPILER=0;
		int CHARACTERS=0;
		int KEYWORDS=0;
		int TOKENS=0;
		int END=0;
		int Contador = 0;
		while (scanner.hasNextLine()) {
		String nextToken = scanner.next();
		if (nextToken.equalsIgnoreCase("COMPILER")){COMPILER = 1;}
		if (nextToken.equalsIgnoreCase("CHARACTERS")){CHARACTERS = 1;}
		if (nextToken.equalsIgnoreCase("KEYWORDS")){KEYWORDS = 1;}
		if (nextToken.equalsIgnoreCase("TOKENS")){TOKENS = 1;}
		if (nextToken.equalsIgnoreCase("END")){END = 1;}
		Contador ++;
		}
		if (COMPILER==0){System.out.println("COMPILER");}
		if (CHARACTERS==0){System.out.println("CHARACTERS");}
		if (KEYWORDS==0){System.out.println("KEYWORDS");}
		if (TOKENS==0){System.out.println("TOKENS");}
		if (END==0){System.out.println("END");}
		
		if(COMPILER==1 && CHARACTERS==1 && KEYWORDS==1 && TOKENS==1 && END==1){return 1;}
		else{return 0;}
		}
		catch(Exception e){return 15;}
		}
		
	public int point(File file){
		try{
		String cadena = "";
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
            if(cadena.indexOf("=")!=-1){
				int n = cadena.length();
				Character car=cadena.charAt(n-1); 
				if (!(Character.toString(car).equals("."))){System.out.println(cadena);return 0;}
			}
        }return 12;}
		catch(Exception e){return 45;}
		}
		
	public String GotNameCompiler(File file){
		try{
		String cadena = "";
		String Name1 = "";
		String Name2 = "";
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
            if(cadena.indexOf("COMPILER")!=-1){
				Name1 = cadena.substring(9,cadena.length());
			}
			if(cadena.indexOf("END")!=-1){
				Name2 = cadena.substring(4,cadena.length());
			}
        }
		if(Name1.equals(Name2)){return Name1;}else{return "o";}}
		catch(Exception e){return "";}
		
	}
	
}