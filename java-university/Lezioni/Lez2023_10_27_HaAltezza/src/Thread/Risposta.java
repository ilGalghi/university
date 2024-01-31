package Thread;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class Risposta  implements ActionListener  {
	Logger log = Logger.getLogger("Risposta");
	Finestra finestra;
	ContoRovescia p = null;
	Thread t;
	public Risposta(Finestra finestra){
		this.finestra = finestra;
		p = new ContoRovescia(finestra);
		t = new Thread(p);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("event: " + e.getActionCommand());
		
		if (e.getActionCommand().equals("parti")) {
			
			if (t.getState()==Thread.State.NEW) {
				log.info("lancio il thread");
				t.start();
			}
			else if (t.getState() == Thread.State.TERMINATED) {
				log.info("ricreo il thread");
				t = new Thread();
				t.start();
			}
			else {
				log.warning("esecuzione precedente non terminata"); 
			}
		}
		else if (e.getActionCommand().equals("visualizza")) {
			log.info("numero casuale: " + p.casuale);
		    log.info("stato thread: " + t.getState().toString());
			
		}
		else if  (e.getActionCommand().equals("ferma")) {
			log.info("ferma");
			if (t.getState()==Thread.State.TERMINATED || t.getState()==Thread.State.NEW) {
				return;				
			}
			log.info("attivo");
			t.interrupt();
			// = se il thread è in attesa, invia eccezione, altrimenti no
		}
		
	}
	

}
