import java.io.IOException;

public class Input {
	public static void main (String args[]) throws IOException {
		int x;
		System.out.println("inserisci: ");
		
		for(int i = 0; i < 7; i++) {
			x = System.in.read();
			System.out.println(" ho letto " + x);
		}
	}
}
