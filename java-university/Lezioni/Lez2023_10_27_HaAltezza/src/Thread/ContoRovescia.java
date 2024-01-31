package Thread;


import java.util.logging.Logger;

class ContoRovescia implements Runnable{
	Finestra finestra;
	double casuale;
	
	Logger log = Logger.getLogger("Parallelo");
	ContoRovescia(Finestra finestra){
		this.finestra = finestra;
	}
	@Override
	public void run() {
		//log.setLevel(Level.WARNING);
		this.finestra.etichetta.setText("iniziato");
		log.info("iniziato");
		for (int i = 5; i>=0; i--) {
			finestra.etichetta.setText("" + i);
			log.info("" + i);
			this.casuale = Math.random();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				log.warning("attesa interrotta");
				return; //interrompe il thread, se non la metto interrompe lo sleep ma prosegue l'esecuzione
			}
		}
		
		this.finestra.etichetta.setText("finito");		
		log.info("finito");
		
		int sec = (int) (Math.random()*5);
		try {
			Thread.sleep(sec*1000);
		}
		catch (InterruptedException e1) {
			log.warning("attesa interrotta");
			return;
		}
	}
	
}
