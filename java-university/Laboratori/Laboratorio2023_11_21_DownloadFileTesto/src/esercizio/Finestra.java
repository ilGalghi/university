package esercizio;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Finestra extends JFrame {
	
	public Finestra() {
		super("Titolo finestra");
		Ascoltatore ascolta = new Ascoltatore(this);
		
		//PANNELLO SUPERIORE
		JPanel pannelloAlto = new JPanel();
		JLabel addressField = new JLabel("IP address: ");
        JLabel portField = new JLabel("Port: ");
        JTextArea campoServer = new JTextArea(1,20);
        JTextArea portaPorta = new JTextArea(1,10);
        JButton connectButton = new JButton("Connect");
        JButton disconnectButton = new JButton("Disconnect");
        disconnectButton.setEnabled(false);

        
        
        
        //pannelloAlto.setLayout(new FlowLayout());
        pannelloAlto.add(addressField);
        pannelloAlto.add(campoServer);
        pannelloAlto.add(portField);
        pannelloAlto.add(portaPorta);
        pannelloAlto.add(connectButton);
        pannelloAlto.add(disconnectButton);
        
        //PANNELLO MEDIO
        JPanel pannelloMedio = new JPanel();
        JTextArea consoleTextArea = new JTextArea(20, 80);
        consoleTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(consoleTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        TitledBorder borderLog = new TitledBorder("Console");
        borderLog.setTitleJustification(TitledBorder.LEFT);
        borderLog.setTitlePosition(TitledBorder.TOP);
        logScrollPane.setBorder(borderLog);
        
        pannelloMedio.add(logScrollPane);
		
        
        //PANNELLO BASSO
        JPanel pannelloBasso = new JPanel();
        JLabel commandLabel = new JLabel("Command ");
        JTextArea campoCommand = new JTextArea(1,40);
        JButton executeButton = new JButton("Execute");
        JButton interruptButton = new JButton("Interrupt");
        executeButton.setEnabled(false);
        interruptButton.setEnabled(false);
        
        pannelloBasso.add(commandLabel);
        pannelloBasso.add(campoCommand);
        pannelloBasso.add(executeButton);
        pannelloBasso.add(interruptButton);
        
        
        
        // AGGIUNTA PANNELLI
        add(pannelloAlto);
        add(pannelloMedio);
        add(pannelloBasso);
        
        
        // IMPOSTAZIONI FINESTRA
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Imposta il layout della finestra
        pack(); // Impacchetta la finestra
        setLocationRelativeTo(null); // Posiziona la finestra al centro
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi l'applicazione quando la finestra viene chiusa
        setVisible(true); // Rendi la finestra visibile
        System.out.println("Creato pannello"); // Messaggio di controllo
        
        
        //COLLEGAMENTI
        ascolta.connectButton = connectButton;
        ascolta.disconnectButton = disconnectButton;
        ascolta.executeButton = executeButton;
        ascolta.interruptButton = interruptButton;
        ascolta.portaPorta = portaPorta;
        ascolta.campoCommand = campoCommand;
        ascolta.consoleTextArea = consoleTextArea;
        
        connectButton.addActionListener(ascolta);
        disconnectButton.addActionListener(ascolta);
        executeButton.addActionListener(ascolta);
        interruptButton.addActionListener(ascolta);
        
        
        
	}
}
