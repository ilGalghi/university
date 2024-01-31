import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClasseDaniele {

    private JFrame frame;
    private Socket socket;
    private PrintWriter writer;

    private Scanner input;

    /**
     * Metodo principale che avvia l'applicazione.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClasseDaniele window = new ClasseDaniele();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Costruttore della classe Interface.
     */
    public ClasseDaniele() {
        initialize();
    }

    /**
     * Inizializza i contenuti del frame dell'interfaccia.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Verifica la connessione a Internet prima di creare l'interfaccia grafica.
        if (connect("www.google.com") != "") {
            frame.setSize(400, 300);

            // Pannello principale con layout BorderLayout
            JPanel panel = new JPanel(new BorderLayout());

            // TextField al centro in alto
            JTextField textField = new JTextField();
            panel.add(textField, BorderLayout.NORTH);

            // Etichetta al centro della pagina
            JLabel label = new JLabel("Etichetta al centro");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(label, BorderLayout.CENTER);

            // Pulsanti nella riga in fondo
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton button1 = new JButton("Prova");
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Azione del pulsante "Prova" che tenta di stabilire una connessione a un server.
                    try {
                        socket = new Socket(textField.getText().toString(), 80);
                        input = new Scanner(socket.getInputStream());
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        System.out.println("Connessione non stabilita");
                        e1.printStackTrace();
                    }
                    if (connect(textField.getText().toString()) != "") {
                        label.setText("Connessione riuscita");
                    } else {
                        label.setText("Connessione non riuscita");
                    }
                }
            });
            JButton button2 = new JButton("Cancella");
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Azione del pulsante "Cancella" che elimina il testo dall'etichetta.
                    label.setText("");
                }
            });
            Scanner scanner = new Scanner(System.in);

            JButton button3 = new JButton("Richiedi");
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Azione del pulsante "Richiedi" che invia una richiesta al server.
                    if (!socket.isClosed()) {
                        try {
                            writer = new PrintWriter(socket.getOutputStream());
                            System.out.println("Inserisci pagina da richiedere : ");
                            writer.write("GET/" + scanner.nextLine() + "\r\n\r\n");
                            writer.flush();
                            if (input.hasNextLine()) {
                                label.setText("Risposta : \n" + input.nextLine());
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
            buttonPanel.add(button1);
            buttonPanel.add(button2);
            buttonPanel.add(button3);
            panel.add(buttonPanel, BorderLayout.SOUTH);

            frame.getContentPane().add(panel);
            frame.setVisible(true);
        } else {
            System.out.println("Errore: impossibile connettersi a Internet");
            System.exit(0);
        }
    }

    /**
     * Prova a stabilire una connessione a un server specifico.
     *
     * @param urlString L'URL del server a cui connettersi.
     * @return "ok" se la connessione è riuscita, altrimenti una stringa vuota.
     */
    private String connect(String urlString) {
        Scanner reader;
        Socket socket;
        try {
            socket = new Socket(urlString, 80);
            reader = new Scanner(socket.getInputStream());
            return "ok";
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
            return "";
        } catch (IOException e1) {
            System.out.println("Connessione non stabilita");
            e1.printStackTrace();
            return "";
        }
    }
}
