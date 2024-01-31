//VALORI STATICI

class Auto{
	String targa;
	int seriale;
	static int precedente = 0;				//c'è una sola variabile per tutta la classe
	Auto(String targa){
		this.targa = targa;
		this.seriale = ++precedente;
	}
	
	public String toString() {				//per il return come stringa
		return targa + " " + seriale;
	}
	
	//posso definire metodi statici
	static void incrementa() {				//se voglio saltare un numero (aumento seriale)
		precedente++;
	}
}

//avvio: invoca Main.main(::)
public class Main4 {
	public static void main(String[] args) {			//il main è statico (per convenzione)
														//volendo, in run configuration, posso aggiungere degli argomento pre-stampa
		
		Auto a = new Auto("GH456JK");
		Auto b = new Auto("HK868JJ");
		Auto c = new Auto("AX897KO");
		
		System.out.println(a.targa);		//stampa solo targa
		System.out.println(b);
		System.out.println(c);
		Auto.incrementa();
		System.out.println(Auto.precedente);	//incrementa il precedente di 1
	}

}
