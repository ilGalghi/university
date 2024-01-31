package esercizio;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")				// Toglie warning su 'Finestra'
public class Finestra extends JFrame{
	
	public Finestra() {
		super("Titolo Finestra");
		Ascoltatore ascolta = new Ascoltatore(this); // Inizializza l'ascoltatore per i bottoni
		
		// PANNELLO SUPERIORE	
		JLabel addressField = new JLabel("IP address: ");
        JLabel portField = new JLabel("Port: ");

        JTextArea campoServer = new JTextArea(1,20);
        JTextArea portaPorta = new JTextArea(1,10);
        
        JButton connectButton = new JButton("Connect");
        JButton disconnectButton = new JButton("Disconnect");
        

        
        JPanel pannelloAlto = new JPanel();
        pannelloAlto.setLayout(new FlowLayout());
        pannelloAlto.add(addressField);
        pannelloAlto.add(campoServer);
        pannelloAlto.add(portField);
        pannelloAlto.add(portaPorta);
        pannelloAlto.add(connectButton);
        pannelloAlto.add(disconnectButton);
        
        
        
        // PANNELLO MEDIO
        JPanel panel1 = createColoredPanel(Color.LIGHT_GRAY);
        JPanel panel2 = createColoredPanel(Color.LIGHT_GRAY);
        JPanel panel3 = createColoredPanel(Color.LIGHT_GRAY);
        

        
        JPanel pannelloMedio = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Imposta layout senza spazi
        pannelloMedio.add(panel1);
        pannelloMedio.add(panel2);
        pannelloMedio.add(panel3);
        
        
        
        // PANNELLO INFERIORE
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        startButton.setEnabled(false);
        stopButton.setEnabled(false);
		
        
        JPanel pannelloBasso = new JPanel();
        pannelloBasso.add(startButton);
        pannelloBasso.add(stopButton);
		
		
        add(pannelloAlto);
        add(pannelloMedio);
        add(pannelloBasso);
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Imposta il layout della finestra
        pack(); // Impacchetta la finestra
        setLocationRelativeTo(null); // Posiziona la finestra al centro
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi l'applicazione quando la finestra viene chiusa
        setVisible(true); // Rendi la finestra visibile
        System.out.println("Creato pannello"); // Messaggio di controllo
        
        
        
        
        //PASSAGGIO VARIABILI
        ascolta.connectButton = connectButton;
        ascolta.disconnectButton = disconnectButton;
        ascolta.startButton = startButton;
        ascolta.stopButton = stopButton;
        ascolta.campoServer = campoServer;
        ascolta.portaPorta = portaPorta;
        ascolta.panel1 = panel1;
        ascolta.panel2 = panel2;
        ascolta.panel3 = panel3;
        
        // aggiunta ascoltatori bottoni
        connectButton.addActionListener(ascolta);
        disconnectButton.addActionListener(ascolta);
        startButton.addActionListener(ascolta);
        stopButton.addActionListener(ascolta);
        
        
        // PASSAGGIO A LETTURA
        lettura.panel1 = panel1;
        lettura.panel2 = panel2;
        lettura.panel3 = panel3;
        
	}
	
	private JPanel createColoredPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(200, 500)); // Imposta le dimensioni desiderate
        return panel;
    }
	
}
