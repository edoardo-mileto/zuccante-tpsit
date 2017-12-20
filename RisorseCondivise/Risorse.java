package risorsecondivise;

import java.util.concurrent.Semaphore;

public class Risorse {
	Semaphore s;
	String nome;
	Risorse(String nome){
		this.s=new Semaphore(1);
		this.nome=nome;
	}
	
	public String getName(){
			return this.nome;
	}
	
	public Semaphore getSemaphore(){
		return this.s;
	}
}
