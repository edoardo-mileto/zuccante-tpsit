package risorsecondivise;

public class Simul3 {
	public static void main (String[] args) {
		Risorse r1 = new Risorse("r1");
		Risorse r2 = new Risorse("r2");
		Thread t1 = new Thread(new Task(r1, r2));
		Thread t2 = new Thread(new Task(r2, r1));
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}catch(InterruptedException e){}
	}
}


		
		
