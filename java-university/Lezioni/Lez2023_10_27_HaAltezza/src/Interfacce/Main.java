package Interfacce;

public class Main {
	static boolean confronta(HaAltezza p, HaAltezza m){
		return Math.abs(p.getAltezza() - m.getAltezza()) < 5;
	}

	public static void main(String[] args) {
		PersonaFisica p = new PersonaFisica("Mario", 179);
		Muro m = new Muro(12.4,41.2,1.50);
		
		boolean b = confronta(p,m);
		System.out.println(b);
		
		PersonaFisica q = new PersonaFisica("Luigi", 182);
		b = confronta(p,q);
		System.out.println(b);
	}
}