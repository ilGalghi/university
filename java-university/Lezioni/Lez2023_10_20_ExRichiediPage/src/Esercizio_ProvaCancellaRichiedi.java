import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Esercizio_ProvaCancellaRichiedi {

    public static void main(String[] args) {
        System.out.println("EX FINESTRA:");

        try {
            Socket socket = new Socket("www.google.com", 80);
            System.out.println("Connessione stabilita con Google inziale"); // se stabilita

            JFrame frame = new JFrame("Web Access App");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crea i componenti dell'interfaccia utente
            JTextArea urlField = new JTextArea();
            // Etichetta al centro della pagina
            JLabel resultLabel = new JLabel("Etichetta al centro");
            resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(resultLabel, BorderLayout.CENTER);
            
            JButton provaButton = new JButton("Prova");
            JButton cancellaButton = new JButton("Cancella");
            JButton richiediButton = new JButton("Richiedi");

            Listener risp = new Listener(urlField, resultLabel);
            provaButton.addActionListener(risp);

            Listener risp2 = new Listener(urlField, resultLabel);
            cancellaButton.addActionListener(risp2);

            Listener risp3 = new Listener(urlField, resultLabel);
            richiediButton.addActionListener(risp3);

            // Aggiungi i componenti al frame
            frame.setLayout(new BorderLayout());
            frame.add(urlField, BorderLayout.NORTH);
            frame.add(resultLabel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(provaButton);
            buttonPanel.add(cancellaButton);
            buttonPanel.add(richiediButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            

            // frame.pack();
            frame.setLocationRelativeTo(null); // Imposta la posizione al centro dello schermo
            frame.setVisible(true);
            System.out.println("FINE");

        } catch (UnknownHostException e) {
            throw new RuntimeException("SITO NON RISPONDE");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
