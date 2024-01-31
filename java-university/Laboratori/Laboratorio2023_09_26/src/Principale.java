//01
//creare nostra classe

class Persona{
	String nome;
	int nascita;
}

public class Principale{
	public static void main(String[] args) {
		String s;
		Persona p;
		p = new Persona();
		
		
		//inserire valori
		
		p.nome = "Francesco";
		p.nascita = 2000;
		
		System.out.println(p.nome + p.nascita);
		
		//fare altro progetto Persona
		//metterli in un array di persone
		//stampare l'array con un ciclo
		
		Persona q = new Persona();			//creo e alloco classe Persona
		q.nome = "Luca";
		q.nascita = 1999;
		
		Persona[] g = new Persona [2];		//creo e alloco array di dimensione 2
		g[0] = p;
		g[1] = q;
		
		for (int i=0; i<2; i++) {			//pure per i<=g.length (lunghezza dell'array)
			System.out.println(g[i].nome + " " + g[i].nascita);
			
		}
		
	}
}
