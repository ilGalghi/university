class Uno implements Runnable{

	@Override
	public void run() {
		synchronized("abcd"){
			Arriva.x = 12;
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) { }
		
			Arriva.y = 12;
		}
	}
	
}

class Due implements Runnable{
	@Override
	public void run() {
		synchronized("abcd"){
			Arriva.x = -2;
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) { }
		
			Arriva.y = -2;
		}
	}
	
}



public class Arriva {
	static int x, y;
	public static void main(String[] args) throws InterruptedException {
		x = 4;
		
		
		Uno p = new Uno();
		Due s = new Due();
		
		Thread t1,t2;
		t1 = new Thread(p);
		t2 = new Thread(s);
		
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
		System.out.println(x);
		System.out.println(y);    
		//può capitare che stamperà due valori diversi, proprio perchè sono imprevedibili
	}
}








