package week1;

class MyTask extends Thread {
    public void run() {
        System.out.println("실행 스레드: " + Thread.currentThread().getName());
    }
}
public class ThreadExample2 {
    public static void main(String[] args) {
        MyTask t = new MyTask();

        System.out.println("== run() 호출 ==");
        t.run(); // main 스레드에서 실행

        System.out.println("== start() 호출 ==");
        t.start(); //  새로운 스레드에서 실행
    }
}
