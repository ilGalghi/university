import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class MyWindow extends JFrame {

    JButton downloadButton, interruptButton, viewThreadsButton, waitButton;
    boolean isDownloading = false;
    Thread downloadThread = null;

    public MyWindow() {
        super("Esercizio Thread");

        downloadButton = new JButton("Scarica");
        downloadButton.addActionListener(new DownloadListener());

        interruptButton = new JButton("Interrompi");
        interruptButton.addActionListener(new InterruptListener());
        interruptButton.setEnabled(false);

        viewThreadsButton = new JButton("Vedi Threads");
        viewThreadsButton.addActionListener(new ViewThreadsListener());

        waitButton = new JButton("Attendi");
        waitButton.addActionListener(new WaitListener());
        waitButton.setEnabled(true);

        JPanel panel = new JPanel();
        panel.add(downloadButton);
        panel.add(interruptButton);
        panel.add(viewThreadsButton);
        panel.add(waitButton);

        
        add(panel, BorderLayout.CENTER);
        //setSize(500, 100);	     // Metto la grandezza
        pack();						 // Grandezza predefinita
        setLocationRelativeTo(null); // Centra la finestra rispetto allo schermo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        System.out.println("Creato pannello");
    }

    // Listener per il pulsante di download
    class DownloadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            downloadButton.setEnabled(false);
            interruptButton.setEnabled(true);
            waitButton.setEnabled(false);

            // Creazione di un nuovo thread per la gestione del download
            downloadThread = new Thread(() -> {			//è una sintassi di Java 8 per creare un nuovo thread usando un'espressione lambda.
            											//In particolare, la sintassi ( ) -> { ... } è nota come una lambda expression, introdotta in Java 8.
            											//Questa è una forma concisa di definizione di un'interfaccia funzionale
            											//in questo caso, viene utilizzata per implementare il comportamento del thread.
            											//Una volta creato il thread, può essere avviato tramite il metodo start() come "downloadThread.start();"
                try {
                    isDownloading = true;
                    Socket socket = new Socket("127.0.0.1", 8080);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    // Riceve la prima stringa dal server
                    String response = in.readLine();
                    System.out.println("Risposta dal server: " + response);

                    // Invia un numero al server
                    out.println("5");

                    // Imposta il timeout a 10 secondi
                    socket.setSoTimeout(10000);

                    try {
                        // Riceve la risposta entro il timeout
                        response = in.readLine();
                        if (response != null) {
                            System.out.println("Risposta ricevuta: " + response);
                        } else {
                            System.out.println("Timeout");
                        }
                    } catch (IOException ex) {
                        System.out.println("Errore di scaricamento o timeout");
                    }

                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Errore durante la connessione al server");
                } finally {
                    isDownloading = false;
                    downloadButton.setEnabled(true);
                    interruptButton.setEnabled(false);
                    waitButton.setEnabled(true);
                }
            });

            // Avvia il thread per il download
            downloadThread.start();
            
        }
    }

    // Listener per il pulsante di interruzione del download
    class InterruptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isDownloading) {
                // Interrompe il thread di download se è attivo
                if (downloadThread != null) {
                    downloadThread.interrupt();
                }
                System.out.println("Download interrotto");
                isDownloading = false;
                downloadButton.setEnabled(true);
                interruptButton.setEnabled(false);
            }
        }
    }

    // Listener per il pulsante "Visualizza Thread"
    class ViewThreadsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Visualizza i thread attualmente in esecuzione
            System.out.println("Stato del Thread Download: " + downloadThread.getState().toString());
        }
    }

    // Listener per il pulsante "Wait"
    class WaitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isDownloading) {
                // Attendere che il download sia completato
                if (downloadThread != null) {
                    try {
                        downloadThread.join();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            waitButton.setEnabled(true);
        }
    }

    // Metodo main per l'avvio dell'applicazione Swing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyWindow());			//istruzione in Java Swing utilizzata per garantire che la creazione
        															//e la visualizzazione di una finestra Swing avvengano all'interno del thread dell'interfaccia grafica (Event Dispatch Thread, EDT)
    }
}
