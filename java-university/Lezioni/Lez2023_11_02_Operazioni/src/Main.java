public class Main {

	public static void main(String[] args) throws InterruptedException {
		Operazioni o = new Operazioni();
		Thread t = new Thread(o, "operazioni");
		System.out.println(t.getName());
		t.start();
		Thread.sleep(2500);
		t.interrupt();	
	}

}
