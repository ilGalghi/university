/* succedono cose prima e dopo del main
 * 
 * succede
 * 
 * Main.main(...)
 * 
 * if (non sono state create finestre)
 * 		System.exit(0);
 * while (ci sono eventi){
 * 		gestisci prossimo evento:
 * 			chiama ascoltatori se ci sono
 * 			es: a.actionPerformed();
 * 
 * }
 * 
 * 
 * 
 * 
 * */
package Thread;

public class Main {

	public static void main(String[] args) {
		Finestra finestra = new Finestra();

	}

}
