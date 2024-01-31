//VALORI MAPPA

import java.util.*;		//importi tutto
public class Main2 {
	public static void main(String[] args) {
		Map<Integer,String> m;						//MAPPA è come DIZIONARIO
		m = new TreeMap <Integer, String>();
		m.put(3, "ABCD");
		m.put(34, "qqqq");
		m.put(2, null);
		
		System.out.println(m);
		System.out.println(m.get(1));	//stampa valore chiave 1 (null)
		System.out.println(m.get(3));	//stampa valore chiave 3
		
		System.out.println(m.containsKey(2));	//contiene chiave 2
		
		System.out.println();			//riga vuota
		
		Set<Integer> s = m.keySet();
		for (int x : s) {
			System.out.println(x);
		}
		

	}

}
