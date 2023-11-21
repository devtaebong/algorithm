import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    1. 아이디어
    - 학생들을 순서대로 줄을 세운다.
    - 줄에 현재 학생보다 키가 큰 학생의 인덱스를 찾는다.
    - 찾은 인덱스에 현재 학생을 insert
        - 9 -> [1,2,3,4,6,7,8,10] = arr.index(7)에 insert
        - count += arr.length - index
    - 리턴: 입력으로 주어진 번호 " " + count

    2. 시간복잡도
    - 입력 O(N)
    - O(20 * 20)
    - O(T*N^2)

    3. 자료구조
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            // 입력
            int[] line = new int[20];
            int n = sc.nextInt();
            for (int i = 0; i < 20; i++) {
                line[i] = sc.nextInt();
            }

            /*
            현재 학생보다 키가 크고 && 앞에있는 학생 리듀싱
             */
            int count = 0;
            for (int i = 0; i < line.length; i++) {
                int currentStudent = line[i];
                for (int j = 0; j < i; j++) {
                    if (line[j] > currentStudent) {
                        count++;
                    }
                }
            }
            System.out.println(n + " " + count);
        }
    }
}
