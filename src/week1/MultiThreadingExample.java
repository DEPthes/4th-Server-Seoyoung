package week1;

// ���� ��� ������
class MusicThread extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("? ���� ��� ��...");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

// �޽��� ������ ������
class MessageThread extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("? �޽��� ����!");
            try { Thread.sleep(500); } catch (Exception e) {}
            //���� ���� ������ ��� ����
        }
    }
}

public class MultiThreadingExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i<=5; i++) {
                System.out.println("thread1: "+i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i<=5; i++) {
                System.out.println("thread2: "+i);
            }
        });

        thread1.start();
        thread2.start();

        new MusicThread().start();     // ���� ��� ����
        new MessageThread().start();   // �޽��� ���� ����
    }
}
