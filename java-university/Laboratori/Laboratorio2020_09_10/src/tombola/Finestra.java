package tombola;
import java.awt.GridLayout;

import javax.swing.*;


public class Finestra extends JFrame{
	Finestra(){
		
		// IMPOSTAZIONI_______________________________________________
		super("Leonardo Galgano 2047468");
		Ascoltatore ascolta = new Ascoltatore(this);
		Run r = new Run(this);
		//____________________________________________________________
		
		
		
		
		
		// PANNELLO ALTO_______________________________________________
		JPanel pannelloAlto = new JPanel();
		JLabel addressField = new JLabel("IP address: ");
        JLabel portField = new JLabel("Port: ");
        JTextArea campoServer = new JTextArea(1,20);
        JTextArea portaPorta = new JTextArea(1,10);
        JButton connectButton = new JButton("Connect");
        JButton disconnectButton = new JButton("Disconnect");
        disconnectButton.setEnabled(false);

        
        //aggiunta campi pannelloAlto
        pannelloAlto.add(addressField);
        pannelloAlto.add(campoServer);
        pannelloAlto.add(portField);
        pannelloAlto.add(portaPorta);
        pannelloAlto.add(connectButton);
        pannelloAlto.add(disconnectButton);
        add(pannelloAlto);		
		//______________________________________________________________
		
                
           
        
        
        //PANNELLO MEDIO________________________________________________
        JPanel pannelloMedio = new JPanel();
        
        
        
        JPanel Cartella = new JPanel();                                    //
		Cartella.setLayout(new GridLayout(3,5));                           //
		Cartella.setBorder(BorderFactory.createTitledBorder("Cartella"));  //
		                                                                   //
		pannelloMedio.add(Cartella);                                       //
		TicketCell[] T = new TicketCell[15];                               //
		for(int i = 0; i < 3;i++) {                                        //
			for(int j = 0; j < 15; j = j+3){
				System.out.println("I:"+i +" " + "J:"+j);					   //
				T[j+i] = new TicketCell();                                 //
				T[j+i].setBorder(BorderFactory.createTitledBorder(""));    //
				Cartella.add(T[j+i]);                                      //
			}                                                              //
			                                                               //
		}
		
		
        
        JTextArea logTextArea = new JTextArea(20, 20);
        logTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Log"));
        
        
        //aggiunta campi pannelloMedio
        pannelloMedio.add(logScrollPane);
        add(pannelloMedio);
		//______________________________________________________________
        
        
        
        
        
        //PANNELLO BASSO________________________________________________      
        JPanel pannelloBasso = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        startButton.setEnabled(false);
        stopButton.setEnabled(false);
        
        
        pannelloBasso.add(startButton);
        pannelloBasso.add(stopButton);
        
        add(pannelloBasso);
        //______________________________________________________________
        
        
        // IMPOSTAZIONI FINESTRA________________________________________
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
        pack(); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        System.out.println("Creato pannello");
        //______________________________________________________________
        
        
        // COLLEGAMENTI_________________________________________________
        
        // passaggio all'ascoltatore
        ascolta.connectButton = connectButton;
        ascolta.disconnectButton = disconnectButton;
        ascolta.startButton = startButton;
        ascolta.stopButton = stopButton;
        
        ascolta.campoServer = campoServer;
        ascolta.portaPorta = portaPorta;
        
        ascolta.logTextArea = logTextArea;
        ascolta.logTextArea = logTextArea;
        ascolta.T = T;
        
        connectButton.addActionListener(ascolta);
        disconnectButton.addActionListener(ascolta);
        startButton.addActionListener(ascolta);
        stopButton.addActionListener(ascolta);
        
        // passaggio al run
        ascolta.r = r;
        r.startButton = startButton;
        r.disconnectButton = disconnectButton;
        r.stopButton = stopButton;
        r.logTextArea = logTextArea;
        r.T= T;
        
        
	}
}