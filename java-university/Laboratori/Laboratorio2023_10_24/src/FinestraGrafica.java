import java.awt.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;


public class FinestraGrafica {
	static Logger log = Logger.getLogger("finestragrafica");		//nome classe del log
	

	public static void main(String[] args) throws SecurityException, IOException {
		
		//LOG
		FileHandler handler = new FileHandler("log.txt");
		SimpleFormatter sf = new SimpleFormatter();			//stampa in formato leggibile
		handler.setFormatter(sf);							//lo applico ad handler
		log.addHandler(handler);							//per formattare bene testo
		log.setUseParentHandlers(false);
		
		//CREAZIONE FINESTRA
		JFrame frame = new JFrame("Web Access App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.info("Finestra aperta");

        // Crea i componenti dell'interfaccia utente
        JTextArea urlField = new JTextArea();
        
        // Etichetta al centro della pagina
        JLabel resultLabel = new JLabel("Etichetta");
        frame.add(resultLabel, BorderLayout.SOUTH);
        
        //BOTTONI
        JButton google = new JButton("Google");
        JButton example = new JButton("Example");
        JButton w3 = new JButton("W3");
        JButton x = new JButton("X");
        
        // Aggiungi i componenti al frame
        frame.setLayout(new BorderLayout());
        frame.add(urlField, BorderLayout.NORTH);
        frame.add(resultLabel, BorderLayout.SOUTH);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(google);
        buttonPanel.add(example);
        buttonPanel.add(w3);
        buttonPanel.add(x);
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        
        //LISTENER
        Motore risp = new Motore(urlField, resultLabel);
        google.addActionListener(risp);

        Motore risp2 = new Motore(urlField, resultLabel);
        example.addActionListener(risp2);

        Motore risp3 = new Motore(urlField, resultLabel);
        w3.addActionListener(risp3);
        
        Motore risp4 = new Motore(urlField, resultLabel);
        x.addActionListener(risp4);
        
        
        frame.setLocationRelativeTo(null); // Imposta la posizione al centro dello schermo
        frame.setVisible(true);
        System.out.println("FINE");

	}

}
