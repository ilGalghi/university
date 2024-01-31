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
		Persona p = (Persona) o;
		return this.nome.equals(p.nome);
	}
	
}


class Coppia <Persona,String>{
    Object primo;
    Object secondo;

    Coppia(Persona primo, String secondo){
        this.primo = primo;
        this.secondo = secondo;
    }
}