import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("SERVER:");

        // Crea un oggetto ServerSocket che ascolta sulla porta 8080 per le connessioni in ingresso.
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Aperto");

        while (true) {
            System.out.println("Aspetto chiamata");

            // Accetta una connessione da un client quando viene effettuata una chiamata.
            Socket socket = server.accept();
            System.out.println("Connessione stabilita con " + socket);

            // Prepara un reader per leggere dati in arrivo dal client attraverso il socket.
            Scanner reader = new Scanner(socket.getInputStream());

            if (reader.hasNextLine()) {
                // Leggi il messaggio inviato dal client.
                String clientMessage = reader.nextLine();
                System.out.println("Messaggio dal client: " + clientMessage);

                // Esempio di elaborazione del messaggio - qui, il server invia una risposta basata sulla richiesta del client.
                String response = "Risposta al messaggio: " + clientMessage;

                // Prepara un writer per inviare la risposta al client attraverso il socket.
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                // Invia la risposta al client.
                writer.println(response);
                writer.flush();
            }

            // Chiude la connessione con il client corrente.
            socket.close();
        }

        // Il server non viene chiuso all'interno del ciclo while.
        //server.close();
    }
}




/*
 * import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server {

	public static void main(String[] args) 
			throws IOException {				//è dichiarato come in grado di generare un'eccezione di tipo IOException.
												//Ciò avviene perché il metodo potrebbe comportare operazioni di I/O (input/output) che potrebbero sollevare eccezioni,
												//come ad esempio errori di connessione di rete o problemi di lettura/scrittura.
		System.out.println("SERVER:");
		
		
		ServerSocket server;		//creo Server
		server = new ServerSocket(8080);
		System.out.println("Aperto");
		
		Socket socket;
		
		//con while true ascolta all'infinito
		
		
		
		System.out.println("Aspetto chiamata");
		socket = server.accept();
		
		System.out.println(socket);

		server.close();
	}

}
*/
