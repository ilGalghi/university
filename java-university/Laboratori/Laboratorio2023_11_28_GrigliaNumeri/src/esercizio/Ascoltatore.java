package esercizio;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;


public class Ascoltatore implements ActionListener {
	Finestra finestra;
	
	PrintWriter scrivi;
	Socket socket;
	Scanner leggi;
	Lettura l;
	Thread t;

	public JButton connectButton;
	public JButton disconnectButton;
	public JButton getButton;
	public JButton resetButton;
	public JTextArea portaPorta;
	public JTextArea campoCommand;
	public JTextArea logTextArea;

	public JButton[][] pulsanti;

	public Lettura Lettura;

	public JTextArea campoServer;
	
	Ascoltatore(Finestra finestra){
		this.finestra = finestra;		
	}
	
	
	@Override
    public void actionPerformed(ActionEvent e) {
		System.out.println("Evento: "+ e.getActionCommand());
		
		//PULSANTE CONNECT_____________________________________________
		if (e.getActionCommand().equals("Connect")) { 
			try {
				socket = new Socket(campoServer.getText(),Integer.parseInt(portaPorta.getText())); // Connette il socket
				scrivi = new PrintWriter(socket.getOutputStream());
				leggi = new Scanner(socket.getInputStream());
				Lettura.leggi = leggi;
				Lettura.logTextArea = logTextArea;			
				
				connectButton.setEnabled(false); // Disabilita il pulsante Connect
				disconnectButton.setEnabled(true); // Abilita il pulsante Disconnect
				getButton.setEnabled(true);
				resetButton.setEnabled(true);
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
		//_______________________________________________________________
		
		
		
		// PULSANTE DISCONNECT____________________________________________
		if (e.getActionCommand().equals("Disconnect")){
			
			try {
				scrivi.println("DISCONNECT");
				scrivi.flush();
				socket.close(); // Chiude il socket
				
				// Impostazioni dei pulsanti dopo la disconnessione
				connectButton.setEnabled(true);
				disconnectButton.setEnabled(false);
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//_______________________________________________________________
		
		
		
		//PULSANTE GET_____________________________________________________
		if (e.getActionCommand().equals("Get")){
			
			try {
			if (Integer.valueOf(campoCommand.getText())<0 || Integer.valueOf(campoCommand.getText())>9 ) {
				JOptionPane.showMessageDialog(null, "Inserire un numero corretto nella porta", "Info Box", JOptionPane.INFORMATION_MESSAGE);
			}
			
			scrivi.println("GET:" + campoCommand.getText());
			System.out.println("GET:" + campoCommand.getText());
			scrivi.flush();
			resetButton.setEnabled(true);
			Lettura.getButton = getButton;

			
			t = new Thread(Lettura);
			Lettura.leggi = leggi;
			t.start();
				
			// Pulsanti:			
			disconnectButton.setEnabled(false);
			getButton.setEnabled(false);
			resetButton.setEnabled(true);
			}
		
		catch (NumberFormatException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Inserire un numero corretto nella porta", "Info Box", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		//_______________________________________________________________
		
		
		
		//PULSANTE RESET___________________________________________________
		if (e.getActionCommand().equals("Reset")){
			for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                pulsanti[i][j].setEnabled(false); // Imposta il pulsante come disattivato
	                pulsanti[i][j].setBackground(Color.LIGHT_GRAY);
	                
	            }
	        }
			//reset schermata
			logTextArea.setText(null);
			disconnectButton.setEnabled(true);
			
		}
		//_______________________________________________________________
	}
}
