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
	Run r;
	Thread t;

	public JButton connectButton;
	public JButton disconnectButton;
	public JButton artistaButton;
	public JButton stopButton;	
	public JTextArea portaPorta;
	public JTextArea logTextArea;
	public JTextArea campoServer;
	public JTextArea txtScrollArea;
	public JButton canzoniButton;
	public JTextArea artistaTextArea;
	
	
	
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
				leggi = new Scanner(socket.getInputStream());
				scrivi = new PrintWriter(socket.getOutputStream());
				r.socket = socket;		//passi tramite oggetto 'r'
				
				//Pulsanti:
				connectButton.setEnabled(false);
				disconnectButton.setEnabled(true);
				artistaButton.setEnabled(true);
				stopButton.setEnabled(false);
				logTextArea.setText(null);
				artistaTextArea.setText(null);
				
				
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Inserire un numero corretto nella porta", "Info Box", JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				JOptionPane.showMessageDialog(null, "Inserire IP address corretto", "Info Box", JOptionPane.INFORMATION_MESSAGE);
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//_______________________________________________________________
		
		
		
		
		
		// PULSANTE DISCONNECT____________________________________________
		if (e.getActionCommand().equals("Disconnect")){
			
			try {
				scrivi.println("disconnect");	//se necessario
				scrivi.flush();
				socket.close(); // Chiude il socket
				
				// Pulsanti:
				connectButton.setEnabled(true);
				disconnectButton.setEnabled(false);
				artistaButton.setEnabled(false);
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//_______________________________________________________________
		
		
		//PULSANTE ARTISTI_______________________________________________
		if (e.getActionCommand().equals("Artisti")){
			scrivi.println("artisti");
			scrivi.flush();
			stopButton.setEnabled(true);
			canzoniButton.setEnabled(false);
			
			t = new Thread(r);
			r.leggi = leggi;
			t.start();

			logTextArea.setText(null);
			artistaTextArea.setText(null);
			disconnectButton.setEnabled(false);
			artistaButton.setEnabled(false);
			
		}
		//_______________________________________________________________
		
		
		
		
		
		
		
		
		
		//PULSANTE STOP__________________________________________________
		if (e.getActionCommand().equals("Stop")){
			scrivi.println("stop");
			scrivi.flush();
			t.interrupt();
			disconnectButton.setEnabled(true);
			artistaButton.setEnabled(true);
		}
		//_______________________________________________________________
		
		
		
		
		
		if (e.getActionCommand().equals("Canzoni")){
		    scrivi.println("canzoni");
		    scrivi.flush();
		    stopButton.setEnabled(true);
		    canzoniButton.setEnabled(false);
		    
		    t = new Thread(r);
		    r.leggi = leggi;
		    t.start();
		    canzoniButton.setEnabled(false);
		}
		//_______________________________________________________________
	}
}