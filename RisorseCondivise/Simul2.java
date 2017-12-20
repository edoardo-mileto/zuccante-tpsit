package risorsecondivise;

public class Simul2{
	public static void main (String[] args){
		Risorse r1 = new Risorse("risorsa1");
		Risorse r2 = new Risorse("risorsa2");
		Thread t1 = new Thread(new Task(r1, r2));
		Thread t2 = new Thread(new Task(r1, r2));
		t1.start();
		t2.start();