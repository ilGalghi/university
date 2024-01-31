package esercizio;

import java.net.*;
import java.util.*;
import javax.swing.*;

public class lettura implements Runnable {
    Finestra finestra;
    Socket socket;

    // Variabili statiche per i componenti GUI
    static JTextArea logTextArea; //(t1)
    static JTextArea pdfTextArea;
    static JTextArea mp3TextArea;
    static JTextArea totalSizeField;

    static JButton connectButton;
    static JButton disconnectButton;
    static JButton startButton;
    static JButton stopButton;
    static JButton clearButton;

    static Scanner leggi;

    String[] c = new String[3];
    String[] b = new String[3];
    String[] d = new String[3];

    static double dim;

    // Costruttore che riceve la finestra principale come argomento
    lettura(Finestra finestra2) {
        this.finestra = finestra2;
    }

    @Override
    public void run() {
        try {
            while (leggi.hasNextLine()) {
                String l = leggi.nextLine();

                // Gestione dei messaggi ricevuti
                if (l.equals("INTERRUPTED")) {
                    System.out.println("ho letto: " + l);
                    return;
                } else if (l.equals("END")) {
                    disconnectButton.setEnabled(true);
                    startButton.setEnabled(true);
                    clearButton.setEnabled(true);
                    stopButton.setEnabled(false);
                    System.out.println("ho letto: " + l);
                    return;
                }

                System.out.println("ho letto: " + l);

                // Analisi dei messaggi ricevuti e visualizzazione nelle rispettive aree di testo
                c = l.split(":");
                b = c[1].split("\\.");
                d = c[2].split(" ");
                
                System.out.println("C0: " + c[0]);
                System.out.println("C1: " + c[1]);
                System.out.println("C2: " + c[2]);
                
                System.out.println("B0: " + b[0]);

                if (c[0].equals("PDF")) {
                    pdfTextArea.append(b[0] + "\n");
                } else if (c[0].equals("MP3")) {
                    mp3TextArea.append(b[0] + "\n");
                }
                logTextArea.append(c[1] + " " + c[2] + "\n");

                // Calcolo della dimensione totale
                dim += Double.valueOf(d[0]);
                totalSizeField.setText(Double.toString(dim) + " KB");

                Thread.sleep(10); // Attende 10 millisecondi
            }
        } catch (InterruptedException e1) {
            return; // Esce in caso di interruzione
        }
    }
}
