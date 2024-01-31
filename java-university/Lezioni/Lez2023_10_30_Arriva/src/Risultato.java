class Aumentatore implements Runnable {
	int n;
	@Override
	public void run() {
		System.out.println(this.n);
		this.n += 5;                //o qualsiasi altra operazione sul numero

	}
	

}


public class Risultato {
	
	public static void main(String[] args) throws InterruptedException {

		
		Aumentatore a = new Aumentatore();
		a.n = 10;
		System.out.println(a.n); 
		Thread t = new Thread(a);
		t.start();
		
	//	System.out.println(a.n);  //stampa lo stesso valore, non cambia con l'operazione fatta nella classe perchè è imprevedibile l'andamento temporale dei thread, la print viene fatta prima ancora che il thread modifichi il valore

	//	Thread.sleep(1000);         //aggiungendo un tempo di delay il codice ha il tempo di modificare
		
		t.join();                  //metodo migliore, letteralmente vuol dire 'aspetta che l'altro abbia terminato'
		System.out.println(a.n); 
	}

}
