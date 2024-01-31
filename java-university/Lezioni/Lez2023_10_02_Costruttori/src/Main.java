import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> s= new LinkedList<Integer>();			//lista di int
																	//con lista di oggetti potrei mettere qualsiasi cosa
		System.out.println(s);
		int x = 3;			// intero
					// "y" è puntatore ad "o"
		
		s.add(x);
		System.out.println(s);
		
		Integer o = 25;
		int y = o;
		s.add(y);
		System.out.println(s);
		
		s.add(-3);
		s.add(0);
		s.add(2);
		
		System.out.println();
		
		System.out.println(s);
		System.out.println("Terzo elemento: " + s.get(2));			//stampa terzo elemento di s
		
		System.out.println();		//riga vuota
		
		System.out.println(s.toString());
		
		for (int j: s) {							// for elemento j in s (j assume valori di s)
			System.out.println("elem: " + j);
		}
		
		System.out.println();		//riga vuota
		
		
		System.out.println(s.contains(-3));
		Iterator <Integer> i = s.iterator();			//è elemento iteratore
		
		System.out.println();		//riga vuota
		
		while(i.hasNext()) {
			int k = (int) i.next();			//attenzione a non mettere System.out.println(i.next()) che sennò fa 2 volte l'operazione
			System.out.println(k);
		}
		
		//LIST								//ORDINE CHE DICO IO
		//HASHSET							//INSIEME mette in ordine casuale	(non ha come classe SET)
		//INSIEMI(set) e TREESET			//TREE in ordine cresce (ordine naturale)
											
		
	}
}
