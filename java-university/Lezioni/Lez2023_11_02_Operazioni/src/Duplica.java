class Persona implements Cloneable{
	String nome;
	int nascita;
	Persona(String nome, int nascita){
		this.nome = nome;
		this.nascita = nascita;
	}
	public String toString() {
		return this.nome + " " + this.nascita;
	}

	public Object clone(){
		Persona p;
		try {
			p = (Persona) super.clone();
		} catch (CloneNotSupportedException e) {
			//e.printStackTrace();
			return null;
		}
		return p;
		
	}
}




public class Duplica {

	public static void main(String[] args) throws CloneNotSupportedException {
		Persona p = new Persona("Mario", 1999);
		
		
		//CASO 1
		Persona q;
		q = p;
		
		System.out.println("p: " + p);
		System.out.println("q: " + q);
		
		//p.nascita = 2000;
		q.nascita = 2000;                //cambia anche p, puntano allo stesso oggetto, quindi non è una copia separata 
		System.out.println("p: " + p); 
		System.out.println("q: " + q);

		
		
		
		//CASO 2
		System.out.println();
		Persona p2 = new Persona("Mario", 1999);
		//invece ad esempio facendo così risulteranno distinte, ma poco funzionale, perchè se non fosse una semplice persona, ma anche studente perderemo la matricola
		Persona q2 = new Persona(p2.nome, p2.nascita);
		System.out.println("p2: " + p2);
		System.out.println("q2: " + q2);
		
		//p2.nascita = 2000;
		q2.nascita = 2100;                
		System.out.println("p2: " + p2); 
		System.out.println("q2: " + q2);
		
		
		
		
		
		//CASO 3
		System.out.println();
		Persona p3 = new Persona("Mario", 1999);
		//metodo migliore perchè clona tutto l'oggetto indifferentemente da cosa sia
		Persona q3 = (Persona) p3.clone();
		System.out.println("p3: " + p3);
		System.out.println("q3: " + q3);
				
		//p3.nascita = 2000;
		q3.nascita = 2100;                
		System.out.println("p3: " + p3); 
		System.out.println("q3: " + q3);
		
	}

}
