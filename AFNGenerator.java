import java.util.*;
public class AFNGenerator{

	public AFN CreateAFN(String Postfix){
		Stack st = new Stack();
		Thompson AFN = new Thompson();
		for (int i=0; i<Postfix.length(); i++) { 
			char posicion = Postfix.charAt(i); 
			String Simbolo = Character.toString(posicion);
			if (Character.isLetterOrDigit(posicion)){
				st.push(AFN.Construccion(1,Simbolo,null,null));
			}
			else if(Simbolo.equals("|")){
				AFN b = (AFN) st.pop();
				AFN a = (AFN) st.pop();
				st.push(AFN.Construccion(2,Simbolo,a,b));	
			}
			else if(Simbolo.equals(".")){
				AFN b = (AFN) st.pop();
				AFN a = (AFN) st.pop();
				
				st.push(AFN.Construccion(3,Simbolo,a,b));
			}
			else if(Simbolo.equals("*")){
				AFN a = (AFN) st.pop();
				st.push(AFN.Construccion(4,Simbolo,a,null));
			}
			}
			AFN afn = (AFN) st.pop();
		return afn;
	}
	
	public String MakeString(String CadenaDeCaracteres, boolean CHARACTER,boolean KEYWORDS){
		String NuevaCadena="";
		if (CadenaDeCaracteres.charAt(0)=='"' && CHARACTER == true){
				String Parentesis = ")";
				CadenaDeCaracteres = LimpiarCadena(CadenaDeCaracteres);
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					if (i==0){NuevaCadena ="("+NuevaCadena + Character.toString(CadenaDeCaracteres.charAt(i));}
					else {NuevaCadena =NuevaCadena +"|(" + Character.toString(CadenaDeCaracteres.charAt(i));Parentesis=Parentesis + ")";}
				}
					return NuevaCadena + Parentesis;
				}
			else if(!(CadenaDeCaracteres.charAt(0)=='"') && CHARACTER == true){
				String s = CadenaDeCaracteres;
					if((CadenaDeCaracteres.indexOf("CHR")!=-1)){s = s.substring(s.indexOf("(") + 1);s = s.substring(0, s.indexOf(")"));return Character.toString((char)Integer.parseInt(s));}
				}
			if (CadenaDeCaracteres.charAt(0)=='"' && KEYWORDS == true){
				    CadenaDeCaracteres = LimpiarCadena(CadenaDeCaracteres);return CadenaDeCaracteres;
			}
		return "ERROR";
	}
	
	public String SpecialCasePlus(String CadenaDeCaracteres, ArrayList Nombres, Map<String, String> map){
		String NuevaCadena = LimpiarCadena(CadenaDeCaracteres);
		for(int i=0; i< Nombres.size();i++){
			if(CadenaDeCaracteres.contains((String)Nombres.get(i))){NuevaCadena = NuevaCadena.replace((String)Nombres.get(i),map.get((String)Nombres.get(i)));}
		}
		if(NuevaCadena.contains("CHR")){
				String Posiblemente = NuevaCadena.substring(NuevaCadena.indexOf("C"));
				Posiblemente = Posiblemente.substring(0, NuevaCadena.indexOf(")"));
				String Cambio = MakeString(Posiblemente, true,false);
				NuevaCadena = NuevaCadena.replace(Posiblemente,Cambio);
			}
		return NuevaCadena;
	}
	
	public String LimpiarCadena(String CadenaDeCaracteres){
				String NuevaCadena ="";
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					Character posicion = CadenaDeCaracteres.charAt(i);
					String Prueba = Character.toString(posicion);
					if (!(posicion=='"') && !(posicion=='.') && !(posicion=='+') && !(posicion==(char)39)){NuevaCadena = NuevaCadena + Character.toString(posicion);}
				}
				NuevaCadena = NuevaCadena.replace("{","(");
				NuevaCadena = NuevaCadena.replace("}",")*");
				return NuevaCadena;
	}

}