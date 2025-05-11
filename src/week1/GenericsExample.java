package week1;



public class GenericsExample {

    //서로 다른 전달값을 받는 메소드 오버로딩 해서 생성
    //메소드 내의 동작은 모두 동일함.
//    public static void printValue(int value) {
//        System.out.println(value);
//    }
//    public static void printValue(double value) {
//        System.out.println(value);
//    }
//    public static void printValue(String value) {
//        System.out.println(value);
//    }

    //제네릭스 활용
    //세 개의 메소드 각각 정의할 필요 없이 어떤 데이터가 들어와도 똑같은 동작 수행.
    public static <T> void printValue(T value) {
        System.out.println(value);
    }
    public static void main(String[] args) {
        int intValue = 3;
        double doubleValue = 3.14;
        String stringValue = "안녕";

        printValue(intValue);
        printValue(doubleValue);
        printValue(stringValue);

    }
}
