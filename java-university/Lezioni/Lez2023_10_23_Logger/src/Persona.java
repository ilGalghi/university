public class Persona extends Object{
	String nome;
	int nascita;
	public Persona(String nome, int nascita){
		this.nome = nome;
		this.nascita = nascita;
	}
	
	@Override  
	public boolean equals(Object o) {  
		if (o == null) return false;
		if (o.getClass() != this.getClass())
			return false;
		Persona p = (Persona) o; 
		return this.nome.equals(p.nome) && this.nascita == p.nascita;
	}

	

}
