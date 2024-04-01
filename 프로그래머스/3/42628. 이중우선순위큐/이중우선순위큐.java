import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            String cmd = s[0];
            int num = Integer.parseInt(s[1]);
            
            if (cmd.equals("I")) {
                maxPq.offer(num);
                minPq.offer(num);
            }
            
            if (minPq.isEmpty() || maxPq.isEmpty()) {
                continue;
            }
            // 최댓값 삭제
            else if (cmd.equals("D") && num == 1) {
                int x = maxPq.poll();
                minPq.remove(x);
            } 
            
            // 최솟값 삭제
            else if (cmd.equals("D") && num == -1) {
                int x = minPq.poll();
                maxPq.remove(x);
            }
        }
        
        if (maxPq.isEmpty()) {
            return new int[] {0, 0};
        }
        
        int[] res = new int[2];
        res[0] = maxPq.poll();
        res[1] = minPq.poll();
        return res;
    }
}