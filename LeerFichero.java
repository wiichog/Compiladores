import java.io.*;
public class LeerFichero {
    
    // public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        // String cadena;
        // FileReader f = new FileReader(archivo);
        // BufferedReader b = new BufferedReader(f);
        // while((cadena = b.readLine())!=null) {
            // System.out.println(cadena);
        // }
        // b.close();
    // }
// throws IOException
    public static void main(String[] args)  {
		ScannerValidations Scanner = new ScannerValidations();
		try{
		File file = new File("Archivo.txt");
		if(Scanner.SpecialWords(file)==0){System.out.println("Estas Palabras no existen en el archivos");}}
		catch(Exception e){}
		
		try{
		File file = new File("Archivo.txt");
		if(Scanner.point(file)==0){System.out.println("Estas lineas deberian de tener un punto al final");}}
		catch(Exception e){}
		
		
        // muestraContenido(Archivo);
		
    }
   
}