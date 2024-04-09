import java.util.*;

/*
System.out.println();
*/
class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        
        // parse to int
        List<Hotel> hotel = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String start = book_time[i][0];
            String end = book_time[i][1];
            
            hotel.add(new Hotel(parseToMinute(start), parseToMinute(end) + 10));
        }
        
        hotel.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        
        PriorityQueue<Hotel> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        
        int answer = 1;
        for (Hotel h : hotel) {
            if (pq.isEmpty()) {
                pq.offer(h);
                continue;
            }
            
            while (!pq.isEmpty() && pq.peek().end <= h.start) {
                pq.poll();
            }
            
            pq.offer(h);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    private int parseToMinute(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 
            + Integer.parseInt(s.substring(3, 5));
    }
}

class Hotel {
    int start;
    int end;
    
    public Hotel(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public String toString() {
        return "start = " + start + " end = " + end;
    }
}