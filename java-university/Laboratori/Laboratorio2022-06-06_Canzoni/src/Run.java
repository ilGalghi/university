import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Run implements Runnable {
	Finestra finestra;
	String s;
	public Scanner leggi;
	public Socket socket;
	public JButton artistaButton;
	public JButton disconnectButton;
	public JButton stopButton;
	public JTextArea logTextArea;
	public JButton canzoniButton;
	String[] c = new String[3];
	String b = new String();
	public JTextArea artistaTextArea;
	private Map<String, String> inizialiNomi = new HashMap<>(); // Spostato fuori dal metodo run()

    Run(Finestra finestra){
        this.finestra = finestra;
    }

    @Override
    public void run() {
        while(leggi.hasNextLine()) {
            s = leggi.nextLine();    //e fai ciò che viene richiesto
            
            if (s.equals("END")){
                disconnectButton.setEnabled(true);
                stopButton.setEnabled(false);
                return;
            }
            
            logTextArea.append(s + "\n");
            
            if (s.startsWith("ARTISTA")) { // Se la stringa inizia con "ARTISTA"
                String[] partiArtista = s.split(":");
                String nomeCompleto = partiArtista[1].trim();
                String iniziale = calcolaIniziali(nomeCompleto);
                inizialiNomi.put(iniziale, nomeCompleto);
                canzoniButton.setEnabled(true);
            }
            
            if (s.startsWith("CANZONE")) { // Se la stringa inizia con "CANZONE"
                c = s.split(":");
                String canzone = c[2].trim(); // Ottieni il nome della canzone dalla stringa
                
                // Cerca l'artista associato alla canzone
                String nomeCompleto = inizialiNomi.get(c[1]);
                if (nomeCompleto != null) {
                    artistaTextArea.append(nomeCompleto + " - " + canzone + "\n");
                }
            }
        }
        canzoniButton.setEnabled(false);

        
    }


	public static String calcolaIniziali(String nomeCompleto) {
	    String[] partiNome = nomeCompleto.split(" ");
	    StringBuilder iniziali = new StringBuilder();

	    for (String parte : partiNome) {
	        iniziali.append(parte.charAt(0));
	    }

	    return iniziali.toString();
	}

}