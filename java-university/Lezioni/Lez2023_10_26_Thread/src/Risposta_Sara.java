
import java.awt.event.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Attesa implements Runnable{
	Finestra_Sara finestra;
	double casuale;
	Logger log = Logger.getLogger("Parallelo");
	Attesa(Finestra_Sara finestra){
		this.finestra = finestra;
	}
	@Override
	public void run() {
		log.setLevel(Level.WARNING);
		this.finestra.etichetta.setText("iniziato");
		/*log.info("iniziato");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		for (int i = 5; i>=0; i--) {
			finestra.etichetta.setText("" + i);
			log.info("" + i);
			Random generator = new Random();
			casuale = 1 + generator.nextInt(101);			//tra 0 e 100 (101 escluso)
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		this.finestra.etichetta.setText("finito");		
		log.info("finito");
	}
	
}

public class Risposta_Sara  implements ActionListener  {
	Logger log = Logger.getLogger("Risposta");
	Finestra_Sara finestra;
	Attesa p = null;
	public Risposta_Sara(Finestra_Sara finestra){
		this.finestra = finestra;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("event: " + e.getActionCommand());
		
		if (e.getActionCommand().equals("parti")) {
			p = new Attesa(finestra);
			// p.run(); // esegue p normalmente, aspetta che finisca e poi esegue il resto
			Thread t = new Thread(p);
			t.start();    // esegui in parallelo p.run()  dove p è l'oggetto del costruttore
			
			//log.info("iniziato");
		}
		else if (e.getActionCommand().equals("visualizza")) {
			if ( p == null) {
				log.info("conteggio non inizializzato");
			}
			else
		        log.info("numero casuale: " + p.casuale);
			
		}
		
	}
	

}
