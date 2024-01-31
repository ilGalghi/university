import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class Motore implements ActionListener {
    JTextArea urlField; // Riferimento al campo di testo per l'URL
    JLabel resultLabel; // Riferimento all'etichetta per i risultati
    
    static Logger log_mot = Logger.getLogger("motore");		//nome classe del log

    public Motore(JTextArea urlField, JLabel resultLabel) {
        this.urlField = urlField;
        this.resultLabel = resultLabel;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
    	//LOG
    	FileHandler handler;
		try {
			handler = new FileHandler("log_mot.txt");
			SimpleFormatter sf = new SimpleFormatter();			//stampa in formato leggibile
	    	handler.setFormatter(sf);							//lo applico ad handler
	    	log_mot.addHandler(handler);						//per formattare bene testo
	    	log_mot.setUseParentHandlers(false);   
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 	
    	
    	
    	
        // AZIONE PULSANTE "GOOGLE"
        if (e.getActionCommand().equals("Google")) {
        	log_mot.info("Premuto bottone Google");
            try {
                Socket socket = new Socket("www.google.com", 80);
                Scanner input = new Scanner(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                
                writer.print("GET /\r\n\r\n"); // Invia una richiesta HTTP GET
                writer.flush();
                
                if (input.hasNextLine()) {
                    resultLabel.setText("Risposta: \n" + input.nextLine());
                    
                }
                
                PrintWriter file = new PrintWriter(urlField.getText()+".txt");
                file.print(input.nextLine());
                file.flush();
                
                
            } catch (UnknownHostException e1) {
                resultLabel.setText("Connessione non riuscita (UnknownHostException)");
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("Connessione non stabilita");
                resultLabel.setText("Connessione non riuscita (IOException)");
                e1.printStackTrace();
            }
        }

              
        
        
        //PULSANTE EXAMPLE
        if (e.getActionCommand().equals("Example")) {
        	log_mot.info("Premuto bottone Example");
            try {
                Socket socket = new Socket("www.example.com", 80);
                Scanner input = new Scanner(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                
                writer.print("GET /\r\n\r\n"); // Invia una richiesta HTTP GET
                writer.flush();
                
                if (input.hasNextLine()) {
                    resultLabel.setText("Risposta: \n" + input.nextLine());
                    
                }
                
                PrintWriter file = new PrintWriter(urlField.getText()+".txt");
                file.print(input.nextLine());
                file.flush();
                
                log_mot.info("Creato File");
                               
            } catch (UnknownHostException e1) {
                resultLabel.setText("Connessione non riuscita (UnknownHostException)");
                log_mot.warning("UnknownHostException");
                e1.printStackTrace();
                
            } catch (IOException e1) {
                System.out.println("Connessione non stabilita");
                log_mot.warning("IOException");
                resultLabel.setText("Connessione non riuscita (IOException)");
                e1.printStackTrace();
            }
        }
        
        
        //PULSANTE W3
        if (e.getActionCommand().equals("W3")) {
        	log_mot.info("Premuto bottone W3");
            try {
                Socket socket = new Socket("www.w3.org", 80);
                Scanner input = new Scanner(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                
                writer.print("GET /\r\n\r\n"); // Invia una richiesta HTTP GET
                writer.flush();
                
                if (input.hasNextLine()) {
                    resultLabel.setText("Risposta: \n" + input.nextLine());
                    
                }
                
                PrintWriter file = new PrintWriter(urlField.getText()+".txt");
                file.print(input.nextLine());
                file.flush();
                
                
                
                
            } catch (UnknownHostException e1) {
                resultLabel.setText("Connessione non riuscita (UnknownHostException)");
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("Connessione non stabilita");
                resultLabel.setText("Connessione non riuscita (IOException)");
                e1.printStackTrace();
            }
        }

        
        //PULSANTE X
        if (e.getActionCommand().equals("X")) {
        	log_mot.info("Premuto bottone X");
            try {
                Socket socket = new Socket("www.x.org", 80);
                Scanner input = new Scanner(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                
                writer.print("GET /\r\n\r\n"); // Invia una richiesta HTTP GET
                writer.flush();
                
                if (input.hasNextLine()) {
                    resultLabel.setText("Risposta: \n" + input.nextLine());
                    
                }
                
                PrintWriter file = new PrintWriter(urlField.getText()+".txt");
                file.print(input.nextLine());
                file.flush();
                
                
                
                
            } catch (UnknownHostException e1) {
                resultLabel.setText("Connessione non riuscita (UnknownHostException)");
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("Connessione non stabilita");
                resultLabel.setText("Connessione non riuscita (IOException)");
                e1.printStackTrace();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    

    // Questo metodo tenta di stabilire una connessione e restituisce una stringa
    // "ok" se la connessione ha successo, o una stringa vuota in caso di errore.
    private String connect(String urlString) {
        Scanner reader;
        Socket socket;
        try {
            socket = new Socket(urlString, 80);
            reader = new Scanner(socket.getInputStream());
            return "ok"; // Connessione riuscita
            } catch (UnknownHostException e1) {
            e1.printStackTrace();
            return ""; // Connessione non riuscita
        } catch (IOException e1) {
            System.out.println("Connessione non stabilita");
            e1.printStackTrace();
            return ""; // Connessione non riuscita
        }
    }
}
