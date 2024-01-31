//scrivere un metodo che si connette a un sito web socket indirizzo + porta 80

//se non risponde, non andare avanti con gli altri siti

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Eccezioni {
	static void connetti(String indirizzo) {
		System.out.println();
		System.out.println("Connetto a " + indirizzo);
		
		try {									//deciso come trattare l'errore
			Socket s = new Socket(indirizzo, 80);
			System.out.println("CONNESSO");		//stampa se connesso e la socket non dà errore
		}
		catch (UnknownHostException e) {	//posso metterlo in throw nel main e nel "connetti" (e non specificare)
			System.out.println("indirizzo inesistente");
			
		}
		catch (IOException e) {				//posso metterlo in throw nel main e nel "connetti" (e non specificare)
			System.out.println("non risponde");
			throw new RuntimeException("SITO NON RISPONDE");		//creo io l'eccezione in Runtime: fermo il programma
			
		}
		System.out.println("-----------");		//viene eseguita comunque anche se dà errore
	}
	
	public static void main (String[] args) {
		connetti("www.google.com");
		connetti("localhost");
		connetti("abcd");
		System.out.println("FINE PROGRAMMA");
	}
	
	
}
