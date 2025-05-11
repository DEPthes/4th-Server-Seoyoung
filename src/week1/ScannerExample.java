package week1;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력: ");
        int number = sc.nextInt();
        System.out.println("입력된 정수: "+ number);
    }
}
