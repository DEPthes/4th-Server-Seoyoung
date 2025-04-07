package week1;

interface IShape {
    double calculateArea();
}

class ISquare implements IShape {
    private double s;
    public ISquare(double s) {
        this.s = s;
    }
    public double calculateArea() {
        return s*s;
    }
}


class ICircle implements IShape {
    private double r;
    public ICircle(double r) {
        this.r = r;
    }
   public double calculateArea() {
        return Math.PI*r*r;
    }

}
public class InterfaceExample {
}
