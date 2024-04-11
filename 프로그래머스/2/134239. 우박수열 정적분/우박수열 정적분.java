import java.util.*;
/*
k (1 ~ 10000)

1. 아이디어

2. 시간복잡도

3. 자료구조


System.out.println(graph);
System.out.println(Arrays.toString(area));

*/
class Solution {
    List<Point> graph;
    
    public double[] solution(int k, int[][] ranges) {
        graph = new ArrayList<>();
        graph.add(new Point(0, k));
        
        int x = 1;
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            }
            else {
                k = k * 3 + 1;
            }
            graph.add(new Point(x++, k));
        }
        
        int n = x - 1;
        /*
        case2
        n = 7
        [1, -2] -> [1, 5] = 36
        [3, 4] -> area[3] = 12
        */ 
        
        double[] area = getArea();
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            
            answer[i] = getSum(a, b, n, area);
        }
        return answer;
    }
    
    // 각 구간별 합계
    private double[] getArea() {
        double[] area = new double[graph.size() - 1];
        
        // area[0] = 0 ~ 1
        // area[1] = 1 ~ 2
        // area[2] = 2 ~ 3
        
        for (int i = 0; i < graph.size() - 1; i++) {
            Point now = graph.get(i);
            Point next = graph.get(i + 1);
            
            area[i] = ((double)(now.y + next.y)) / 2;
        }
        
        return area;
    }
    
    private double getSum(int a, int b, int n, double[] area) {
        b = n + b;
        // area[0] = 0 ~ 1
        // area[1] = 1 ~ 2
        // area[2] = 2 ~ 3
        // area[3] = 3 ~ 4
        // area[4] = 4 ~ 5
        
        if (a == b) return 0;
        if (a > b) return -1;
        
        double res = 0;
        for (int i = a; i < b; i++) {
            res += area[i];
        }
        return res;
    }
}

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "[x = " + x + " y = " + y +"]";
    }
}