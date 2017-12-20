import java.util.Random;

public class sortArray {
		
	public static void main (String[]args){
		static int [] provaArray = new int[100];
		Random numero =new Random();
		for(int i=0;i<.provaArray.length;i++){
			provaArray[i]=numero.nextInt(100);
		}
        int[] array=new int[provaArrat.length];
        for(int i=0;i<a.length;i++){
			array[i]=provaArray[i];
		}
        Thread t1=new Thread( () -> {bubbleSort(array);});
        time=System.nanoTime();
        t1.start();
        System.out.println((System.nanoTime()-time) / 1000000.0 + "ms");
	}
				
	public static void bubbleSort(int [] array) {
        for(int i = 0; i < array.length; i++) {
            boolean flag = false;
            for(int j = 0; j < array.length-1; j++) {
                if(array[j]>array[j+1]) {
                    int k = array[j];
                    array[j] = array[j+1];
                    array[j+1] = k;
                    flag=true; //È avvenuto lo scambio
                }
            }
            if(!flag) break; //L'array risulta ordinato ed interrompo il ciclo
        }
    }
}

		
