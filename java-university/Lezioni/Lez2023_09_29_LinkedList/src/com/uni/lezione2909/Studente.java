package com.uni.lezione2909;
class Studente extends Persona{

	int matricola;

	public Studente(String n, int nas, int matricola) {
		super(n, nas);		//richiamo costruttore persona
		
		this.matricola = matricola;		//this riferita a questa classe (studente)
	}
	
	public String toString() {
		return this.nome + " " + this.nascita + " " + this.matricola;
	}

}
