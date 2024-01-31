//lancia due thread
//ognuno stampa i numeri da uno a cinque

//garanzie:
//- ogni thread eseguito in seguenza 
//- ogni thread prima o poi eseguito

class Primo implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println("Primo finito");
	}

}


class Secondo implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <= 8; i++) {
			System.out.println(i);
		}
		System.out.println("Secondo finito");
	}

}


public class Main {

	public static void main(String[] args) {
		Primo p = new Primo();
		Secondo s = new Secondo();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(s);
		
		t1.start();    //p.run() in parallelo
		t2.start();    //s.run() in parallelo
		
		//a differenza della run non è preciso linearmente, ma i risultati escono casualmente 
        //non eseguono in ordine come nella run, eseguono contemporaneamente
	}

}
