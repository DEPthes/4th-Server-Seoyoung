package week1;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        //  for문
        for (int i = 0; i < 5; i++) {
            System.out.println("안녕?");
        }

        System.out.println("---------------");

        //while문
        int i = 0;
        while (i < 5) {
            System.out.println("안녕?");
            i++;
        }

        System.out.println("---------------");

        // do while
        int j = 0;
        do {
            System.out.println("안녕?");
            j++;
        } while (j < 5);

        System.out.println("---------------");

        //이중 반복문
        for (int a = 0; a < 2; a++) {//1
            for (int b = 0; b < 3; b++) { //2
                System.out.println("안녕?");
            }
        }

        System.out.println("---------------");

        // break
        for (int a = 0; a < 5; a++) {
            if (a == 3)
                break; // i가 3이 되면 즉시 반복문 탈출
            System.out.println("안녕?");
        }

        System.out.println("---------------");

        for (int a = 0; a < 5; a++) {
            if (a == 2)
                continue;
            System.out.println("안녕?");
        }
        System.out.println("---------------");

        //배
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 5;
        numbers[2] = 10;
        System.out.println(Arrays.toString(numbers));
        System.out.println("---------------");


        int[] numbers2 = {1, 2, 3, 4, 5};

        for (int a = 0; a < numbers2.length; a++) {
            System.out.println(numbers2[a]);
        }

        for (int number: numbers2) {
            System.out.println(number);
        }

        System.out.println("---------------");

        //다차원 배열 순회
        int [][] numbers3 = new int [][] {
                {1,2,3,4,5},
                {6,7,8,9,10}
        };
        for (int a = 0; a < numbers3.length; a++) {
            for (int b = 0; b < numbers3[a].length; b++) {
                System.out.print(numbers3[a][b] + "\t");
            }
            System.out.println();
        }

    }
}
