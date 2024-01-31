package com.uni.lezione2909;
import java.util.Date;

public class Principale {
	public static void main(String[] args) {
		Persona p;
		p = new Persona("Mario", 1993);
		p.stampa();
		
		Studente s = new Studente("Marta",1999,1234567);
		
		System.out.println(p);			//invoca le string a "toString", che è uguale a "System.out.println(p.toString());"
		System.out.println(s);			//funziona ma non con la matricola perché definito per la persona (se non lo creo anche in studente)
	
		Object o = new Object();		//definisco oggetto (che poi può essere convertito)
		o = new Date();
		System.out.println(o);			//qualsiasi cosa può essere un oggetto
	
	}
	
}
