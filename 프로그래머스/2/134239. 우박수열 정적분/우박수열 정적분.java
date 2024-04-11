import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Point> graph = new ArrayList<>();
        graph.add(new Point(0, k));
        
        // n = k가 1이될때까지 수행되는 연산의 횟수
        int n = 0;
        while (k > 1) {
            n++;
            
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            
            graph.add(new Point(n, k));
        }
        
        // 1 ~ 4 -> memo[1] + memo[2] + .. + memo[3]
        // memo[0] = 0 ~ 1 
        // memo[1] = 1 ~ 2
        // memo[2] = 2 ~ 3
        // memo[3] = 3 ~ 4
        double[] memo = new double[n + 1];
        for (int i = 0; i < graph.size() - 1; i++) {
            Point now = graph.get(i);
            Point next = graph.get(i + 1);
            memo[i] = ((double) (now.y + next.y) / 2);
        }
        
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            answer[i] = getAreaRange(ranges[i][0], ranges[i][1], n, memo);
        }
        return answer;
    }
    
    private double getAreaRange(int a, int b, int n, double[] memo) {
        if (a == 0 && b == 0) {
            return Arrays.stream(memo).sum();
        }
        
        if (b < 0) {
            b = n + b;
        }

        if (a > b) {
            return -1;
        }
        
        if (a == b) {
            return 0;
        }
        
        double res = 0;
        for (int i = a; i < b; i++) {
            res += memo[i];
        }
        return res;
    }
}

class Point {
    int x;
    int y;
    
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "[x = " + x + " y = " + y + "]";
    }
}