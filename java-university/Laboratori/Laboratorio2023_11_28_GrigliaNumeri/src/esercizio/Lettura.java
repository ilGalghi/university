package esercizio;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class Lettura implements Runnable {
	Finestra finestra;
    Scanner leggi;
    JTextArea logTextArea;
    JButton[][] pulsanti;
	JButton getButton;
    String s;
    String[] x = new String[2];
    
   
    
    
    Lettura(Finestra finestra){
		this.finestra = finestra;
	}


    @Override
    public void run() {
        try {
            while (leggi.hasNextLine()) {
                s = leggi.nextLine();
                logTextArea.append(s);

                String[] x = s.split(":");
                
                if (x.length >= 2) {
                    String codice = x[1];
                    System.out.println(codice);

                    int index = 0;
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            char stato = codice.charAt(index);
                            System.out.println(stato);
                            if (stato == '1') {
                                pulsanti[i][j].setBackground(Color.BLACK);
                            } else {
                                pulsanti[i][j].setBackground(Color.WHITE);
                            }

                            index++;
                        }
                    }

                }
                getButton.setEnabled(true);
            }
        } catch (IndexOutOfBoundsException e) {
            // Gestione dell'eccezione, stampa di informazioni o altro
            e.printStackTrace();
        }
    }


}
