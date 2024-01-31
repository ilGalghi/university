//etichetta e 3 pulsanti
// primo pulsante: mette "iniziato" nell'etichetta
// aspetta cinque secondi contando nell'etichetta
// mette finito nell'etichetta
//genera ogni volta un numero casuale, non lo scrive da nessuna parte
// 
// secondo pulsante  "visualizza" : 
// mostra il numero casuale nei log



import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Finestra_Sara extends JFrame {
	JLabel etichetta;
	Finestra_Sara(){
		etichetta = new JLabel(" ");
		this.add(etichetta, BorderLayout.CENTER);
		Risposta_Sara a = new Risposta_Sara(this);
		
		JPanel pulsanti  = new JPanel();
		this.add(pulsanti, BorderLayout.SOUTH);
		
		JButton parti = new JButton("parti");
		pulsanti.add(parti);
		parti.addActionListener(a);
		
		JButton visualizza = new JButton("visualizza");
		pulsanti.add(visualizza);
		visualizza.addActionListener(a);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
