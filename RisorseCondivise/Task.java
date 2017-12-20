package risorsecondivise;

public class Task implements Runnable {
    private Risorse r1;
    private Risorse r2;
    
    public Task(Risorse r) {
        r1=r;
    }
    
    public Task(Risorse r1, Risorse r2) {
        this.r1=r1;
        this.r2=r2;
    }
   
    @Override
    public void run() {
        if(r2==null) {
            System.out.println(Thread.currentThread().getName()+": acquisisce la risorsa "+r1.getName());
            r1.s.release();
            System.out.println(Thread.currentThread().getName()+": rilascia la risorsa " + r1.getName());
        } else {
            System.out.println(Thread.currentThread().getName()+": acquisisce la risorsa "+r1.getName());
            System.out.println(Thread.currentThread().getName()+": acquisisce la risorsa "+r2.getName());
            r1.s.release();
            System.out.println(Thread.currentThread().getName()+": rilascia la risorsa " + r1.getName());
            r2.s.release();
            System.out.println(Thread.currentThread().getName()+": rilascia la risorsa " + r2.getName());
        }
    }
}