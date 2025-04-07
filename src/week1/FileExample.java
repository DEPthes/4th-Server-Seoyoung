package week1;

import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        String fileName = "test.txt";
        File file = new File(fileName);

        try {
            file.createNewFile(); // 파일 생성
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String folderName = "test";
        File folder = new File(folderName);
        folder.mkdir(); // 폴더 생성


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"))) {
            // file 내용 쓸 때 BufferedWriter 사용.
            bw.write("감사합니다");
            bw.newLine();//줄바꿈
            bw.write("안녕히 계세요");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line=br.readLine()) != null) { // 한줄 씩 읽어온 결과를 line 변수에 저장
                System.out.println(line); //내용이 비어있지 않으면 한 줄씩 출력
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}