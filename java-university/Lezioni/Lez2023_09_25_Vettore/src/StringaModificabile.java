//04
public class StringaModificabile {

	public static void main(String[] args) {
		StringBuffer s;			//dichiaro stringa
		s = new StringBuffer("abcd");	//inizializzo stringa (con virgolette)
		
		System.out.println(s);	//stampo stringa
		s.setCharAt(0, 'A');	//con metodo "setCharAt", cambio il carattere in posizione 0 con "A"
								//→ attenzione a mettere apice (') e non (") nel metodo
		System.out.println(s);	//stampo stringa (modificata)

	}

}
