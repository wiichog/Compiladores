public class Estado{
		
		int Identificador;
		boolean Marcado;
		
		public void Estado(){
			Identificador = 0;
		}
		
		public void SetIdentificador(int Identificador){
			this.Identificador = Identificador;
		}
		
		public int GetIdentificador(){
			return Identificador;
		}
		
		public void SetMarcado(boolean Marcado){
			this.Marcado = Marcado;
		}
		
		public boolean GetMarcado(){
			return Marcado;
		}
		
	}