package fratm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Ascoltatore implements ActionListener{
	Finestra finestra;
	
	Numeri c;
	
	JButton Disconnect;
	JButton Connect;
	JButton Start;
	JButton Stop;
	
	JTextArea T2;
	JTextArea Testo;
	
	Socket socket;
	Scanner leggi;
	PrintWriter scrivi;
	
	
	Estrazione p;
	Thread t;
	
	Ascoltatore(Finestra finestra){
		this.finestra = finestra;
		c = new Numeri();
		
		p = new Estrazione(finestra);
		t = new Thread(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("evento: " + e.getActionCommand());
		
		
		//BOTTONE CONNECT_______________________________________________
		if(e.getActionCommand().equals("Connect")) {                    //
			                                                            //
			try {                                                       //
				socket = new Socket("",Integer.parseInt(T2.getText())); //
				leggi = new Scanner(socket.getInputStream());           //
				scrivi = new PrintWriter(socket.getOutputStream());     //
				                                                        //
				Connect.setEnabled(false);                              //
				Disconnect.setEnabled(true);                            //
				Start.setEnabled(true);                                 //
			                                                            //
			} catch (NumberFormatException | IOException e1) {          //
				e1.printStackTrace();                                   //
			}                                                           //
		}                                                               //
		//______________________________________________________________//
		
		
		//BOTTONE DISCONNECT_____________________________
		if(e.getActionCommand().equals("Disconnect")) {  //
			                                             //
			try {                                        //
				scrivi.println("disconnect");            //
				scrivi.flush();                          //
				socket.close();                          //
				                                         //
				Connect.setEnabled(true);                //
				Disconnect.setEnabled(false);            //
				Start.setEnabled(false);                 //
				                                         //
			} catch (IOException e1) {                   //
				e1.printStackTrace();                    //
			}                                            //
		}                                                //
		//_______________________________________________//
		
		
		//BOTTONE START___________________________________________
		if(e.getActionCommand().equals("Start")) {                //
			                                                      //
			scrivi.println("start");                              //
			scrivi.flush();                                       //
			                                                      //
			c.Crea();                                             //
			Testo.setText(null);                                  //
			                                                      // 
			if(t.getState() == Thread.State.NEW ) {               //
				t.start();                                        //
				Estrazione.leggi = leggi;                         //
			}                                                     //
			else if (t.getState() == Thread.State.TERMINATED ) {  //
				t = new Thread(p);                                //
				t.start();                                        //
				Estrazione.leggi = leggi;                         //
			}                                                     //
			                                                      //
			Disconnect.setEnabled(false);                         //
			Start.setEnabled(false);                              //
			Stop.setEnabled(true);                                //
		}                                                         //
		//________________________________________________________//
		
		
		//BOTTONE STOP______________________________
		if(e.getActionCommand().equals("Stop")) {   //
			                                        //
			scrivi.println("stop");                 //
			scrivi.flush();                         //
			t.interrupt();                          //
			                                        //
			Disconnect.setEnabled(true);            //
			Start.setEnabled(true);                 //
			Stop.setEnabled(false);                 //
		}                                           //
		//__________________________________________//
	}

	
	

}
