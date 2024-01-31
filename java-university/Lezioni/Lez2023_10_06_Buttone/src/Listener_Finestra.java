import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class Listener_Finestra implements ActionListener{		//uso implements
	
	JTextArea testo, testo1;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("DAJE")){
		testo.append("DAJE ROMA\n");
		
		}
		
		if (e.getActionCommand().equals("FORZA")){
			testo.append("FORZA ROMA\n");
			
			}
		
		
		
		
		
	}
	
}
