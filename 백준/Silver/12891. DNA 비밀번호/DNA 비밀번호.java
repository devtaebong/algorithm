import java.io.*;
import java.util.*;

/*
0. 입력
- DNA 문자열: A, C, G, T 만으로 이루어진 문자열
- DNA 문자열이 주어지고, 해당 문자열로 만들 수 있는 부분 문자열의 개수
- 주어진 s의 길이만큼 문자열을 잘랐을때
    - 부분문자열로 만든 비밀번호의 문자가 특정 개수 이상이어야함

- 1 <= P <= 1_000_000 // DNA 문자열의 길이
- 1 <= S <= 1_000_000 // 비밀번호로 사용할 부분문자열의 길이

1. 아이디어
- 문자열 P를 S만큼 자른다. => O(P-S)
    - P: 7, S: 5
    - ABCDEFG -> (i < 0; i < P - S + 1)
        - ABCDE
        - BCDEF
        - CDEFG
- 자른 부분 문자열을 투포인터 탐색 => O(S)


2. 시간복잡도

3. 자료구조
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int S = input[0]; // DNA 문자열의 길이
        int P = input[1]; // 부분집합 길이
        String str = br.readLine();

        // A, C, G, T 의 필수 개수를 받은 배열
        int[] needCount = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Character, Integer> converter = new HashMap();
        converter.put('A', 0);
        converter.put('C', 1);
        converter.put('G', 2);
        converter.put('T', 3);
        int[] currentCount = new int[4];

        // 이전 상태 문자열
        for (int i = 0; i < P - 1; i++) {
            char c = str.charAt(i);
            currentCount[converter.get(c)]++;
        }

        // P: 4
        // ABCDEFGH
        // ABCD
        //  BCDE
        int res = 0;
        for (int i = P - 1; i < S; i++) {
            currentCount[converter.get(str.charAt(i))]++;

            if (isDNA(needCount, currentCount)) {
                res++;
            }

            currentCount[converter.get(str.charAt(i - P + 1))]--;
        }

//         answer
        System.out.println(res);
    }

    private static boolean isDNA(int[] needCount, int[] currentCount) {
        for (int i = 0; i < 4; i++) {
            if (needCount[i] > currentCount[i]) {
                return false;
            }
        }

        return true;
    }
}
