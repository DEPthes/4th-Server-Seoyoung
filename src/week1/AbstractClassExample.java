package week1;

abstract class Shape {
    abstract double calculateArea();

}

class Square extends Shape {
    private double s; // 한변의 길이
    public Square(double s) {
        this.s = s;
    }
    double calculateArea() {// 면적 계산 매소드를 완성시킴
        return s*s;
    }
}

class Circle extends Shape {
    private double r;//반지름
    public Circle(double r){
        this.r = r;
    }
    double calculateArea(){// 면적 계산 매소드를 완성시킴
        return Math.PI*r*r;
    }

}

public class AbstractClassExample {
}
