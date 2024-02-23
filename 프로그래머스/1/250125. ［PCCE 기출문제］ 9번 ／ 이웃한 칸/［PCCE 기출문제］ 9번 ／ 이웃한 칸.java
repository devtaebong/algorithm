import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {    
        int n = board.length;
        int m = board[0].length;
        
        int answer = 0;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + h;
            int nc = dc[i] + w;
            
            if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                if (board[nr][nc].equals(board[h][w])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}