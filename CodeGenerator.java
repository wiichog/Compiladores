import java.io.*;
import java.util.*;

public class CodeGenerator{

public void ClassGenerator(ArrayList<String> Nombres,String NombreCompilador) throws IOException{
	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Codigo.java")));
	bw.write("COMPILER " + NombreCompilador + "{");
	for(int i= 0; i<Nombres.size();i++){
		String Nombre = Nombres.get(i);
		bw.write("\n");
		bw.write("\n");
        bw.write(Nombre); 
		bw.write("\n");
		bw.write("}");
    }
		bw.write("\n");
		bw.write("\n");
		bw.write("} END COMPILER " + NombreCompilador);
		bw.close();
}

}