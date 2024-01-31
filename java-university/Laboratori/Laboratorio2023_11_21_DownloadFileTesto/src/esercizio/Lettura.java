package esercizio;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Lettura implements Runnable{

	public static Scanner leggi;
	public static JTextArea consoleTextArea;
	public static JButton interruptButton;
	
	String s;

	
	public void run() {
		try {   
        	while (leggi.hasNextLine()) {
        		s = leggi.nextLine();
        		
        		
        		if (s.equals("END")) {
        			consoleTextArea.append("----------Download completato----------\n");
        			break;
        		}
        		
        		
        		else if (s.equals("ERROR")) {
        			consoleTextArea.append("----------Comando errato----------\n");
        			break;
        		}
        		
        		else if (s.equals("INTERRUPTED")) {
        			
        			consoleTextArea.append("----------Download interrotto----------\n");
        			interruptButton.setEnabled(false);
        			break;
        		}
        		else{
        		consoleTextArea.append(s + '\n');
        		}
        		
        	}
        	Thread.sleep(100);
    	}
    	catch (InterruptedException e) {
    		return;
    	}  
	}
}
