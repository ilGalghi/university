import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client_mio {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("CLIENT SERVER MIO:");

        // Creazione di un socket per connettersi al server sulla porta
        Socket socket = new Socket("", 8080);		
        System.out.println("Connessione stabilita");
        
        //Invio
      	PrintWriter scrivi = new PrintWriter(socket.getOutputStream());
      	scrivi.println("carte");		//usare println, non print
      	scrivi.flush();						
      	System.out.println("Ho inviato carte");
      	
      	//Ricevi
      	Scanner leggi = new Scanner(socket.getInputStream());
      	
      	//Mostra
      	String s;
      	if(leggi.hasNextLine()) {
      		s = leggi.nextLine();
      		System.out.println("Ho letto: " + s);     
      	}
      	
      	//Numeri da cambiare
		System.out.print("Quali numeri cambiare? ");
		Scanner input = new Scanner(System.in);
		String numeri = input.nextLine();
		 
		 
		//Invio cambio
	    scrivi.println("cambio " + numeri);		//println e "cambio "
	    scrivi.flush();
		 
	    //Mostra cambio
		if(leggi.hasNextLine()) {
			s = leggi.nextLine();
			System.out.println("Risposta: " + s );
		}
		 
		System.out.println("Fine");
		socket.close();

	}

}
