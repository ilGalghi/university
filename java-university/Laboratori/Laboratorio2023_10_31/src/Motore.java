import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;


public class Motore implements ActionListener {
	JButton scarica, interrompi, visualizza, attendi;
	
	
	 public Motore(JButton scarica, JButton interrompi, JButton visualizza, JButton attendi) {
	        this.scarica = scarica;
	        this.interrompi = interrompi;
	        this.visualizza = visualizza;
	        this.attendi = attendi;   
    }

	@Override
	public void actionPerformed(ActionEvent e) {

		// AZIONE PULSANTE "SCARICA"
		if (e.getActionCommand().equals("scarica")) {
			try {
				Socket socket = new Socket("127.0.0.1", 8080);
                socket.setSoTimeout(10000); // Timeout di 10 secondi

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                Scanner reader = new Scanner(socket.getInputStream());

                String firstResponse = reader.nextLine();
                System.out.println("Prima risposta dal server: " + firstResponse);

                // Invio di un numero (esempio: "2")
                writer.println("2");
                writer.flush();

                try {
                    if (reader.hasNextLine()) {
                        String response = reader.nextLine();
                        System.out.println("Risposta dal server: " + response);
                    } else {
                        System.out.println("Errore di scaricamento");
                    }
                } finally {
                    scarica.setEnabled(true);
                    socket.close(); // Chiude la connessione
                }
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (SocketTimeoutException e2) {
                System.out.println("Timeout");
            } catch (IOException e3) {
                e3.printStackTrace();
            } finally {
                scarica.setEnabled(true);
            }
        }
		
		
		
		//PULSANTE INTERROMPI
		if (e.getActionCommand().equals("interrompi")) {
			
		}
		
		
		
		
		
		//PULSANTE VISUALIZZA
		if (e.getActionCommand().equals("visualizza")) {
					
		}
		
		
		
		
		
		//PULSANTE ATTENDI
		if (e.getActionCommand().equals("attendi")) {
					
		}
	}

}
