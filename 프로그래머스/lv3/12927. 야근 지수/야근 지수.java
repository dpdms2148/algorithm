import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }
        
        for(int i = 0; i < n; i++){
            if(pq.peek() == 0) break;
            pq.offer(pq.poll() - 1);
        }
        
        for(int i = 0; i < works.length; i++){
            int q = pq.poll();
            answer += q * q;
        }
        return answer;
    }
}