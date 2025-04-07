package week1;


class Animal {
    public void sound() {
        System.out.println("동물이 소리를 낸다");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("멍멍!");
    }
}

class Cat extends Animal {
    public void sound() {
        System.out.println("야옹~");
    }
}


public class PolymorphismExample {
    public static void main(String[] args) {
        Animal a1 = new Dog();   // Animal 타입이지만 실제로는 Dog
        Animal a2 = new Cat();   // Animal 타입이지만 실제로는 Cat

        a1.sound();  // 멍멍!
        a2.sound();  // 야옹~

    }
}
