package week1;

class SharedData {
    public int data = 0;
    //synchronized
    public void increment() {
        data++;
    }
}
public class SynchronizedExample {
    public static void main(String[] args) throws InterruptedException {
    SharedData sharedData = new SharedData();
    Thread thread1 = new Thread(() -> {
        for (int i = 0; i<1000; i++) {
            sharedData.increment();
        }
    });

    Thread thread2 = new Thread(() -> {
        for (int i = 0; i<1000; i++) {
            sharedData.increment();
        }
    });

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    //// thread1,2가 끝날 때까지 기다림. 이후에 sharedData 출력.

    System.out.println("SharedData: "+sharedData.data);
}
}
