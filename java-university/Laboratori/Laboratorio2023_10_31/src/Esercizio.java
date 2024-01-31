import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class Esercizio {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Web Access App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton scarica = new JButton("scarica");
        JButton interrompi = new JButton("interrompi");
        JButton visualizza = new JButton("visualizza");
        JButton attendi = new JButton("attendi");

        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(scarica);
        buttonPanel.add(interrompi);
        buttonPanel.add(visualizza);
        buttonPanel.add(attendi);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Aggiungi il listener al pulsante "scarica"
        scarica.addActionListener(new Motore(scarica, interrompi, visualizza, attendi));
        interrompi.addActionListener(new Motore(scarica, interrompi, visualizza, attendi));
        visualizza.addActionListener(new Motore(scarica, interrompi, visualizza, attendi));
        attendi.addActionListener(new Motore(scarica, interrompi, visualizza, attendi));

        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la finestra rispetto allo schermo
        frame.setVisible(true);
        System.out.println("Creato pannello");
    }
}


/*
esercizio sui thread
realizzare una finestra con quattro pulsanti:

scarica:
	disattiva il pulsante scarica (vedere api JButton)
	si connette a Server.java, indirizzo 127.0.0.1, porta 8080
	riceve una prima stringa dal server
	invia un numero
	se la risposta non arriva entro dieci secondi, interrompe la connessione per timeout
	stampa su console la prima linea della risposta, oppure "errore di scaricamento" oppure "timeout" oppure "scaricamento interrotto"
	riattiva il pulsante scarica

interrompi:
	solo nel caso in cui il programma stia attualmente cercando si scaricare la pagina, lo interrompe

visualizza:
	mostra su console lo stato di tutti i thread attualmente in esecuzione
	
attendi:
	disattiva il pulsante attendi fino a quando lo scaricamento non e' terminato, sempre che ci sia uno scaricamento in corso
	verificare che tutte le eccezioni siano state catturate (nessuna eccezione deve produrre una stampata rossa su console)

Server.java (vedere istruzioni all'interno)
*/