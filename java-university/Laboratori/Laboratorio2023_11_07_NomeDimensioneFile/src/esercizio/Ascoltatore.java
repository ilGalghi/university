package esercizio;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

// Classe che gestisce gli eventi dei bottoni nella finestra principale
// Verifica che tutte le eccezioni siano state catturate

public class Ascoltatore implements ActionListener {
	Finestra finestra;
	
	// Dichiarazione di variabili per le aree di testo e i bottoni
	JTextArea campoServer;
	JTextArea portaPorta;
	JTextArea logTextArea;		//t1
	JTextArea pdfTextArea;
	JTextArea mp3TextArea;
	JTextArea totalSizeField;
	
	JButton connectButton, disconnectButton, startButton, stopButton, clearButton;
	
	Socket socket;
	Scanner leggi;
	lettura p;
	Thread t;
	
	double dim;
	
	// Costruttore che riceve la finestra principale come argomento
	Ascoltatore(Finestra finestra2){
		this.finestra = (Finestra) finestra2;
		p = new lettura(finestra);
		t = new Thread(p);
	}
	
	// Metodo che gestisce gli eventi dei bottoni
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("evento: " + e.getActionCommand());
		lettura.dim = dim;

		// Se il pulsante premuto è "Connect"
		if (e.getActionCommand().equals("Connect")) { 
			try {
				socket = new Socket("",Integer.parseInt(portaPorta.getText())); // Connette il socket
				connectButton.setEnabled(false); // Disabilita il pulsante Connect
				disconnectButton.setEnabled(true); // Abilita il pulsante Disconnect
				startButton.setEnabled(true); // Abilita il pulsante Start
				clearButton.setEnabled(true); // Abilita il pulsante Clear
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Inserire un numero corretto nella porta", "Info Box", JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				JOptionPane.showMessageDialog(null, "Inserire un domain server corretto", "Info Box", JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// Se il pulsante premuto è "Disconnect"
		if (e.getActionCommand().equals("Disconnect")){
			PrintWriter scrivi;
			try {
				scrivi = new PrintWriter(socket.getOutputStream());
				scrivi.println("disconnect");
				scrivi.flush();
				
				// Impostazioni dei pulsanti dopo la disconnessione
				connectButton.setEnabled(true);
				stopButton.setEnabled(false);
				disconnectButton.setEnabled(false);
				startButton.setEnabled(false);
				clearButton.setEnabled(false);
				
				socket.close(); // Chiude il socket
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// Se il pulsante premuto è "Start"
		if (e.getActionCommand().equals("Start")){
			PrintWriter scrivi;
			try {
				scrivi = new PrintWriter(socket.getOutputStream());
				scrivi.println("start");
				scrivi.flush();
		
				// Pulisce le aree di testo e resetta le dimensioni
				logTextArea.setText(null);
				pdfTextArea.setText(null);
				mp3TextArea.setText(null);
				totalSizeField.setText(null);
				dim = 0;
				
				// Impostazioni dei pulsanti dopo l'avvio
				stopButton.setEnabled(true);
				disconnectButton.setEnabled(false);
				startButton.setEnabled(false);
				clearButton.setEnabled(false);
				
				// Legge i dati dal socket e avvia il thread se è nuovo o è stato terminato
				leggi = new Scanner(socket.getInputStream());
				lettura.leggi = leggi;
				if(t.getState() == Thread.State.NEW ) {
					t.start(); 
				}
				else if (t.getState() == Thread.State.TERMINATED ) {
					t = new Thread(p);
					t.start();
				}
				 
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// Se il pulsante premuto è "Stop"
		if (e.getActionCommand().equals("Stop")){
			PrintWriter scrivi;
			try {
				scrivi = new PrintWriter(socket.getOutputStream());
				scrivi.println("stop");
				scrivi.flush();
				
				// Impostazioni dei pulsanti dopo la fermata
				stopButton.setEnabled(false);
				disconnectButton.setEnabled(true);
				startButton.setEnabled(true);
				clearButton.setEnabled(true);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		// Se il pulsante premuto è "Clear"
		if (e.getActionCommand().equals("Clear")){
			// Pulisce le aree di testo e resetta le dimensioni
			logTextArea.setText(null);
			pdfTextArea.setText(null);
			mp3TextArea.setText(null);
			totalSizeField.setText(null);
			dim = 0;
		}

	}
}
