public class Persona2{
	String nome;
	Persona2(String n, int i){
		this.nome = n;
		}
	
	int nascita;
	Persona2(int nas){
		this.nascita = nas;
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