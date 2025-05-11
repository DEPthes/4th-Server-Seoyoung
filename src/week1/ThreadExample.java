package week1;

class MyThread extends Thread {
	public void run() {
    	for (int i=1; i<5; i++) {
         System.out.println("Thread:"+i);
        }
    }
}


public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i=1; i<= 5; i++) {
            System.out.println("Thread:"+i);
        }


        Thread thread = new Thread(() -> {
            for (int i = 1; i<=5; i++) {
                System.out.println("Thread: "+i);
            }
        });

        //join
        thread.start();
        thread.join(); // thread의 실행을 마칠 때까지 대기
        method();
    }

    public static void method() {
        for (int i = 1; i<=5; i++) {
            System.out.println("Method: "+i);
        }
    }
}
