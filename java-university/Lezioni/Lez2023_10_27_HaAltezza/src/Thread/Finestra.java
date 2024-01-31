package Thread;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Finestra extends JFrame {
	JLabel etichetta;
	Finestra(){
		etichetta = new JLabel(" ");
		this.add(etichetta, BorderLayout.CENTER);
		Risposta a = new Risposta(this);
		
		JPanel pulsanti  = new JPanel();
		this.add(pulsanti, BorderLayout.SOUTH);
		
		JButton parti = new JButton("parti");
		pulsanti.add(parti);
		parti.addActionListener(a);
		
		JButton visualizza = new JButton("visualizza");
		pulsanti.add(visualizza);
		visualizza.addActionListener(a);
		
		JButton ferma = new JButton("ferma");
		pulsanti.add(ferma);
		ferma.addActionListener(a);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
