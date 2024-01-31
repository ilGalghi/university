package esercizio;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

@SuppressWarnings("serial")				// Toglie warning su 'Finestra'
public class Finestra extends JFrame {  // Estendi JFrame per creare una finestra

    // Dichiarazione dei bottoni e delle aree di testo
    JButton connectButton, disconnectButton, startButton, stopButton, clearButton;
    private JTextArea logTextArea, pdfTextArea, mp3TextArea;
    private JTextArea totalSizeField;

    public Finestra() {
        super("Titolo Finestra"); // Imposta il titolo della finestra
        Ascoltatore ascolta = new Ascoltatore(this); // Inizializza l'ascoltatore per i bottoni

        // Etichette e campi per l'indirizzo del server e la porta
        JLabel addressField = new JLabel("Server address: ");
        JLabel portField = new JLabel("Porta: ");

        JTextArea campoServer = new JTextArea(1,20);
        JTextArea portaPorta = new JTextArea(1,10);

        // Pannello superiore con layout FlowLayout per gli elementi di connessione
        JPanel pannelloAlto = new JPanel();
        pannelloAlto.setLayout(new FlowLayout());
        pannelloAlto.add(addressField);
        pannelloAlto.add(campoServer);
        pannelloAlto.add(portField);
        pannelloAlto.add(portaPorta);

        // Creazione dei bottoni di connessione, disconnessione, avvio, stop e cancellazione
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        clearButton = new JButton("Clear");
        pannelloAlto.add(connectButton);
        pannelloAlto.add(disconnectButton);

        // Imposta l'abilità dei bottoni
        startButton.setEnabled(false);
        clearButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        stopButton.setEnabled(false);

        // Aree di testo con scrollbar e bordi
        logTextArea = new JTextArea(10, 30);
        logTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        TitledBorder borderLog = new TitledBorder("Log");
        borderLog.setTitleJustification(TitledBorder.LEFT);
        borderLog.setTitlePosition(TitledBorder.TOP);
        logScrollPane.setBorder(borderLog);

        pdfTextArea = new JTextArea(10, 30);
        pdfTextArea.setEditable(false);
        JScrollPane pdfScrollPane = new JScrollPane(pdfTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        TitledBorder borderPDF = new TitledBorder("PDF");
        borderPDF.setTitleJustification(TitledBorder.LEFT);
        borderPDF.setTitlePosition(TitledBorder.TOP);
        pdfScrollPane.setBorder(borderPDF);

        mp3TextArea = new JTextArea(10, 30);
        mp3TextArea.setEditable(false);
        JScrollPane mp3ScrollPane = new JScrollPane(mp3TextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        TitledBorder borderMP3 = new TitledBorder("MP3");
        borderMP3.setTitleJustification(TitledBorder.LEFT);
        borderMP3.setTitlePosition(TitledBorder.TOP);
        mp3ScrollPane.setBorder(borderMP3);

        // Pannello con le aree di testo
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.add(logScrollPane);
        textAreaPanel.add(pdfScrollPane);
        textAreaPanel.add(mp3ScrollPane);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Imposta il layout della finestra

        // Pannello per i bottoni di controllo e visualizzazione della dimensione totale
        JPanel buttonPanel = new JPanel();
        JLabel testoDimensione = new JLabel("Dimensione: ");
        totalSizeField = new JTextArea(1,15);
        totalSizeField.setEditable(false);
        buttonPanel.add(testoDimensione);
        buttonPanel.add(totalSizeField);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(clearButton);

        // Aggiungi i pannelli alla finestra
        add(pannelloAlto);
        add(textAreaPanel);
        add(buttonPanel);

        pack(); // Impacchetta la finestra
        setLocationRelativeTo(null); // Posiziona la finestra al centro
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi l'applicazione quando la finestra viene chiusa
        setVisible(true); // Rendi la finestra visibile
        System.out.println("Creato pannello"); // Messaggio di controllo
        
        // Associazione dei bottoni e delle aree di testo agli ascoltatori e alle funzioni
        ascolta.connectButton = connectButton;
        ascolta.disconnectButton = disconnectButton;
        ascolta.startButton = startButton;
        ascolta.stopButton = stopButton;
        ascolta.clearButton= clearButton;
        
        lettura.connectButton = connectButton;
        lettura.disconnectButton = disconnectButton;
        lettura.startButton = startButton;
        lettura.stopButton = stopButton;
        lettura.clearButton= clearButton;
        
        // Collegamento delle aree di testo e dei bottoni agli ascoltatori per le operazioni
        ascolta.campoServer = campoServer;
        ascolta.portaPorta = portaPorta;
        ascolta.logTextArea = logTextArea;    // Testo log (t1)
        ascolta.pdfTextArea = pdfTextArea;
        ascolta.mp3TextArea = mp3TextArea;
        ascolta.totalSizeField = totalSizeField;
        
        // Assegnazione delle aree di testo e dei bottoni agli ascoltatori per le operazioni di lettura
        lettura.logTextArea = logTextArea;    // Testo log (t1)
        lettura.pdfTextArea = pdfTextArea;
        lettura.mp3TextArea = mp3TextArea;
        lettura.totalSizeField = totalSizeField;
        
        // Aggiunta degli ascoltatori per i bottoni
        connectButton.addActionListener(ascolta);
        disconnectButton.addActionListener(ascolta);
        startButton.addActionListener(ascolta);
        stopButton.addActionListener(ascolta);
        clearButton.addActionListener(ascolta);
    }
}
