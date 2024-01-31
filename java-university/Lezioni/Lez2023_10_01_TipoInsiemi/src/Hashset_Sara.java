import java.util.HashSet;
import java.util.Scanner;


public class Hashset_Sara {
	public static void main(String[] args) {
		HashSet<Persona2> l;
		l = new HashSet<Persona2>();
		l.add(new Persona2("Mario", 2003));
		l.add(new Persona2("Mario", 2005));
		l.add(new Persona2("Anna", 2001));
		l.add(new Persona2("Luca", 2004));
		l.add(new Persona2("Giovanna" ,1999));
		
		Scanner s = new Scanner (System.in);
		String nome;
		int nascita;
		Persona2 p = new Persona2("Mario", 2003);
		Persona2 b = new Persona2("Mario", 2005);
						
		while (true) {
			System.out.println("nome: ");
			nome = s.nextLine();
			System.out.println("nascita: ");
			nascita = s.nextInt();
			if (nome == "") {
				break;
			}
			
			p = new Persona2(nome, nascita);  
			
			System.out.println(l.contains(p)); 
			System.out.println(p.equals(b)); //da falso perchè non restituiscono lo stesso hashcode, non sono lo stesso oggetto
		
		}
	}
}