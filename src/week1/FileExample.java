package week1;

import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        String fileName = "test.txt";
        File file = new File(fileName);

        try {
            file.createNewFile(); // ���� ����
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String folderName = "test";
        File folder = new File(folderName);
        folder.mkdir(); // ���� ����


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"))) {
            // file ���� �� �� BufferedWriter ���.
            bw.write("�����մϴ�");
            bw.newLine();//�ٹٲ�
            bw.write("�ȳ��� �輼��");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line=br.readLine()) != null) { // ���� �� �о�� ����� line ������ ����
                System.out.println(line); //������ ������� ������ �� �پ� ���
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}