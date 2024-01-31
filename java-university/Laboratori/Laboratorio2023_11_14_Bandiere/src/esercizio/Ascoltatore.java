package esercizio;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.*;


public class Ascoltatore implements ActionListener {
	Finestra finestra;
	public JButton connectButton;
	public JButton disconnectButton;
	public JButton startButton;
	public JButton stopButton;
	public JTextArea campoServer;
	public JTextArea portaPorta;
	public String stringPanel1;
	public String stringPanel2;
	public String stringPanel3;
	public JPanel panel1;
	public JPanel panel2;
	public JPanel panel3;
	
	
	PrintWriter scrivi;
	Socket socket;
	Scanner leggi;
	lettura l;
	Thread t;
	
	
	Ascoltatore(Finestra finestra){
		this.finestra = finestra;
		l = new lettura();
		t = new Thread(l);
		
		
	}
	
	
	
	@Override
    public void actionPerformed(ActionEvent e) {
		System.out.println("evento: "+ e.getActionCommand());
		
		if (e.getActionCommand().equals("Connect")) { 
			try {
				socket = new Socket("",Integer.parseInt(portaPorta.getText())); // Connette il socket
				scrivi = new PrintWriter(socket.getOutputStream());
				leggi = new Scanner(socket.getInputStream());
				lettura.leggi = leggi;
				
				connectButton.setEnabled(false); // Disabilita il pulsante Connect
				disconnectButton.setEnabled(true); // Abilita il pulsante Disconnect
				startButton.setEnabled(true); // Abilita il pulsante Start
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
				scrivi.println("disconnect");
				scrivi.flush();
				socket.close(); // Chiude il socket
				
				// Impostazioni dei pulsanti dopo la disconnessione
				connectButton.setEnabled(true);
				stopButton.setEnabled(false);
				disconnectButton.setEnabled(false);
				startButton.setEnabled(false);				
				
				panel1.setBackground(Color.LIGHT_GRAY);
				panel2.setBackground(Color.LIGHT_GRAY);
				panel3.setBackground(Color.LIGHT_GRAY);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//BOTTONE START
		if (e.getActionCommand().equals("Start")){
				scrivi.println("start");
				scrivi.flush();
				System.out.println("Inviato start");
				
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
				connectButton.setEnabled(false);
				stopButton.setEnabled(true);
				disconnectButton.setEnabled(false);
				startButton.setEnabled(false);	
				
				panel1.setBackground(Color.LIGHT_GRAY);                   //
				panel2.setBackground(Color.LIGHT_GRAY);                   //
				panel3.setBackground(Color.LIGHT_GRAY);
				
			}
		
		if (e.getActionCommand().equals("Stop")){
			PrintWriter scrivi;
			try {
				scrivi = new PrintWriter(socket.getOutputStream());
				scrivi.println("stop");
				scrivi.flush();
				
				// Impostazioni dei pulsanti dopo la disconnessione
				connectButton.setEnabled(false);
				stopButton.setEnabled(false);
				disconnectButton.setEnabled(true);
				startButton.setEnabled(true);				
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }
}
