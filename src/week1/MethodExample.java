package week1;

public class MethodExample {

    public static void print() {// ���ް��� ���� �޼ҵ�
        System.out.println("�ȳ�?");
    }

    public static void print(int a) { //���ް��� �ִ� �޼ҵ�
        System.out.println(a);
    }

//    public static void add (int a, int b) { //���ް��� ���� �� �ִ� �޼ҵ�
//        System.out.println(a+b);
//    }

    public static int getMaxLottoNumber() {//����� ������ ���� ��ȯ
        return 45;
    }


    public static int add(int a, int b) {//����� ������ ���� ��ȯ
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a+b+c;
    }

    public static double add(double a, double b) {
        return a+b;
    }


    public static void main(String[] args) {
        print();
        print();

        print(3);
        print(10);

//        add(1,2);
//        add(3,5);

        int num = getMaxLottoNumber();
        System.out.println(num);

        int result = add(1,2);
        System.out.println("1 + 2 = " + result);

        System.out.println(add(1,2));
        System.out.println(add(1,2,3));
        System.out.println(add(5.3,3.8));
    }
}
