//CLIENT
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("CLIENT:");

        // Creazione di un socket per connettersi al server sulla porta 8080
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connessione stabilita");

        // Prepara un writer per inviare dati al server tramite il socket
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        // Invia una richiesta al server
        writer.println("Richiesta di informazione al server");
        writer.flush(); // Assicura che i dati siano inviati

        // Prepara un reader per leggere la risposta dal server tramite il socket
        Scanner reader = new Scanner(socket.getInputStream());

        // Controlla se c'è una linea da leggere nella risposta del server
        if (reader.hasNextLine()) {
            String serverResponse = reader.nextLine();
            System.out.println("Risposta dal server: " + serverResponse);
        }

        // Chiude la connessione con il server
        socket.close();
        System.out.println("FINE");
    }
}






/*
public class Main {
	public static void main(String[] args) 
		throws UnknownHostException, IOException {
		System.out.println("RICEVE:");
		
		
		Socket socket;				//crea variabile, una presa
		//socket = new Socket("www.google.com", 80);			//80 collegamento ad HTTP
		socket = new Socket("localhost", 8080);				//se chiamo su stesso PC non seeve specificare
		
		//opzioni lettura e scrittura
		System.out.println("Connessione stabilita");
		
		//SCRITTURA
		PrintWriter scrivi = new PrintWriter(socket.getOutputStream());
		scrivi.print("GET /\r\n\r\n");
		scrivi.flush();						//invia dati
		
		//LETTURA
		Scanner leggi = new Scanner(socket.getInputStream());
		
		// ##############################
		while(leggi.hasNextLine()) {
			String s = leggi.nextLine();				//stringa s
			System.out.println("ho letto: " + s);		//print delle info ricevute
		}
		// ##############################
		
		String s = leggi.nextLine();				//stringa s
		System.out.println("ho letto: " + s);		//print delle info ricevute
		
		PrintWriter scrivi2;
		scrivi2 = new PrintWriter(socket.getOutputStream());
		scrivi2.println("risposta");
		scrivi2.flush();
		
		socket.close();
		System.out.println("FINE");
	}
}

*/