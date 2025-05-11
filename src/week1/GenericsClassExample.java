package week1;

class BoxInteger {//정수를 담을 수 있는 Box 클래스
    int data;
    public void setData(int data){
        this.data =data;
    }
}

class BoxString {//문자열을 담을 수 있는 Box 클래스
    String data;
    public void setData(String data){
        this.data =data;
    }
}

class Box<T> {// 모두 담을 수 있는 Box 클래스
    T data;
    public void setData(T data) {
        this.data = data;
    }


}
public class GenericsClassExample {
    public static void main(String[] args) {

//        BoxInteger iBox = new BoxInteger();
//        iBox.setData(3); //정수 담기
//
//        BoxString sBox = new BoxString();
//        sBox.setData("안녕"); //문자열 담기

        //서로 다른 자료형에 대해 하나의 클래스로 같은 동작 수행가능
        //클래스의 뒤에 어떤 자료형을 담을지 정의
        Box<Integer> iBox = new Box<>();
        iBox.setData(3); //정수 담기

        Box<String> sBox = new Box<>();
        sBox.setData("안녕");

    }
}