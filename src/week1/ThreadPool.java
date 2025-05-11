package week1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        // 스레드 3개짜리 풀 생성
        ExecutorService pool = Executors.newFixedThreadPool(3);

//스레드 3개가  10개의 작업을 돌아가면서 처리하는 구조
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pool.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(" [시작] 작업 " + taskId + " | 스레드: " + threadName);
                try { Thread.sleep(1000); } catch (Exception e) {}
                System.out.println(" [완료] 작업 " + taskId + " | 스레드: " + threadName);
            });
        }

        pool.shutdown(); // 작업 끝나면 스레드 정리
    }
}

