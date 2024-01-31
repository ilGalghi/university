import java.net.UnknownHostException;

//posso creare la mia classe eccezione
class MiaEccezione extends Exception{			//Object non lanciabile (con RuntimeException, non ho bisogno di throws nel main)
												//tranquillamente lanciabile
}





public class Mia {

	public static void main(String[] args) throws UnknownHostException, MiaEccezione {
		UnknownHostException e;			//un normale oggetto
		
		e = new UnknownHostException();
		System.out.println(e.toString());
		
		/*
		UnknownHostException a[] = new UnknownHostException[3];
		a[0] = e;
		System.out.println(a[0]);
		*/
		
		if (true)				//non entra con false
			throw e;
		
		System.out.println("fine");
		
		
		String s = "abcd";
		//throw s;				//"s" non è eccezione, non è un oggetto lanciabile
	}

}
