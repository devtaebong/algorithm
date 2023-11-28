import java.io.*;
import java.util.Arrays;

public class Main {
    /*
    0. 입력
    - x: 참가자들의 수
    - n: 스테프의 수
    - 스태프와 득표수가 주어진다.
    - 대회 참가자의 5% 미만 득표는 후보에서 제외한다.
    - 받은 득표수를 1 ~ 14로 나눈 값을 구한다 -> 결과가 스태프의 점수들이다.
    - 점수가 큰 순서대로 칩을 1개씩 나눠준다.
    - 칩에 비례해서 수고비를 나누어 준다.

    1. 아이디어
    - 득표수가 5% 미만인 스태프는 출력에서 제외한다.
    - 각 스테프마다 점수를 1 ~ 14로 나누어 점수집합을 구한다.
    - 점수집합에서 가장 큰 점수를 구한뒤 칩을 1개 나누어준다.
    - 스태프의 이름과 받은 칩의 개수를 이름순으로 출력한다.

    2. 시간복잡도
    - 득표율 계산: O(N)
    - 점수집합 구하기: O(N)
    - 점수가 가장 큰 스태프에게 칩 나누어주기: O(N^2)
    - O(N) + O(N^2)

    3. 자료구조
    int[][]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine()); // 전체 참가자의 수
        int n = Integer.parseInt(br.readLine()); // 스태프의 수
        int[][] pointSet = new int[26][14];
        int[] result = new int[26];
        boolean[] check = new boolean[26];
        Arrays.fill(result, 0);

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            char staff = s[0].charAt(0);
            int point = Integer.parseInt(s[1]);

            // 득표수가 5프로 이상인 스태프의 점수집합을 구한다.
            if (!voteResult(x, point)) {
                result[(int) staff - 'A'] = -1;
            } else {
                check[(int) staff - 'A'] = true;
                calculatePointSet(pointSet, point, staff);
            }
        }

        // 점수집합을 돌면서 14개의 칩을 나누어준다.

        int count = 14;
        while (count-- > 0) {
            int max = -1; int row = -1; int col = -1;

            for (int i = 0; i < pointSet.length; i++) {
                for (int j = 0; j < 14; j++) {
                    if (pointSet[i][j] > max) {
                        row = i;
                        col = j;
                        max = Math.max(max, pointSet[i][j]);
                    }
                }
            }
            result[row]++;
            pointSet[row][col] = -1;
        }

        String ans = "";
        for (int i = 0; i < 26; i++) {
            if (check[i]) {
                ans += (char) (i+'A') + " " + result[i] + "\n";
            }
        }
        System.out.println(ans);
    }

    public static boolean voteResult(int x, int point) {
        return (point * 100) / x >= 5;
    }

    public static void calculatePointSet(int[][] pointSet, int point, char staff) {
        int row = (int) (staff - 'A');

        for (int i = 0; i < 14; i++) {
            int result = point / (i+1);
            pointSet[row][i] = result;
        }
    }
}
