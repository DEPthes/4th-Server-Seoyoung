package week1;

class APerson {
    public void introduce() {
        System.out.println("����Դϴ�");
    }
}

public class AnonymousClassExample {
    public static void main(String[] args) {
        APerson person =  new APerson() {
            @Override
            public void introduce() {
                System.out.println("�͸��Դϴ�");
            }
        };
        person.introduce();
    }
}
