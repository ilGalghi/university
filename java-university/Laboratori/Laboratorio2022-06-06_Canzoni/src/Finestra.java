import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class Finestra extends JFrame{
	Finestra(){
		
		// IMPOSTAZIONI_______________________________________________
		super("Leonardo Galgano Canzoni");
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
        
        JTextArea logTextArea = new JTextArea(10, 30);
        logTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Log"));
        
        
        
        //per log:
        JTextArea artista = new JTextArea(10, 30);
        artista.setEditable(false);
        JScrollPane artistaPane = new JScrollPane(artista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        artistaPane.setBorder(BorderFactory.createTitledBorder("Artista e canzoni"));
        
        
        //aggiunta campi pannelloMedio
        pannelloMedio.add(logScrollPane);
        pannelloMedio.add(artistaPane);
        add(pannelloMedio);
        
		//______________________________________________________________
        
        
        
        
        
        //PANNELLO BASSO________________________________________________      
        JPanel pannelloBasso = new JPanel();
        JButton artistaButton = new JButton("Artisti");
        JButton canzoniButton = new JButton("Canzoni");
        JButton stopButton = new JButton("Stop");
        artistaButton.setEnabled(false);
        stopButton.setEnabled(false);
        canzoniButton.setEnabled(false);
        
        
        pannelloBasso.add(artistaButton);
        pannelloBasso.add(canzoniButton);
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
        ascolta.artistaButton = artistaButton;
        ascolta.stopButton = stopButton;
        ascolta.canzoniButton = canzoniButton;
        
        ascolta.campoServer = campoServer;
        ascolta.portaPorta = portaPorta;
        
        ascolta.artistaTextArea=artista;
        ascolta.logTextArea = logTextArea;
        
        connectButton.addActionListener(ascolta);
        disconnectButton.addActionListener(ascolta);
        artistaButton.addActionListener(ascolta);
        stopButton.addActionListener(ascolta);
        canzoniButton.addActionListener(ascolta);
        
        // passaggio al run
        ascolta.r = r;
        r.canzoniButton = canzoniButton;
        r.artistaButton = artistaButton;
        r.disconnectButton = disconnectButton;
        r.stopButton = stopButton;
        r.logTextArea = logTextArea;
        r.canzoniButton = canzoniButton;
        
        r.artistaTextArea=artista;
        
	}
}