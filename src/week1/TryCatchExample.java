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
        int index = 5; // �������� �ʴ� �ε���
        try{
            int result = numbers[index];
            System.out.println("���: " + result);
        } catch (Exception e) {
            System.out.println("���� �߻�");

        }

        try{
            int age = -5;
            if (age<0) {
                throw new Exception("���̴� ������ �� �����ϴ�.");// throw Ű���带 ���ؼ� ���ο� ���ܸ� �߻���ų �� ����.
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // throw�� �����ص� �޽����� catch�������� print �ϵ��� �� �� ����.

        }


        try{
            int result = 3/0;
        } catch (Exception e) {
            System.out.println("���� �߻�2");
        } finally {
            System.out.println("���� ����");
        }

        try{
            int result = 4/2;
        } catch (Exception e) {
            System.out.println("���� �߻�2");
        } finally {
            System.out.println("���� ����");
        }


        try{
            int age = -5;
            if (age<0) {
                throw new MyException("���̴� ������ �� �����ϴ�.");
            }
        } catch (Exception e) {
            System.out.println("�����߻�:" + e.getMessage());
        }


        try{
            divide(3,0);
        } catch (Exception e) {
            System.out.println("0���� ���� �� �����.");
        }
    }
}
