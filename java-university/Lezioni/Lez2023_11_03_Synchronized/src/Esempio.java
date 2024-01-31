
public class Esempio {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Una a = new Una();
		
		Class b = a.getClass();  //oggetto classe : classe di a
		System.out.println(b);
		System.out.println(b.getDeclaredField("x"));
		System.out.println(b.getDeclaredMethods()[0]);
		System.out.println(b.getName());
	}

}
