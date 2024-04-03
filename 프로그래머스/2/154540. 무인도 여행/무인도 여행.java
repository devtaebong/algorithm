import java.util.*;
class Solution {
    private int n;
    private int m;
    private int[][] matrix;
    private boolean[][] check;
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        n = maps.length;
        m = maps[0].length();
        matrix = new int[n][m];
        check = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String s = maps[i];
            for (int j = 0; j < m; j++) {
                int x = s.charAt(j);
                if (x == 'X') {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = x - '0';
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > 0 && !check[i][j]) {
                    
                    int res = bfs(i, j);
                    if (res != 0) {
                        answer.add(res);
                    }
                }
            }
        }
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        return answer.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int bfs(int r, int c) {
        int res = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c, matrix[r][c]));
        check[r][c] = true;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // 5 + 1 + 9 + 2 + 3 + 
        while (!q.isEmpty()) {
            Point now = q.poll();
            res += now.l;
            
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + now.r;
                int nc = dc[i] + now.c;
                
                if (0 > nr || nr > n - 1 || 0 > nc || nc > m - 1) {
                    continue;
                }
                
                if (!check[nr][nc] && matrix[nr][nc] > 0) {
                    q.offer(new Point(nr, nc, matrix[nr][nc]));
                    check[nr][nc] = true;
                }
            }
        }
        
        return res;
    }
}

class Point {
    int r;
    int c;
    int l;
    
    public Point(int r, int c, int l) {
        this.r = r;
        this.c = c;
        this.l = l;
    }
    
    public String toString() {
        return "r = " + r + " r = " + r + " l = " + l;
    }
}