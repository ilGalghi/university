import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Listener implements ActionListener {
    JTextArea urlField; // Riferimento al campo di testo per l'URL
    JLabel resultLabel; // Riferimento all'etichetta per i risultati

    public Listener(JTextArea urlField, JLabel resultLabel) {
        this.urlField = urlField;
        this.resultLabel = resultLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // AZIONE PULSANTE "Prova"
        if (e.getActionCommand().equals("Prova")) {
            try {
                Socket socket = new Socket(urlField.getText(), 80);
                Scanner input = new Scanner(socket.getInputStream());
                
                // Verifica se la connessione è riuscita o meno
                if (connect(urlField.getText()).equals("ok")) {
                    resultLabel.setText("Connessione riuscita");
                }
                
            } catch (UnknownHostException e1) {
                resultLabel.setText("Connessione non riuscita (UnknownHostException)");
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("Connessione non stabilita");
                resultLabel.setText("Connessione non riuscita (IOException)");
                e1.printStackTrace();
            }
        }

        // AZIONE PULSANTE "Cancella"
        if (e.getActionCommand().equals("Cancella")) {
            // Azione del pulsante "Cancella" che elimina il testo dall'etichetta dei risultati.
            resultLabel.setText("");
        }


        // AZIONE PULSANTE "Richiedi"
        if (e.getActionCommand().equals("Richiedi")) {
        	
        	resultLabel.setText("Vedi in console1"); 
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket();

            // Azione del pulsante "Richiedi" che invia una richiesta al server.
            if (!socket.isClosed()) {
                try {
                	resultLabel.setText("Vedi in console2"); 
                    Socket socket2 = new Socket(urlField.getText(), 80);
                    Scanner input = new Scanner(socket2.getInputStream());
                    PrintWriter writer = new PrintWriter(socket2.getOutputStream());

                    System.out.println("Inserisci pagina da richiedere: ");
                    writer.write("GET /" + scanner.nextLine() + "\r\n\r\n"); // Invia una richiesta HTTP GET
                    writer.flush();
                    System.out.println("Controlla risposta nella label");
                    if (input.hasNextLine()) {
                        resultLabel.setText("Risposta: \n" + input.nextLine());
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        

    }

    // Questo metodo tenta di stabilire una connessione e restituisce una stringa
    // "ok" se la connessione ha successo, o una stringa vuota in caso di errore.
    private String connect(String urlString) {
        Scanner reader;
        Socket socket;
        try {
            socket = new Socket(urlString, 80);
            reader = new Scanner(socket.getInputStream());
            return "ok"; // Connessione riuscita
            } catch (UnknownHostException e1) {
            e1.printStackTrace();
            return ""; // Connessione non riuscita
        } catch (IOException e1) {
            System.out.println("Connessione non stabilita");
            e1.printStackTrace();
            return ""; // Connessione non riuscita
        }
    }
}
