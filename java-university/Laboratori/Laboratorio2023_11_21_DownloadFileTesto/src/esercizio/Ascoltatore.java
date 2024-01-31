package esercizio;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Ascoltatore implements ActionListener{
	Finestra finestra;
	public JButton connectButton;
	public JButton disconnectButton;
	public JButton interruptButton;
	public JButton executeButton;
	public JTextArea portaPorta;
	public JTextArea campoCommand;
	public JTextArea consoleTextArea;
	
	PrintWriter scrivi;
	Socket socket;
	Scanner leggi;
	Lettura l;
	Thread t;
	

	
	Ascoltatore(Finestra finestra){
		this.finestra = finestra;
		l = new Lettura();
		t = new Thread(l);
		
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		System.out.println("Evento: "+ e.getActionCommand());
		
		if (e.getActionCommand().equals("Connect")) { 
			try {
				socket = new Socket("",Integer.parseInt(portaPorta.getText())); // Connette il socket
				scrivi = new PrintWriter(socket.getOutputStream());
				leggi = new Scanner(socket.getInputStream());
				Lettura.leggi = leggi;
				Lettura.consoleTextArea = consoleTextArea;
				
				
				connectButton.setEnabled(false); // Disabilita il pulsante Connect
				disconnectButton.setEnabled(true); // Abilita il pulsante Disconnect
				executeButton.setEnabled(true);
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
		
		// PULSANTE "Disconnect"
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
		
		
		//PULSANTE EXECUTE
		if (e.getActionCommand().equals("Execute")){
			
			scrivi.println(campoCommand.getText());
			scrivi.flush();
			interruptButton.setEnabled(true);
				
			if(t.getState() == Thread.State.NEW ) {
				System.out.println("Thread.State.NEW");
				t.start(); 
				System.out.println("t.start()");
			}
				
			else if (t.getState() == Thread.State.TERMINATED ) {
				System.out.println("Thread.State.TERMINATED");
				t = new Thread(l);
				t.start();
			}
				
			// Impostazioni dei pulsanti dopo la disconnessione
			
			disconnectButton.setEnabled(false);
			
			
				
			
		}
		
		
		//PULSANTE INTERRUPT
		if (e.getActionCommand().equals("Interrupt")){
			scrivi.println("INTERRUPT");
			scrivi.flush();
			Lettura.interruptButton = interruptButton;
			System.out.println("Interrompo");
			t.interrupt();
    		
			
			executeButton.setEnabled(true);
			disconnectButton.setEnabled(true);
		}
		
		
	}
}

