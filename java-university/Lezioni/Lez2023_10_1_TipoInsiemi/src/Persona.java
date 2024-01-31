public class Persona{
	String nome;
	Persona(String n){
		this.nome = n;
		}
	
	

	@Override
	public boolean equals(Object o){
		if (o.getClass() != this.getClass()){
			return false;
		}
		Persona2 p = (Persona2) o;
		return this.nome.equals(p.nome);
	}
	
}