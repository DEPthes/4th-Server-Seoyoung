package week1;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        //  for��
        for (int i = 0; i < 5; i++) {
            System.out.println("�ȳ�?");
        }

        System.out.println("---------------");

        //while��
        int i = 0;
        while (i < 5) {
            System.out.println("�ȳ�?");
            i++;
        }

        System.out.println("---------------");

        // do while
        int j = 0;
        do {
            System.out.println("�ȳ�?");
            j++;
        } while (j < 5);

        System.out.println("---------------");

        //���� �ݺ���
        for (int a = 0; a < 2; a++) {//1
            for (int b = 0; b < 3; b++) { //2
                System.out.println("�ȳ�?");
            }
        }

        System.out.println("---------------");

        // break
        for (int a = 0; a < 5; a++) {
            if (a == 3)
                break; // i�� 3�� �Ǹ� ��� �ݺ��� Ż��
            System.out.println("�ȳ�?");
        }

        System.out.println("---------------");

        for (int a = 0; a < 5; a++) {
            if (a == 2)
                continue;
            System.out.println("�ȳ�?");
        }
        System.out.println("---------------");

        //��
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

        //������ �迭 ��ȸ
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
