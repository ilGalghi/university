package com.uni.lezione2909;
import java.util.GregorianCalendar;


public class Persona {
	String nome;
	int nascita;
	
	public Persona(String n, int nas) {
		this.nome = n;
		if (nas==0) {
			System.out.println("errore");
		}
		else {
			this.nascita = nas;
		}
	}
	
	void stampa() {
		System.out.println(this.nome + " " + this.nascita);
	}
	
	public String toString() {
		return this.nome + " " + this.nascita;
	}
	
	int eta() {
	    int corrente;
	    GregorianCalendar cal = new GregorianCalendar();
	    corrente = cal.get(GregorianCalendar.YEAR);						//corrente = new Date().getYear()+1900;			//deprecato, utilizzare gregorianCalendar
	    return corrente - this.nascita;
	}
	
	//vedere iterator
	
	
}
