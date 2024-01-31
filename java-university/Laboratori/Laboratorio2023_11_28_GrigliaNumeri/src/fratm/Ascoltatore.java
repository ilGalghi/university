package fratm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ascoltatore implements ActionListener{
	Finestra finestra;
	
	JButton []griglia;
	
	JButton Connect;
	JButton Disconnect;
	JButton Get;
	JButton Reset;
	
	JTextArea Testo;
	JTextField T1;
	JTextField T2;
	JTextField T3;
	
	Socket socket;
	Scanner leggi;
	PrintWriter scrivi;
	
	Colore colore;
	Thread t;
	
	Ascoltatore(Finestra finestra){
		this.finestra = finestra;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("evento: " + e.getActionCommand());
		
		//CONNECT____________________________________________________
		if(e.getActionCommand().equals("Connect")) {                 //
			try {                                                    //
				socket = new Socket(T1.getText(),                    //
						            Integer.parseInt(T2.getText())); //
				leggi = new Scanner(socket.getInputStream());        //
				scrivi = new PrintWriter(socket.getOutputStream());  //
				colore.socket = socket;                              //
				                                                     //
				Testo.setText(null);                                 //
				for(int i = 0; i<25;i++) {                           //
					griglia[i].setBackground(Color.white);           //
				}                                                    //
				T3.setText(null);                                    //
				                                                     //
				Connect.setEnabled(false);                           //
				Disconnect.setEnabled(true);                         //
				Get.setEnabled(true);                                //
				Reset.setEnabled(true);                              //
			} catch (IOException e1) {e1.printStackTrace();}         // 
		}                                                            //
		//___________________________________________________________//
		
		
		
		//DISCONNECT_________________________________________
		if(e.getActionCommand().equals("Disconnect")) {      //
			try {                                            //
				scrivi.println("DISCONNECT");                //
				scrivi.flush();                              //
				                                             // 
				socket.close();                              //
				                                             //
				Connect.setEnabled(true);                    //
				Disconnect.setEnabled(false);                // 
				Get.setEnabled(false);                       //
				Reset.setEnabled(false);                     //
			} catch (IOException e1) {e1.printStackTrace();} //
		}                                                    //
		//___________________________________________________//
		
		
		
		//GET___________________________________________
		if(e.getActionCommand().equals("Get")) {        //
			String s = T3.getText();                    //
				                                        //
			scrivi.println("GET:"+s);                   //
			scrivi.flush();                             //
					                                    //
			t = new Thread(colore);                     //
			colore.leggi = leggi;                       //
			t.start();                                  //
					                                    //
			Disconnect.setEnabled(false);               //
			Get.setEnabled(false);                      // 
		}                                               //
		//______________________________________________//
		
		
		
		//RESET________________________________________
		if(e.getActionCommand().equals("Reset")) {     //
			Testo.setText(null);                       //
			for(int i = 0; i<25;i++) {                 //
				griglia[i].setBackground(Color.white); //
			}                                          //
			T3.setText(null);                          //
		}                                              //
		//_____________________________________________//
	}
}





