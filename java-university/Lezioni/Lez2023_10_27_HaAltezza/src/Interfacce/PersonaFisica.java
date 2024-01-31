package Interfacce;

public class PersonaFisica extends Persona implements HaAltezza{
	String nome;
	int altezza;
	
	PersonaFisica(String n, int alt) {
		this.nome = n;
		this.altezza = alt;
	}

	
	public int getAltezza() {
		return this.altezza ;
	}
}