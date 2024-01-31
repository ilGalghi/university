package fratm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Finestra extends JFrame{
	Finestra(){
		super("nome cognome matricola");
		Ascoltatore ascolta = new Ascoltatore(this);
		LayoutManager lm = new FlowLayout();
		LayoutManager gm = new GridLayout(3,5);
		
		
		
		//ZONA 1___________________________________________
		JPanel P1 = new JPanel();                          //
		P1.setLayout(lm);                                  //
		this.add(P1,BorderLayout.NORTH);                   //
		                                                   //
		JLabel Server = new JLabel("Server Address");      //
		P1.add(Server);                                    //
		JTextArea T1 = new JTextArea(1,20);                //
		P1.add(T1);                                        //
		T1.setBorder(BorderFactory.createTitledBorder(""));//
		JLabel Port = new JLabel("Port");                  //
		P1.add(Port);                                      //
		JTextArea T2 = new JTextArea(1,10);                //
		P1.add(T2);                                        //
		T2.setBorder(BorderFactory.createTitledBorder(""));//
		                                                   //
		JButton Connect = new JButton("Connect");          //
		P1.add(Connect);                                   //
		JButton Disconnect = new JButton("Disconnect");    //
		P1.add(Disconnect);                                //
		//_________________________________________________//
		
		
		
		
		//ZONA 2___________________________________________________________
		JPanel P2 = new JPanel();                                          //                     
		P2.setLayout(lm);                                                  //
		this.add(P2,BorderLayout.CENTER);                                  //
		                                                                   // 
		JPanel Cartella = new JPanel();                                    //
		Cartella.setLayout(gm);                                            //
		Cartella.setBorder(BorderFactory.createTitledBorder("Cartella"));  //
		                                                                   //
		P2.add(Cartella);                                                  //
		TicketCell[] T = new TicketCell[15];                               //
		for(int i = 0; i < 3;i++) {                                        //
			for(int j = 0; j < 15; j = j+3){                               //
				T[j+i] = new TicketCell();                                 //
				T[j+i].setBorder(BorderFactory.createTitledBorder(""));    //
				Cartella.add(T[j+i]);                                      //
			}                                                              //
			                                                               //
		}                                                                  //
		Numeri.T = T;                                                      //
		Estrazione.T = T;                                                  //
		Numeri c = new Numeri();                                           //
		c.Crea();                                                          //
		                                                                   //
		JPanel Log = new JPanel();                                         //
		P2.add(Log);                                                       //
		JTextArea Testo = new JTextArea(20,30);                            //
		Testo.setEditable(false);                                          //
		JScrollPane S1 = new JScrollPane(Testo,                            //
				             JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,        //
				             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);     //
		S1.setBorder(BorderFactory.createTitledBorder("Log"));             //
		Log.add(S1);                                                       //
		//_________________________________________________________________//
		
		
		
		//ZONA 3_______________________________
		JPanel P3 = new JPanel();              //
		P3.setLayout(lm);                      //
		this.add(P3,BorderLayout.SOUTH);       //
		                                       //
		JButton Start = new JButton("Start");  //
		P3.add(Start);                         //
		JButton Stop = new JButton("Stop");    //
		P3.add(Stop);                          //
		//_____________________________________//
		
		
		
		//COLLEGAMENTI_________________________
		ascolta.Connect = Connect;             //
		ascolta.Disconnect = Disconnect;       //
		ascolta.Start = Start;                 //
		ascolta.Stop = Stop;                   //
		                                       //
		ascolta.T2 = T2;                       //
		ascolta.Testo = Testo;                 //
		                                       //
		Estrazione.Testo = Testo;              //
		Estrazione.Connect = Connect;          //
		Estrazione.Disconnect = Disconnect;    //
		Estrazione.Start = Start;              //
		Estrazione.Stop = Stop;                //
		                                       //
		Disconnect.setEnabled(false);          //
		Start.setEnabled(false);               //
		Stop.setEnabled(false);                //
		                                       //
		Connect.addActionListener(ascolta);    //
		Disconnect.addActionListener(ascolta); //
		Start.addActionListener(ascolta);      //
		Stop.addActionListener(ascolta);       //
		//_____________________________________//
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
