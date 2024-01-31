import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class server {

	public static void main(String[] args) throws IOException {
		System.out.println("SERVER:");

        // ASCOLTA CONNESSIONI:
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Aperto");
        
        Socket socket = server.accept();		//accetta la richiesta
        
        // LEGGERE
        Scanner leggi = new Scanner(socket.getInputStream());
        
        //CREO ARRAY DI NUMERI CASUALI
        ArrayList<Integer> nums =  new ArrayList<Integer>();		//array modificabile
    	Random random = new Random();								//oggetto random
    	int primo = random.nextInt(1,11);							//numero random tra 1 e 10
    	String s = primo + "";										//converto il numero "primo" in una stringa e lo assegno a "s".
    	nums.add(primo);											//aggiungo il numero "primo" all'ArrayList "nums".

    	for (int i= 0; i<4; i++) {									//itero 4 volte per generare ulteriori numeri casuali.
    		int j  = random.nextInt(11)  ;							//genero un nuovo numero casuale tra 0 e 10 e lo assegno a "j".
    		s = s + " " +  j;										//aggiungo il numero "j" alla stringa "s", separato da spazi.
    		nums.add(j);											//aggiungo il numero "j" all'ArrayList "nums".
    	}
    	
    	//LEGGI MESSAGGIO DAL CLIENT
    	while (leggi.hasNextLine()) {								// Continua a leggere linee inviate dal client finché sono disponibili
    	    String cliente = leggi.nextLine();						// Legge la linea inviata dal client e la memorizza nella variabile "cliente"
    	    System.out.println(cliente);							// Stampa la linea ricevuta dal client sulla console del server

    	    if (cliente.equals("carte")) {								// Verifica se la linea ricevuta dal client è uguale a "carte"
    	        PrintWriter scrivi = new PrintWriter(socket.getOutputStream());		// Crea un oggetto PrintWriter per inviare dati al client utilizzando l'output del socket
    	        scrivi.println(s);										// Invia i numeri casuali (rappresentati da "s") al client
    	        scrivi.flush();										 	// Assicura che i dati siano inviati immediatamente

    	        break;													// Esce dal ciclo while, poiché l'operazione è completata
    	    }
    	    else {
    	        
    	        System.out.println("errore");							// Se la linea ricevuta dal client non è "carte", stampa "errore" sulla console del server
    	    }
    	}

	
		PrintWriter scrivi = new PrintWriter(socket.getOutputStream());	// Crea un PrintWriter per inviare dati al client
    	
    	//LEGGI MESSAGGIO SUCCESSIVO DEL CLIENT
		String cambioclient;											// Stringa del cambio da parte del client
		if (leggi.hasNextLine()) {										// Controlla se ci sono ulteriori linee disponibili inviate dal client
		    cambioclient = leggi.nextLine();							// Legge la prossima linea inviata dal client e la memorizza in "cambioclient"
		    
		    System.out.println(cambioclient);							// Stampa la linea ricevuta sulla console del server
		    
		    //DIVIDE MESSAGGIO DEL CLIENT
		    String[] scelte = cambioclient.split("cambio ");			// Divide il messaggio per estrarre le scelte del cliente (toglie "cambio ")
		    scelte = scelte[1].split(" ");								// Estrae le scelte del cliente dividendo la stringa in base agli spazi
		   
		    //System.out.println(scelte[0] + " " + scelte[1]+ " " + scelte[2]);	
		    
		    //GENERA NUOVI NUMERI
		    for (int i = 0; i < scelte.length; i++) {					// Genera nuovi numeri casuali e li sostituisce nelle posizioni scelte dal cliente
		        primo = random.nextInt(11) + 1;							// Genera un nuovo numero casuale tra 1 e 10
		        nums.set(Integer.valueOf(scelte[i]) - 1, primo);		// Sostituisce il numero nell'array "nums" nella posizione specificata dal cliente 
		    }

		    // NUOVA STRINGA CON NUOVI NUMERI
		    String numeri = String.valueOf(nums.get(0));
		    for (int i = 1; i < nums.size(); i++) {						// Costruisce una stringa contenente i nuovi numeri casuali separati da spazi
		        numeri += " " + nums.get(i); 
		    }

		    // INVIA I NUOVI NUMERI
		    scrivi.println(numeri);			// Invia la stringa contenente i nuovi numeri casuali al client
		    scrivi.flush();
		}
		else {
		    scrivi.println("errore");		// Se non viene ricevuto un messaggio corretto, invia "errore" al client
		    scrivi.flush();
		    
		}

		socket.close();						// Chiude il socket    	  	
	}
}




