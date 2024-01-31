
public class Collegamento {

	public static void main(String[] args) {
		Persona p = new Persona("Mario", 1999);
		CartaIdentita c = new CartaIdentita("FE34355");
		
		p.carta = c;
		c.persona = p;
		
		System.out.print(p.nome + " -> " + p.carta.numero);		
		System.out.println(" -> " + p.carta.persona.nome);
		
		//fin qui tutto bene
		
		//Mario perde CartaIdentita, comune rilascia una nuova
		p.carta = new CartaIdentita("HE4880");
		p.carta.persona = p;
		
		System.out.print(p.nome + " -> " + p.carta.numero);		
		System.out.println(" -> " + p.carta.persona.nome);
		
		System.out.println(c.numero + " -> " + c.persona.nome);
		
		
		//Creare setCarta per modificare la carta

	}

}
