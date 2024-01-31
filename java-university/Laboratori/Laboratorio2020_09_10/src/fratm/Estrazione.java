package fratm;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Estrazione implements Runnable {
	Finestra finestra;
	
	static JButton Connect;
	static JButton Disconnect;
	static JButton Start;
	static JButton Stop;
	
	static JTextArea Testo;
	static Scanner leggi;
	
	static String []smorfia;
	
	
	static TicketCell[] T = new TicketCell[15];
	
	String s;
	int valore;
	
	Estrazione(Finestra finestra){
		this.finestra = finestra;
	}

	@Override
	public void run() {
		while(leggi.hasNextLine()) {
			s = leggi.nextLine();
			if(s.equals("+")) {
				Testo.append("-- Fine Partita --\n");
				Start.setEnabled(true);
				Disconnect.setEnabled(true);
				Stop.setEnabled(false);
				return;
			}
			else {
				for(int i = 0; i < 15; i++) {
					valore = T[i].getValue();
					if(valore == Integer.parseInt(s)) {
						T[i].setSelected(true);
					}
				}
				Testo.append("Estratto: " + s + "   " + smorfia[Integer.parseInt(s)-1] + "\n");
			}
			
		}
	}

}
