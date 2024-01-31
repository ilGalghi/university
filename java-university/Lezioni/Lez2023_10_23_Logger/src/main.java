import java.io.IOException;
import java.util.logging.*;


public class main {
	static Logger log = Logger.getLogger("principale");
	
	static void metodo() {
		log.warning("metodo iniziato");
	}
	@Override
	public String toString() {
		return "abcd";
	}

	public static void main(String [] args) throws SecurityException, IOException {
		Logger log = Logger.getLogger("Principale");
		
		int vettore[] = {7, -2, -4, 3, -2};
		int somma; 
		
		FileHandler handler = new FileHandler("log.txt");		//file creazione log
		//MioHandler handler = new MioHandler();				//mio file creazione
		SimpleFormatter sf = new SimpleFormatter();
		handler.setFormatter(sf);
		log.addHandler(handler);
		log.setUseParentHandlers(false); //doesn't display log in console
		
		//parentesi sul fatto che si può creare un oggetto main
		//main p = new main();
		//System.out.println(p);
		
		
		log.setLevel(Level.ALL);
		
		log.warning("main() iniziato");
		// -> handler.publish();
		//    -> sf.format();
		
		somma = 0;
		log.info("somma= " + somma);
			
		for (int i = 0; i< vettore.length; i++){
			log.info("somma= "+ vettore[i]);
			somma += vettore[i];
			
		}
		log.info("somma= "+ somma);
		if (somma > 0)
			System.out.println(somma);
		else 
			System.out.println("negativo");
		
		
		
		metodo();
		Altra_Logger a = new Altra_Logger();
		System.out.println(a);
		a.metodo(0);
		
	}

}
