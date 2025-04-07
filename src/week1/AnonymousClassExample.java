package week1;

class APerson {
    public void introduce() {
        System.out.println("사람입니다");
    }
}

public class AnonymousClassExample {
    public static void main(String[] args) {
        APerson person =  new APerson() {
            @Override
            public void introduce() {
                System.out.println("익명입니다");
            }
        };
        person.introduce();
    }
}
