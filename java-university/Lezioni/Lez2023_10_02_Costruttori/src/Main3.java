//VALORI COSTRUTTORI STANDARD

class Persona {
	String nome;
	int nascita;
	Persona(String nome, int nascita){			//ogni costruttore serve "super"
		this.nome = nome;
		this.nascita = nascita;
	}
}

class Anziano extends Persona{				//VEDERE COSTRUTTORE VUOTO (non ha caratteristiche in più)
	//persona nata prima del 1955
	Anziano(String nome, int nascita){			
		super(nome, nascita);							//BISOGNA RIDEFINIRE COSTRUTTORE (con super)
		if (nascita >= 1955) {							
			throw new RuntimeException("non anziano");	//stampa come errore
		}
	}
	
}


public class Main3 {

	public static void main(String[] args) {
		Anziano a = new Anziano("Mario", 1980);
		System.out.println(a);

	}

}
