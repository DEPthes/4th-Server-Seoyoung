package week1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        // ������ 3��¥�� Ǯ ����
        ExecutorService pool = Executors.newFixedThreadPool(3);

//������ 3����  10���� �۾��� ���ư��鼭 ó���ϴ� ����
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pool.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(" [����] �۾� " + taskId + " | ������: " + threadName);
                try { Thread.sleep(1000); } catch (Exception e) {}
                System.out.println(" [�Ϸ�] �۾� " + taskId + " | ������: " + threadName);
            });
        }

        pool.shutdown(); // �۾� ������ ������ ����
    }
}

