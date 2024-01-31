import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

public class Decomprimi_Ignora {
	public static void main() throws IOException {
		FileInputStream f = new FileInputStream("prova.zip");
						
		ZipInputStream z = new ZipInputStream(f);
		
		z.getNextEntry();
		
		Scanner sc = new Scanner(z); 
				
		//String s;
		sc.close();
	}

}
