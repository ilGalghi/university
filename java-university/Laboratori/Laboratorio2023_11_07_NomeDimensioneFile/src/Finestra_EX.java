/*
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class Finestra_EX extends JFrame {
	
	JButton connectButton, disconnectButton, startButton, stopButton, clearButton;
    private JTextArea logTextArea, pdfTextArea, mp3TextArea;
    private JTextField totalSizeField;
	
	public Finestra_EX() {
		super("Leonardo");
		
		
		JLabel addressField = new JLabel("Server address: ");
		JLabel portField = new JLabel("Porta: ");				//127.0.0.1
        
        // Creazione del campo di testo
        JTextField campoServer = new JTextField(20); // 20 è la lunghezza predefinita del campo di testo
        JTextField portaPorta = new JTextField(10);
        
        

        // PANNELLO ALTO
        JPanel pannelloAlto = new JPanel();
        pannelloAlto.setLayout(new FlowLayout());
        pannelloAlto.add(addressField);
        pannelloAlto.add(campoServer);
        pannelloAlto.add(portField);
        pannelloAlto.add(portaPorta);
        
        //Bottoni
        connectButton = new JButton("Connect"); // Inizializzazione dei bottoni
        disconnectButton = new JButton("Disconnect");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        clearButton = new JButton("Clear");
        pannelloAlto.add(connectButton);
        pannelloAlto.add(disconnectButton);
        
        startButton.setEnabled(false);
        clearButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        stopButton.setEnabled(false);

		
		
		//PANNELLO 2
        logTextArea = new JTextArea(10, 30);
        logTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logTextArea);
        
        //Titolo pulsante log
        TitledBorder borderLog = new TitledBorder("Log");
        borderLog.setTitleJustification(TitledBorder.LEFT);
        borderLog.setTitlePosition(TitledBorder.TOP);
        logScrollPane.setBorder(borderLog);
        
        //JLabel logTextLabel = new JLabel("Log:");
        
        //Titolo pulsante pdf
        pdfTextArea = new JTextArea(10, 30);
        pdfTextArea.setEditable(false);
        JScrollPane pdfScrollPane = new JScrollPane(pdfTextArea);
        TitledBorder borderPDF = new TitledBorder("PDF");
        borderPDF.setTitleJustification(TitledBorder.LEFT);
        borderPDF.setTitlePosition(TitledBorder.TOP);
        pdfScrollPane.setBorder(borderPDF);

        //Titolo pulsante mp3
        mp3TextArea = new JTextArea(10, 30);
        mp3TextArea.setEditable(false);
        JScrollPane mp3ScrollPane = new JScrollPane(mp3TextArea);
        //JLabel mp3TextLabel = new JLabel("mp3:");
        TitledBorder borderMP3 = new TitledBorder("MP3");
        borderMP3.setTitleJustification(TitledBorder.LEFT);
        borderMP3.setTitlePosition(TitledBorder.TOP);
        mp3ScrollPane.setBorder(borderMP3);

        
        
        JPanel textAreaPanel = new JPanel();
        //textAreaPanel.add(logTextLabel);
        textAreaPanel.add(logScrollPane);
        
        //textAreaPanel.add(pdfTextLabel);
        textAreaPanel.add(pdfScrollPane);
        
        //textAreaPanel.add(mp3TextLabel);
        textAreaPanel.add(mp3ScrollPane);
        
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        
        //TERZO PANNELLO
        JPanel buttonPanel = new JPanel();
        JLabel testoDimesione = new JLabel("Dimensione: ");
        totalSizeField = new JTextField(15);
        totalSizeField.setEditable(false);
        buttonPanel.add(testoDimesione);
        buttonPanel.add(totalSizeField);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(clearButton);
        
        

        
        //AZIONE PULSANTI
        // Azione del pulsante CONNECT
        connectButton.addActionListener(e -> {
        	
        	public String address = campoServer.getText();
            String port = portaPorta.getText();

            if(address.isEmpty() || port.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Inserire indirizzo e porta del server", "Info Box", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                int intPort = Integer.parseInt(port);
                Socket socket = new Socket(address, intPort);
                // Resto del codice per la connessione al server...
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Errore: La porta deve essere un numero valido", "Info Box", JOptionPane.INFORMATION_MESSAGE);
            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(null, "Errore: Indirizzo del server non valido", "Info Box", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                logTextArea.append("Errore durante la connessione al server.\n");
            }
        });
        
        //AZIONE PULSANTE DISCONNECT
        disconnectButton.addActionListener(e -> {
        	try {
        		int intPort = Integer.parseInt(port);
                Socket socket = new Socket(address, intPort);
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println("disconnect");
				writer.flush();
				socket.close();
				connectButton.setEnabled(true);
				stopButton.setEnabled(false);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	// Logica di disconnessione dal server
            // Esempio di output nella logTextArea
            logTextArea.append("Disconnesso dal server\n");
        });

        //AZIONE PULSANTE START
        startButton.addActionListener(e -> {
            logTextArea.append("Avviato il download dei file\n");
            startButton.setEnabled(false);
            clearButton.setEnabled(false);
            disconnectButton.setEnabled(false);
            stopButton.setEnabled(true);
            // Creazione e avvio del thread
            Thread downloadThread = new Thread(() -> {
                try {
                    Socket socket = new Socket(address, intPort);
                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                    writer.println("start");
                    writer.flush();
                    Scanner reader = new Scanner(socket.getInputStream());
                    
                    stopButton.setEnabled(true);
                    
                    if (reader.hasNextLine()) {
                        String response = reader.nextLine();
                        logTextArea.append("Risposta dal server: " + response + "\n");
                    }
                    
                    // Assicurati di chiudere le risorse dopo l'uso
                    
                } catch (NumberFormatException ex) {
                    logTextArea.append("Errore: La porta deve essere un numero valido.\n");
                } catch (UnknownHostException ex) {
                    logTextArea.append("Errore: Indirizzo del server non valido.\n");
                } catch (IOException ex) {
                    logTextArea.append("Errore durante il download dei file.\n");
                } finally {
                    // Abilita i pulsanti dopo il completamento del thread
                    startButton.setEnabled(true);
                    clearButton.setEnabled(true);
                    disconnectButton.setEnabled(true);
                    stopButton.setEnabled(false);
                }
            });
            
            // Avvio del thread appena creato
            downloadThread.start();
        });


        // Azione del pulsante STOP
        stopButton.addActionListener(e -> {
            // Logica per interrompere il download
            // Esempio di output nella logTextArea
            logTextArea.append("Download interrotto\n");
        });

        // Azione del pulsante CLEAR
        clearButton.addActionListener(e -> {
            // Pulisce tutti i campi di testo
            logTextArea.setText("");
            pdfTextArea.setText("");
            mp3TextArea.setText("");
            totalSizeField.setText("");
        });
        
        
        
        //AGGIUNTA PANNELLI
        add(pannelloAlto);
        add(textAreaPanel);
        add(buttonPanel);
        
        
        
        
        
        
		pack();						 // Grandezza predefinita
        setLocationRelativeTo(null); // Centra la finestra rispetto allo schermo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        System.out.println("Creato pannello");
	}
	
	
	


	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Finestra_EX());			//istruzione in Java Swing utilizzata per garantire che la creazione
        															//e la visualizzazione di una finestra Swing avvengano all'interno del thread dell'interfaccia grafica (Event Dispatch Thread, EDT)
	
        
	}
	
}


*/