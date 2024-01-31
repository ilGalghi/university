package fratm;

import java.awt.*;
import javax.swing.*;


public class Finestra extends JFrame{
	Finestra(){
		super("nome cognome matricola");
		Ascoltatore ascolta = new Ascoltatore(this);
		Colore colore = new Colore(this);
		LayoutManager lm = new FlowLayout();
		LayoutManager gm = new GridLayout(5,5);
		
		
		//ZONA 1___________________________________________
		JPanel P1 = new JPanel();                          //
		P1.setLayout(lm);                                  //
		this.add(P1,BorderLayout.NORTH);                   //
				                                           //
		JLabel Server = new JLabel("Server Address");      //
		P1.add(Server);                                    //
		JTextField T1 = new JTextField(20);                //
		P1.add(T1);                                        //
		JLabel Port = new JLabel("Port");                  //
		P1.add(Port);                                      //
		JTextField T2 = new JTextField(10);                //
		P1.add(T2);                                        //
		                                                   //
		JButton Connect = new JButton("Connect");          //
		P1.add(Connect);                                   //
		JButton Disconnect = new JButton("Disconnect");    //
		P1.add(Disconnect);                                //
		//_________________________________________________//
		
		
		
		//ZONA 2_________________________________________________________
		JPanel P2 = new JPanel();                                        //
		P2.setLayout(lm);                                                //
		this.add(P2,BorderLayout.CENTER);                                //
		                                                                 //
		JButton []griglia = new JButton[25];                             //
		                                                                 //
		                                                                 //
		JPanel disegno = new JPanel();                                   //
		disegno.setLayout(gm);                                           //
		P2.add(disegno);                                                 //
		for(int i = 0; i < 25; i++) {                                    //
			griglia[i] = new JButton();                                  //
			griglia[i].setBackground(Color.WHITE);                       //
			griglia[i].setPreferredSize(new Dimension(90,90));           //
			griglia[i].setEnabled(false);                                //
			disegno.add(griglia[i]);                                     //
		}                                                                //
		                                                                 //
		JPanel Log = new JPanel();                                       //
		P2.add(Log);                                                     //
		JTextArea Testo = new JTextArea(7,30);                           //
		Testo.setEditable(false);                                        //
		JScrollPane S1 = new JScrollPane(Testo,                          //
				             JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,      //
				             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);   //  
		S1.setBorder(BorderFactory.createTitledBorder("Log"));           //
		Log.add(S1);                                                     //
		//_______________________________________________________________//
		
		
		
		//ZONA 3_______________________________
		JPanel P3 = new JPanel();              //
		P3.setLayout(lm);                      //
		this.add(P3,BorderLayout.SOUTH);       //
		                                       //
		JLabel Numero = new JLabel("Numero");  //
		P3.add(Numero);                        //
		JTextField T3 = new JTextField(5);     //
		P3.add(T3);                            //
		                                       //
		JButton Get = new JButton("Get");      //
		P3.add(Get);                           //
		JButton Reset = new JButton("Reset");  //
		P3.add(Reset);                         //
		//_____________________________________//
		
		
		
		//COLLEGAMENTI_________________________
		ascolta.Connect = Connect;             //
		ascolta.Disconnect = Disconnect;       //
		ascolta.Get = Get;                     //
		ascolta.Reset = Reset;                 //
		ascolta.Testo = Testo;                 //
		ascolta.griglia = griglia;             //
		ascolta.T1 = T1;                       //
		ascolta.T2 = T2;                       //
		ascolta.T3 = T3;                       //
		                                       //
		ascolta.colore = colore;               //
		                                       //
		colore.griglia = griglia;              //
		colore.Testo = Testo;                  //
		colore.Connect = Connect;              //
		colore.Disconnect = Disconnect;        //
		colore.Get = Get;                      //
		colore.Reset = Reset;                  //
		                                       //
		Disconnect.setEnabled(false);          //
		Get.setEnabled(false);                 //
		Reset.setEnabled(false);               // 
		                                       //
		Connect.addActionListener(ascolta);    //
		Disconnect.addActionListener(ascolta); //
		Get.addActionListener(ascolta);        //
		Reset.addActionListener(ascolta);      //
		//_____________________________________//
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
