//thread in generale viene definito lock
//thread in java invece viene definito monitor

class Contatore{
	int progressivo = 0;   //quante volte chiama incrementa
	/*synchronized*/ void incrementa() {        //si può mettere anche direttamente all'inizio della funzione
		int x;
		synchronized(this) {    //aggiungendo questo avverrà veramente un numero progressivo, l'idea è che crea un unica stanza, quindi se c'è gia un thread che sta eseguendo questa funzione allora gli altri thread aspettano fino a che non terminano tutte le azioni precedenti dentro alla funzione
			//il nome è solo un segnaposto, il nome della stanza, potevamo metterne qualunque altro
			x = progressivo;
			x++;
			try {Thread.sleep(500);} catch (InterruptedException e) {}   //con synchronized quindi la sleep non sarebbe neanche necessaria
			progressivo = x;
			System.out.println(progressivo);
		}
	}
}



class Incrementa implements Runnable{
	Contatore c;
	@Override
	public void run() {
		//int x;
		for(int i = 0; i < 5; i++){
			/*
			x = Principale.progressivo;
			x++;
			//try {Thread.sleep(500);} catch (InterruptedException e) {}   //senza questo verrebbero valori sballati, ma comunque non ci sarebbe un vero incremento
			Principale.progressivo = x;
			System.out.println(Principale.progressivo);
			*/
			c.incrementa();
		}
	}
}



public class Principale {
	//static int progressivo;
	
	public static void main(String[] args) throws InterruptedException {
		Contatore c = new Contatore();
		Incrementa a = new Incrementa();
		Incrementa b = new Incrementa();
		a.c = c;
		b.c = c;
		Thread uno = new Thread(a, "uno");
		Thread due = new Thread(b, "due");
		//a.run();
		
		System.out.println(c.progressivo);
		
		uno.start();
		due.start();
		

	}

}














