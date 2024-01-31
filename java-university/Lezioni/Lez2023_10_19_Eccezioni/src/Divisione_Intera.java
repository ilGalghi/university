

class DivisioneZero extends RuntimeException{
	int dividendo;
	DivisioneZero(int dividendo){
		this.dividendo = dividendo;
	}
}


public class Divisione_Intera {
	static int dividi(int a, int b) {
		if (b==0) {
			throw new DivisioneZero(a);
		}
		return a/b;
	}
	
	
	
	public static void main(String[] args) {
		
		try {
		System.out.println(dividi(4,2));
		System.out.println(dividi(4,0));			//ovviamente dà errore, posso catturare l'eccezione
		}
		
		catch (Exception e) {						//cattura eccezione di divisione per 0
			System.out.println("divisione per 0");
		}
	}

}
