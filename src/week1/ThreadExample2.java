package week1;

class MyTask extends Thread {
    public void run() {
        System.out.println("���� ������: " + Thread.currentThread().getName());
    }
}
public class ThreadExample2 {
    public static void main(String[] args) {
        MyTask t = new MyTask();

        System.out.println("== run() ȣ�� ==");
        t.run(); // main �����忡�� ����

        System.out.println("== start() ȣ�� ==");
        t.start(); //  ���ο� �����忡�� ����
    }
}
