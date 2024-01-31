package tombola;

import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;


public class Run implements Runnable {
	Finestra finestra;
	public Scanner leggi;
	String s;
	public Socket socket;
	public JButton startButton;
	public JButton disconnectButton;
	public JButton stopButton;
	public JTextArea logTextArea;
	public tombola.TicketCell[] T;
	int valore;
	
	
	Run(Finestra finestra){
		this.finestra = finestra;
	}
	
	
	@Override
	public void run() {
		
		while(leggi.hasNextLine()) {
			s = leggi.nextLine();    //e fai ciò che viene richiesto
			
			if (s.equals("+")){	 //se stringa è uguale a parola
				logTextArea.append("-- Fine Partita --\n");
				startButton.setEnabled(true);
		        disconnectButton.setEnabled(true);
		        stopButton.setEnabled(false);
		        return;
			}
			
			
			else {
				for (int i = 0; i<15; i++) {
					valore = T[i].getValue();
					if (valore==Integer.parseInt(s)) {
						T[i].setSelected(true);
					}
				}
				logTextArea.append("Estratto: " + s + "\n");
			}
			
			
			
		}
	 
	}

}