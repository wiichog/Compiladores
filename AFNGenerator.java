import java.util.*;
public class AFNGenerator{

	public AFN CreateAFN(String Postfix){
		Stack st = new Stack();
		Thompson AFN = new Thompson();
		for (int i=0; i<Postfix.length(); i++) { 
			char posicion = Postfix.charAt(i); 
			String Simbolo = Character.toString(posicion);
			if (Character.isLetter(posicion)){
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
	
	public AFN MakeString(String CadenaDeCaracteres){
				String NuevaCadena ="";
				String Parentesis = "";
				if (CadenaDeCaracteres.charAt(0)=='"'){
					for(int i=0;i<CadenaDeCaracteres.length();i++){
					Character posicion = CadenaDeCaracteres.charAt(i);
					if (!(posicion=='"') && !(posicion=='.')){NuevaCadena = NuevaCadena + Character.toString(posicion);}
				}
				CadenaDeCaracteres = NuevaCadena;
				NuevaCadena = "";
				for(int i=0;i<CadenaDeCaracteres.length();i++){
					Character posicion = CadenaDeCaracteres.charAt(i);
					if (i==0){NuevaCadena =NuevaCadena + Character.toString(posicion);}
					else {NuevaCadena =NuevaCadena +"|(" + Character.toString(posicion);Parentesis=Parentesis + ")";}
				}
				NuevaCadena = NuevaCadena + Parentesis;
				Postfix post = new Postfix();
				String Postfix = post.infixToPostfix(NuevaCadena);
				NuevaCadena=Postfix;
				}else {NuevaCadena = CadenaDeCaracteres;}
		return CreateAFN(NuevaCadena);
	}



	
}