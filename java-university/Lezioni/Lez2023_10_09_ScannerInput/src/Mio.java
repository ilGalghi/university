import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class MioStream extends InputStream{
	@Override
	public int read() throws IOException {
		if(Math.random() < 0.1)
			return ' ';
		return 'x';
	}
}

public class Mio {
	public static void main(String args[]) throws FileNotFoundException {

		MioStream m = new MioStream();
		Scanner s = new Scanner(m);
	
		String y;
		while (s.hasNext()) {
			y = s.next();
			System.out.println(y);
		}	
		System.out.println("\n");
	
		s.close();
	}
}
