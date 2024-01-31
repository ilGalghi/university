package fratm;

import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Colore implements Runnable{
	Finestra finestra;
	JButton []griglia;
	
	JTextArea Testo;
	JButton Connect;
	JButton Disconnect;
	JButton Get;
	JButton Reset;
	
	Scanner leggi;
	Socket socket;
	
	String [] s1 = new String[2];
	char numero;
	
	Colore(Finestra finestra){
		this.finestra = finestra;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			while(leggi.hasNextLine()) {
				String s = leggi.nextLine();
				
				if(s.equals("END")) {
					Disconnect.setEnabled(true);
					Get.setEnabled(true);
					return;
				}
				if(s.equals("ERROR")) {
					System.out.println("errore");
					try {
						socket.close();
						
						Connect.setEnabled(true);
						Disconnect.setEnabled(false);
						Get.setEnabled(false);
						Reset.setEnabled(false);
						return;
					} catch (IOException e) {}
				}
				s1 = s.split(":");
				Testo.append(s+"\n");
				
				for(int i = 0; i < 25; i++) {
					numero = s1[1].charAt(i);
					if(numero == '1') {
						griglia[i].setBackground(Color.black);
					}
					else {
						griglia[i].setBackground(Color.white);
					}
				}
			}
		}catch (InterruptedException e) {return;}
	}
}
