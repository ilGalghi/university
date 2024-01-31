package tombola;

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
	public JButton startButton;
	public JButton stopButton;	
	public JTextArea portaPorta;
	public JTextArea logTextArea;
	public JTextArea campoServer;
	public JTextArea txtScrollArea;
	public TicketCell[] T;
	
	
	
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
				
				//Pulsanti:
				connectButton.setEnabled(false);
				disconnectButton.setEnabled(true);
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
				
				
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
				scrivi.println("disconnect");	//se necessario
				scrivi.flush();
				socket.close(); // Chiude il socket
				
				// Pulsanti:
				disconnectButton.setEnabled(false);
				connectButton.setEnabled(false);
				startButton.setEnabled(false);
				connectButton.setEnabled(true);
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		//_______________________________________________________________
		
		
		
		
		
		//PULSANTE START_____________________________________________________
		if (e.getActionCommand().equals("Start")){
			
				TreeSet<Integer> lista = new TreeSet<Integer>();
				
				int x;
				while(lista.size() != 15) {
					x = (int)(Math.random()*90+1);
					System.out.println("NUMERO: "+x);
					if(!lista.contains(x)) {
						lista.add(x);
					}
				}
				System.out.println("LISTA:" + lista);
				for(int i = 0; i < 15; i++ ) {
					T[i].setValue(lista.first());
					lista.remove(lista.first());
					T[i].setSelected(false);
				}
				
				scrivi.println("start");
				scrivi.flush();
				t = new Thread(r);
				t.start();
				System.out.println("start");
				r.leggi = leggi;
				
				
				
				disconnectButton.setEnabled(false);
				stopButton.setEnabled(true);
				startButton.setEnabled(false);
				
			
				
				
				
			}
		
			
		//_______________________________________________________________
		
		
		
		
		
		//PULSANTE STOP__________________________________________________
		if (e.getActionCommand().equals("Stop")){
			scrivi.println("stop");
			scrivi.flush();
			t.interrupt();
			disconnectButton.setEnabled(true);
			startButton.setEnabled(true);
		}
		//_______________________________________________________________
		
		
		
		
		
		//PULSANTE RESET_________________________________________________
		if (e.getActionCommand().equals("Reset")){
						//reset schermata
			logTextArea.setText(null);
			disconnectButton.setEnabled(true);
			
		}
		//_______________________________________________________________
	}
}