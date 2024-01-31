import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Interface_Daniele {

    private JFrame frame;
    private PrintWriter writer;
    private JLabel label;
    private Scanner input;
    Scanner reader;
    private MyThread thread;
    Socket socket;
    JButton button1, buttonWait;
    String response = "";
    MyThread2 thread2;

    // Avvia l'applicazione
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Interface_Daniele window = new Interface_Daniele();
                    window.frame.setVisible(true); // Mostra la finestra dell'applicazione
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Costruisce l'applicazione e inizializza il frame.
     */
    public Interface_Daniele() {
        initialize(); // Metodo per inizializzare il frame
    }

    /**
     * Inizializza il contenuto del frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiude l'applicazione quando si preme il tasto di chiusura

        JPanel panel = new JPanel(new BorderLayout()); // Crea un pannello con layout BorderLayout

        button1 = new JButton("scarica"); // Pulsante per avviare il download
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea un nuovo thread e avvia il download
                thread = new MyThread();
            }
        });

        JButton button2 = new JButton("interrompi"); // Pulsante per interrompere il download
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Interrompe il download se attivo
                if (thread2 != null && thread != null)
                    if (thread2.getState() == Thread.State.TIMED_WAITING) {
                        try {
                            socket.close(); // Chiude il socket
                            thread2.interrupt(); // Interrompe il thread di download
                            System.out.println("socket interrotto");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
            }
        });

        JButton button3 = new JButton("visualizza"); // Pulsante per visualizzare lo stato dei thread
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Visualizza lo stato dei thread
                if (thread2 != null && thread != null)
                    System.out.println("stato thread in esec: Thread1 : " + thread.getState().toString() + "\n"
                            + "Thread2 : " + thread2.getState().toString());
            }
        });

        buttonWait = new JButton("attendi"); // Pulsante per attendere il download
        buttonWait.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Disabilita il pulsante di download se il thread di download è in attesa
                if (thread2 != null && thread != null)
                    if (thread2.getState() == Thread.State.TIMED_WAITING) {
                        button1.setEnabled(false); // Disabilita il pulsante di download
                    }
            }
        });

        panel.setLayout(new GridLayout(1, 4)); // Griglia orizzontale con 1 riga e 4 colonne

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonWait);

        frame.getContentPane().add(panel); // Aggiunge il pannello al frame
        frame.setVisible(true); // Mostra il frame
    }

    // Connessione al server utilizzando un socket
    private void connect(String urlString) {

        try {
            socket = new Socket(urlString, 8080); // Connette il socket al server
            reader = new Scanner(socket.getInputStream()); // Prepara il reader per leggere dati dal socket

            if (reader.hasNextLine()) {
                String response = reader.nextLine(); // Legge la risposta dal server
                System.out.println("risposta ricevuta : " + response); // Stampa la risposta ricevuta

                writer = new PrintWriter(socket.getOutputStream()); // Prepara il writer per inviare dati al server tramite il socket

                writer.println("3"); // Invia "3" al server
                writer.flush(); // Assicura che i dati siano inviati
                thread2 = new MyThread2(); // Crea un nuovo thread di attesa
                thread2.start(); // Avvia il thread

                if (reader.hasNext()) {
                    thread2.stop(); // Interrompe il thread di attesa
                    response = reader.nextLine(); // Legge la risposta dal server

                    if (thread2.getState() == Thread.State.RUNNABLE) {
                        System.out.println("Msg ricevuto dopo timeout : " + response); // Stampa la risposta ricevuta dopo il timeout
                    } else {
                        System.out.println("Msg ricevuto prima timeout : " + response); // Stampa la risposta ricevuta prima del timeout
                    }

                    button1.setEnabled(true); // Abilita il pulsante di download
                } else {
                    System.out.println("niente ricevuto"); // Stampa un messaggio se non viene ricevuta alcuna risposta
                }
            }

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Connessione non stabilita"); // Stampa un messaggio se la connessione non è stabilita
            e1.printStackTrace();
        }
    }

    // Thread per il download
    class MyThread implements Runnable {
        Thread t;

        public MyThread() {
            t = new Thread(this);
            t.start(); // Avvia il thread
        }

        @Override
        public void run() {
            connect("localhost"); // Avvia la connessione al server
        }

        // Restituisce lo stato del thread
        public Thread.State getState() {
            return t.getState(); // Restituisce lo stato del thread
        }
    }
}

// Thread per l'attesa
class MyThread2 extends Thread {

    public MyThread2() {
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000); // Attende per 1 secondo
            } catch (InterruptedException e1) {
                System.out.println("thread2 interrotto."); // Stampa un messaggio se il thread di attesa è interrotto
                break;
            }
            System.out.println("attendo . . ."); // Stampa un messaggio di attesa
        }
    }
}
