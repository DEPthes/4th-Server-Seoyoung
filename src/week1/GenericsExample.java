package week1;



public class GenericsExample {

    //���� �ٸ� ���ް��� �޴� �޼ҵ� �����ε� �ؼ� ����
    //�޼ҵ� ���� ������ ��� ������.
//    public static void printValue(int value) {
//        System.out.println(value);
//    }
//    public static void printValue(double value) {
//        System.out.println(value);
//    }
//    public static void printValue(String value) {
//        System.out.println(value);
//    }

    //���׸��� Ȱ��
    //�� ���� �޼ҵ� ���� ������ �ʿ� ���� � �����Ͱ� ���͵� �Ȱ��� ���� ����.
    public static <T> void printValue(T value) {
        System.out.println(value);
    }
    public static void main(String[] args) {
        int intValue = 3;
        double doubleValue = 3.14;
        String stringValue = "�ȳ�";

        printValue(intValue);
        printValue(doubleValue);
        printValue(stringValue);

    }
}
