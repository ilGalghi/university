import java.awt.BorderLayout;

import javax.swing.*;

public class Finestra extends JFrame{
	public JLabel etichetta;

	Finestra(){
		etichetta = new JLabel(" ");
		this.add(etichetta, BorderLayout.CENTER);
		
		Ascoltatore a = new Ascoltatore(this);
		
		JPanel pulsanti = new JPanel();
		this.add(pulsanti, BorderLayout.SOUTH);
		JButton parti = new JButton("Parti");
		pulsanti.add(parti);
		parti.addActionListener(a);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
