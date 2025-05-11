package week1;

abstract class Shape {
    abstract double calculateArea();

}

class Square extends Shape {
    private double s; // �Ѻ��� ����
    public Square(double s) {
        this.s = s;
    }
    double calculateArea() {// ���� ��� �żҵ带 �ϼ���Ŵ
        return s*s;
    }
}

class Circle extends Shape {
    private double r;//������
    public Circle(double r){
        this.r = r;
    }
    double calculateArea(){// ���� ��� �żҵ带 �ϼ���Ŵ
        return Math.PI*r*r;
    }

}

public class AbstractClassExample {
}
