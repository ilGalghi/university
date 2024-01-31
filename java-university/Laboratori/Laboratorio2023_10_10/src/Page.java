import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Page {
	
	public static void main(String args[]) {
		JFrame finestra = new JFrame();
		JFrame fin = new JFrame();
		Risposta risp  = new Risposta();
		risp.finestra = finestra;
		risp.fin = fin;
		
		                              //FINESTA 1
		JTextArea testo = new JTextArea(10, 10); 
		finestra.add(testo, BorderLayout.CENTER);
		
		
		JPanel panel= new JPanel();
		finestra.add(panel, BorderLayout.SOUTH);
		
		LayoutManager pm = new GridLayout(1,4);
		panel.setLayout(pm);
		risp.testo = testo;
		JButton stampa = new JButton("stampa");
		panel.add(stampa);
		
		
		JButton cancella = new JButton("cancella");
		panel.add(cancella);
		
	
		JButton mostra = new JButton("mostra");
		panel.add(mostra);
		
		
		JButton esci = new JButton("esci");
		panel.add(esci);
		
		
		stampa.addActionListener(risp);
		cancella.addActionListener(risp);
		mostra.addActionListener(risp);
		esci.addActionListener(risp);
		
		                                 //FINESTA 2
		JLabel label = new JLabel();
		fin.add(label, BorderLayout.CENTER );
		
		risp.label = label;
		
		
		JButton ok = new JButton("ok");
		fin.add(ok, BorderLayout.SOUTH);
		
		ok.addActionListener(risp);
		
		
		
		finestra.pack();
		finestra.setVisible(true);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
	
}

