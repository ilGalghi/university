//10
public class Vettore5_Object {

	public static void main(String[] args) {
		Object[] s;				//dichiaro Object (jolly per tutto)
		s = new Object[3];		//inizializzo Vettore Object con dimensione 3
		String a = "nome";
		s[0] = a;
		StringBuffer b = new StringBuffer("Carlo");		//dichiaro e inizializzo StringBuffer
		s[1] = b;
		s[2] = "Luca";
		System.out.println(s[0]);
		System.out.println(s[1]);
		System.out.println(s[2]);
				
	}

}
