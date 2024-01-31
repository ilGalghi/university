import java.awt.event.*;
import java.util.logging.*;

public class Ascoltatore implements ActionListener{
	Logger log = Logger.getLogger("Ascoltatore");
	Finestra finestra;
	Ascoltatore (Finestra finestra){
		this.finestra = finestra;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("event" + e.getActionCommand() );
		System.out.println("event " + e.getActionCommand());
		if(e.getActionCommand().equals("parti")){
			this.finestra.etichetta.setText("iniziato");
			//log.info("attesa");)
			//attesa
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			this.finestra.etichetta.setText("finito");
		}
		
	}
}
