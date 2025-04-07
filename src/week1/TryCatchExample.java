package week1;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class TryCatchExample {
    public static int divide(int a, int b) throws Exception {
        return a/b;
    }


    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        int index = 5; // 존재하지 않는 인덱스
        try{
            int result = numbers[index];
            System.out.println("결과: " + result);
        } catch (Exception e) {
            System.out.println("문제 발생");

        }

        try{
            int age = -5;
            if (age<0) {
                throw new Exception("나이는 음수일 수 없습니다.");// throw 키워드를 통해서 새로운 예외를 발생시킬 수 있음.
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // throw에 정의해둔 메시지를 catch구문에서 print 하도록 할 수 있음.

        }


        try{
            int result = 3/0;
        } catch (Exception e) {
            System.out.println("문제 발생2");
        } finally {
            System.out.println("실행 종료");
        }

        try{
            int result = 4/2;
        } catch (Exception e) {
            System.out.println("문제 발생2");
        } finally {
            System.out.println("실행 종료");
        }


        try{
            int age = -5;
            if (age<0) {
                throw new MyException("나이는 음수일 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("문제발생:" + e.getMessage());
        }


        try{
            divide(3,0);
        } catch (Exception e) {
            System.out.println("0으로 나눌 수 없어요.");
        }
    }
}
