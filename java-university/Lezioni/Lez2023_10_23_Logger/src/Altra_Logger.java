import java.util.logging.*;

public class Altra_Logger {
	Logger log = Logger.getLogger("Altra");
	
	Altra_Logger(){
		log.warning("costruttore lanciato");
	}
	void metodo() {
		log.warning("metodo");
	}
	/** non fa nulla questo metodo
	 * 
	 * @param x
	 * @return
	 */
	
	int metodo(int x) {
		return 0;
	}
	
}
