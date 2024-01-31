//05
import java.util.Date;

public class Data {

	public static void main(String[] args) {
		Date d;
		d = new Date();
		System.out.println(d);				//stampa data
		
		System.out.println(d.getMonth());	//stampa mese - deprecato (attenzione: Gennaio = 0)
		d.setMonth(11);				//imposta mese a 11 (dicembre)

		System.out.println(d);				//stampa nuova data

	}
}
