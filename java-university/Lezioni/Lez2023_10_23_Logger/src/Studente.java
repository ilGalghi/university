public class Studente extends Persona{
	int matricola;
	Studente(String nome, int nascita, int matricola) {
		super(nome, nascita);
		this.matricola =matricola;
	}
	@Override  
	public boolean equals(Object o) {  
		if (! super.equals(o)) return false;
		Studente s = (Studente) o;
		
		return this.matricola == s.matricola;
	}  //basta il cast e la verifica degli elementi aggiuntivi
	
	@Override 
	public String toString() {
		return "";
	}
	
	@Override
	public Object clone() {
		return null;
	}
	

}
