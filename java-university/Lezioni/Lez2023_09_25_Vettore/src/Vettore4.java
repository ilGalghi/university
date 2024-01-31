//09
public class Vettore4 {

	public static void main(String[] args) {
		String[] s;				//dichiaro stringa
		s = new String[3];		//inizializzo Vettore stringa con dimensione 3
		String a = "nome";
		s[0] = a;
		StringBuffer b = new StringBuffer("Carlo");
		//s[1] = b;				//dà errore perché non può convertere StringBuffer to String
		s[2] = "Luca";
		System.out.println(s[0]);
		System.out.println(s[1]);
		System.out.println(s[2]);
		
		//dà errore: non si può convertire StringBuffer to String (del vettore)
		
		
	}

}
