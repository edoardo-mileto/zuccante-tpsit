import java.util.concurrent.Semaphore;
import java.util.Random;

public class pizzeriaDaPeppiniello {
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer=new BoundedBuffer();
        Random gen=new Random();
        Thread t1 =null;
        int possibiliClienti=0, turno=0;
        final int clienti=14;
        int controllo=1+gen.nextInt(3);
        while(possibiliClienti<=clienti){
            int n=1+gen.nextInt(4);
            possibiliClienti=possibiliClienti+n;
            if(possibiliClienti>clienti)
                n=clienti-(possibiliClienti-n);
            turno++;
            System.out.println("vogliono entrare in pizzeria "+n+" clienti");
            for(int i=0; i<n; i++){
                t1 =new Thread(buffer);
                if(buffer.posti.availablePermits()==0){
                    System.out.println(t1.getName()+" sta aspettando fuori che si liberi un posto...");
                    t1.join();
                }
                t1.start();
                Thread.sleep(200);
            }
            if(turno==controllo)
                System.out.println("Il cameriere è passato tra i tavoli e ha contato " +buffer.posti.availablePermits()+ " posti disponibili");
            Thread.sleep(12000);
        }
    }
}

class BoundedBuffer implements Runnable{

    Semaphore posti;
    private Random gen=new Random();

    public BoundedBuffer(){
        posti = new Semaphore(12);
    }

    @Override
    public void run() {
        try {
            posti.acquire();
            System.out.println(Thread.currentThread().getName()+" è entrato in pizzeria. Ha occupato un posto e verrà servito");
            Thread.sleep(40000);
            int min=5, max=7;
            int random=((max-min)+1);
            int tempoPizza=gen.nextInt(random)+min;
            System.out.println(Thread.currentThread().getName()+" è stato servito e mangerà la sua pizza in "+tempoPizza+" minuti");
            Thread.sleep(tempoPizza*60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            posti.release();
            System.out.println(Thread.currentThread().getName()+" esce dalla pizzeria");
        }
    }
}
