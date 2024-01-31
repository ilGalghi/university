import java.util.LinkedList;
import java.util.Scanner;


public class Insieme {

	public static void main(String[] args) {
		
		LinkedList<Persona> l = new LinkedList<Persona>();
			
		l.add(new Persona("Mario"));
		l.add(new Persona("Anna"));
		l.add(new Persona("Luca"));
		l.add(new Persona("Giovanni"));
			
		Scanner s = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome;
		Persona p = new Persona("Mario");
		Persona b = new Persona("Mario");
		
		while (true) {
			nome = s.nextLine();
			if (nome == "") {
				break;
			}
			p = new Persona(nome);
			System.out.println(l.contains(p));
		}
			
		

	}

}
