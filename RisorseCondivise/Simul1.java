package risorsecondivise;

public class simul1{
	public static void main (String[] args){
		Risorse r = new Risorse("risorsa");
		Thread t1 = new Thread(new Task(r));
		Thread t2 = new Thread(new Task(r));
		t1.start();
		t2.start();
		try{
			thread1.join();
			thread2.join();
		}catch(InterruptedException e){}
	}
}
