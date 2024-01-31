//import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Risposta implements ActionListener {
	JFrame finestra;
	JFrame fin;
	JTextArea testo;
	JLabel label;
	JButton ok;
	
	

	@Override
	// @Override  ridefinisce un metodo di una sovraclasse
	public void actionPerformed(ActionEvent e) {
		//System.out.println("evento: " + e.getActionCommand());
		if (e.getActionCommand().equals("stampa")) {
			this.testo.append(testo.getText());
		}
		
		if (e.getActionCommand().equals("cancella")) {
			this.testo.setText("");
		}
		
		if (e.getActionCommand().equals("mostra")) {
			
			String c = this.testo.getText();
			this.label.setText(c);
			this.fin.pack();
			this.fin.setVisible(true);
			this.finestra.setVisible(false);
		}
		if (e.getActionCommand().equals("esci")) {
			System.exit(0);
		}
		
		if (e.getActionCommand().equals("ok")) {
			this.fin.setVisible(false);
			this.finestra.setVisible(true);						
		}
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	}
	
	
}