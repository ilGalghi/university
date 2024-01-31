import java.util.GregorianCalendar;


class Persona{
	String nome;
	int nascita;
	
    // Calcola l'età della persona	
	int eta() {
    int corrente;
    GregorianCalendar cal = new GregorianCalendar();
    corrente = cal.get(GregorianCalendar.YEAR);						//corrente = new Date().getYear()+1900;			//deprecato, utilizzare gregorianCalendar
    return corrente - this.nascita;
}

	// Stampa il nome e l'anno di nascita della persona
	void stampa() {
		System.out.println(this.nome + " " + this.nascita);
	}
	
}

class Studente extends Persona{
	int matricola;
}

class Professore extends Persona{
	String Falcolta;
	
}

class StudenteLavoratore extends Studente{
	String Datore;
}



public class Principale {
	// Calcola l'età di una persona dato l'oggetto Persona
	static int eta(Persona p) {
		GregorianCalendar cal = new GregorianCalendar();
   		int corrente = cal.get(GregorianCalendar.YEAR);			//corrente = new Date().getYear()+1900;
    	return corrente - p.nascita;
	}

	public static void main(String[] args) {
		//StringBuffer b = new StringBuffer();					//variabile "b" non in uso
		
		// Creazione di un oggetto Persona
		Persona p = new Persona();
		p.nome = "Lucia";
		p.nascita = 1992;
		p.stampa();
		System.out.println(p.eta());		//1 metodo
		System.out.println(eta(p));			//2 metodo
		
		Studente s = new Studente();
		s.nome = "Mario";
		s.nascita = 2000;
		s.matricola = 2084999;
		
		s.stampa();
		System.out.print(s.nome + " con Matricola: " + s.matricola);
		
		// Creazione di un array di oggetti Persona
		Persona a[];
		a = new Persona[3]; 	// Ci sono 3 oggetti nell'array
	    a[0] = p; 				// Il primo oggetto è Lucia (riferimento all'oggetto p)
	    a[1] = s;
		a[1] = s;
								// 'a[2] = "abcd";' dà errore:stringa non funziona perché è array è di tipo Persona
		
		
		// ATTENZIONE:
		// Studente può andare in Persona ignorando la matricola e perché è un tipo di persona
		// → Persona non può andare in Studente perché non trovando la matricola va in errore.
		
		
		
	}

}
