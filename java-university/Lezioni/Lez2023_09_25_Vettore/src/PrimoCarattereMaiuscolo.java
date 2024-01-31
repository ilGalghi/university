//03
public class PrimoCarattereMaiuscolo {

	public static void main(String[] args) {
		String s;					//dichiaro stringa
		s = "una prova";			//stringa
		
		String m;					//dichiaro stringa
		m = "U" + s.substring(1);	//metodo "substring" per sottostringa a partire dal carattere 1
		
		System.out.println(s);	//stampo stringa
		System.out.println(s.charAt(0));
		System.out.println(m);	//stampo stringa

	}

}
