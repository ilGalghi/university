import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class MioStream2 extends InputStream{
	FileReader reader;
	MioStream2(FileReader r){
		this.reader = r;
	}
	char carattere;
	public MioStream2(char c) {
		this.carattere = c;
	}

	@Override
	public int read() throws IOException {
		int z;
		z = reader.read();
		if(Math.random() < 0.1)
			return 'X';
		return z;
		
	}
}

public class Mio2 {
	public static void main(String args[]) throws FileNotFoundException {

		MioStream2 m = new MioStream2('a');
		Scanner s = new Scanner(m);
		FileReader  r  = new FileReader("prova.txt");
		s = new Scanner(r);
		
		
	
		String y;
		while (s.hasNext()) {
			y = s.next();
			System.out.println(y);
		}	
		System.out.println("\n");
	
		s.close();
	}
}
