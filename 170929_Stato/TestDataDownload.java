import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDataDownload {

    public static void main(String[] args) {
        DataDownloader ddl = new DataDownloader();
        Thread td = new Thread(ddl, "DataDownloaderThread");
        Thread tn = new NetworkConnection(td, "NetworkConnectionThread");
        tn.start();
        td.start();
    }
}

class DataDownloader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Connecting: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Download finished: %s\n",new Date());
    }
}

class NetworkConnection extends Thread implements Observed{

    private Thread td; // the downloadr
	private Observe observer;
	
    NetworkConnection(Thread td, String name) {
        super(name);
        this.td = td;
    }

    @Override
    public void run() {
        System.out.printf("Network connected: %s\n", new Date());
        try {
            
			observer = new Observe(Thread.currentThread());
            Thread observed = new Thread(new Observe(Thread.currentThread()),"TD");
            observed.start();   
            td.join();  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network not connected: %s\n",new Date());
    }

	@Override
	public void setObserver(Observer o) {
		this.observer = (Observe)o;
	}

	@Override
	public void notify() {
		this.observer.update();
	}

    class Observe implements Runnable, Observer {

        private Thread observeThread;
		
		
        private Observe(Thread currentThread) {
            this.observeThread = currentThread;
        }

        @Override
        public void run() {
            
            if (observeThread.isAlive()) {   
                update();
            }
        }

		@Override
		public void update() {
			System.out.println(observeThread.getName() +' '+observeThread.getState().name());
		}

		@Override
		public void setObserved(Observed o) {
			this.observeThread = (Thread)o;
		}

    }
}
