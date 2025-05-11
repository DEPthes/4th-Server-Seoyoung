package week1;


class Animal {
    public void sound() {
        System.out.println("������ �Ҹ��� ����");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("�۸�!");
    }
}

class Cat extends Animal {
    public void sound() {
        System.out.println("�߿�~");
    }
}


public class PolymorphismExample {
    public static void main(String[] args) {
        Animal a1 = new Dog();   // Animal Ÿ�������� �����δ� Dog
        Animal a2 = new Cat();   // Animal Ÿ�������� �����δ� Cat

        a1.sound();  // �۸�!
        a2.sound();  // �߿�~

    }
}
