import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class Vari {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner s;
		s = new Scanner(System.in); //leggi da tastiera
		s = new Scanner("abcd efgh"); //leggi da stringa
		s = new Scanner(new FileReader("prova.txt")); // leggi da file
		// il file può essere un file che va decrittato o decompresso, ci sono metodi per risolvere istantamìneamente il problema
		
		
		//System.out.println("inserisci: ");
		
		//s.nextLine();
		String y;
		while (s.hasNext()) {
			y = s.next();
			System.out.println(y);
		}	
		System.out.println("\n");
		
	    /*int x;
		while (s.hasNextInt()) {
			x = s.nextInt();
			System.out.println(x+2);			
		}*/
		s.close();
	}
}
