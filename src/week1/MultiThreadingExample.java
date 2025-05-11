package week1;

// 음악 재생 쓰레드
class MusicThread extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("? 음악 재생 중...");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

// 메시지 보내기 쓰레드
class MessageThread extends Thread {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("? 메시지 전송!");
            try { Thread.sleep(500); } catch (Exception e) {}
            //실행 중인 쓰레드 잠깐 멈춤
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

        new MusicThread().start();     // 음악 재생 시작
        new MessageThread().start();   // 메시지 전송 시작
    }
}
