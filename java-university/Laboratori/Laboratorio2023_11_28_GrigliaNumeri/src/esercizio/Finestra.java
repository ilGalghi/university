package esercizio;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Finestra extends JFrame{
	
	Finestra() {
		super("Titolo finestra");
		Ascoltatore ascolta = new Ascoltatore(this);
		Lettura lettura = new Lettura(this);
		
		//PANNELLO SUPERIORE
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
        
        
        //PANNELLO MEDIO
        
        JPanel pannelloMedio = new JPanel();
        // Imposta il layout della finestra con GridLayout 5x5
        pannelloMedio.setLayout(new GridLayout(5, 5));

        // Crea un array di pulsanti per la griglia 5x5
        JButton[][] pulsanti = new JButton[5][5];

        // Popola la griglia con pulsanti disattivati
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pulsanti[i][j] = new JButton();
                pulsanti[i][j].setEnabled(false); // Imposta il pulsante come disattivato
                pulsanti[i][j].setBackground(Color.LIGHT_GRAY);
                pulsanti[i][j].setPreferredSize(new Dimension(60, 60)); 
                pannelloMedio.add(pulsanti[i][j]); // Aggiunge il pulsante alla finestra
            }
        }
        
        
        JTextArea logTextArea = new JTextArea(5, 5);
        logTextArea.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        TitledBorder borderLog = new TitledBorder("Console");
        borderLog.setTitleJustification(TitledBorder.LEFT);
        borderLog.setTitlePosition(TitledBorder.TOP);
        logScrollPane.setBorder(borderLog);

        JPanel pannelloCentrale = new JPanel();
        pannelloCentrale.setLayout(new BoxLayout(pannelloCentrale, BoxLayout.X_AXIS));

        // Utilizza un JSplitPane per separare la griglia di pulsanti e il box "console"
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pannelloMedio, logScrollPane);
        splitPane.setResizeWeight(0.5); // Imposta il rapporto di ridimensionamento tra i due componenti
        pannelloCentrale.add(splitPane);

        // Aggiungi pannelloCentrale al frame invece di pannelloMedio
        add(pannelloCentrale);
        
        
        //PANNELLOBASSO
        JPanel pannelloBasso = new JPanel();
        JLabel commandLabel = new JLabel("Numero: ");
        JTextArea campoCommand = new JTextArea(1,5);
        JButton getButton = new JButton("Get");
        JButton resetButton = new JButton("Reset");
        getButton.setEnabled(false);
        resetButton.setEnabled(false);
        
        pannelloBasso.add(commandLabel);
        pannelloBasso.add(campoCommand);
        pannelloBasso.add(getButton);
        pannelloBasso.add(resetButton);
        
        add(pannelloBasso);
        
        
        
        
        // IMPOSTAZIONI FINESTRA
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // Imposta il layout della finestra
        pack(); // Impacchetta la finestra
        setLocationRelativeTo(null); // Posiziona la finestra al centro
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chiudi l'applicazione quando la finestra viene chiusa
        setVisible(true); // Rendi la finestra visibile
        System.out.println("Creato pannello"); // Messaggio di controllo
	
	
        //PASSAGGIO VARIABILI
        ascolta.connectButton = connectButton;
        ascolta.disconnectButton = disconnectButton;
        ascolta.getButton = getButton;
        ascolta.resetButton = resetButton;
        ascolta.portaPorta = portaPorta;
        ascolta.campoCommand = campoCommand;
        ascolta.logTextArea = logTextArea;
        ascolta.pulsanti = pulsanti;
        ascolta.Lettura = lettura;
        ascolta.campoServer = campoServer;
	
	
        connectButton.addActionListener(ascolta);
        disconnectButton.addActionListener(ascolta);
        getButton.addActionListener(ascolta);
        resetButton.addActionListener(ascolta);
	
        lettura.logTextArea = logTextArea;
        lettura.pulsanti = pulsanti;
	
	
	
	}
}
