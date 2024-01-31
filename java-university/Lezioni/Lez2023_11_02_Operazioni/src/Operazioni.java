public class Operazioni implements Runnable{

	@Override
	public void run() {
		System.out.println("inizio");
		try { Thread.sleep(2000); }catch (InterruptedException e){System.out.println("interruzione ricevuta"); return; }
		System.out.println("uno");
		try { Thread.sleep(2000); }catch (InterruptedException e){System.out.println("interruzione ricevuta"); return;}
		System.out.println("due");
		try { Thread.sleep(2000); }catch (InterruptedException e){System.out.println("interruzione ricevuta"); return; }
		System.out.println("tre");
		try { Thread.sleep(2000); }catch (InterruptedException e){System.out.println("interruzione ricevuta"); return; }
		System.out.println("fine");
		try { Thread.sleep(2000); }catch (InterruptedException e){System.out.println("interruzione ricevuta"); return; }
		
		
		
		for(int i = 0; i < 10000000; i++) {
			System.out.println(".");
			if(Thread.currentThread().isInterrupted()) {    //se lo creo senza thread allora devo inserire io l'uscita dal thread a mano se dovesse capitare
				System.out.println();
				System.out.println("thread interrotto");
				return;
			}
		}
	}

}
