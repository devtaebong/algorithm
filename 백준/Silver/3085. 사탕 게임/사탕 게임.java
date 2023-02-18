import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 사탕을 입력받는다.
        // 2. 인접한 두 칸을 골라 순서를 바꾼다.
        // 3. 같은색으로 가장 긴 연속 부분을 고른다.
        int n = Integer.parseInt(br.readLine());
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < board.length; j++) {
                board[i][j] = str.substring(j,j+1);
            }
        }

        int result = 0;
        // 임의의 칸을 하나 고른다
        // 인접한 칸의 사탕과 교환한다
        // 배열을 원래배열로 되돌린다.
        for (int i = 0; i < board.length; i++) {
            // 아래 칸의 사탕과 교환
            for (int j = 0; j < board.length - 1; j++) {
                String start = board[j][i];
                String next = board[j+1][i];
                board[j][i] = next;
                board[j+1][i] = start;
                int num = getMaxCandy(board);
                if (result < num) {
                    result = num;
                }
                board[j][i] = start;
                board[j+1][i] = next;
            }

            // 오른쪽 칸의 사탕과 교환
            for (int j = 0; j < board.length - 1; j++) {
                String start = board[i][j];
                String next = board[i][j+1];
                board[i][j] = next;
                board[i][j+1] = start;
                int num = getMaxCandy(board);
                if (result < num) {
                    result = num;
                }
                board[i][j] = start;
                board[i][j+1] = next;
            }
        }

        System.out.println(result);
    }

    public static int getMaxCandy(String[][] board) {
        int answer = 0;

        int count = 1;
        // 행에서 연속되는 사탕 개수 찾기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length-1; j++) {
                if (board[i][j].equals(board[i][j+1])) {
                    count++;
                } else {
                    count = 1;
                }
                if (answer < count) {
                    answer = count;
                }
            }
            count = 1;
        }

        // 열에서 연속되는 사탕 개수 찾기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - 1; j++) {
                if (board[j][i].equals(board[j+1][i])) {
                    count++;
                } else {
                    count = 1;
                }
                if (answer < count) {
                    answer = count;
                }
            }
            count = 1;
        }

        return answer;
    }
}
