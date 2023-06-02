import java.util.PriorityQueue; 

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        // 방법 1. -1로 초기화한 후 모든 배열을 탐색하며
        // 자신보다 크면서 가장 가까이 있는 수를 찾는다.(시간초과)
        //
        // for(int i = 0; i < n; i++){
        //     answer[i] = -1;
        // }
        // for(int i = 0; i < n - 1; i++){
        //     for(int j = i + 1; j < n; j++){
        //         if(numbers[i] < numbers[j]){
        //             answer[i] = numbers[j];
        //             break;
        //         }
        //     }
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = n - 1; i > -1; i--){
            while(!pq.isEmpty()){//나보다 큰수 찾기
                if(pq.peek()>numbers[i]){//나보다 크면
                    answer[i] = pq.peek();
                    pq.add(numbers[i]);
                    break;
                }else{//나보다 작으면
                    pq.remove();
                }
            }
            if(pq.isEmpty()){//큐가 비어있으면 -1
                answer[i] = -1;
                pq.add(numbers[i]);
            }
        }
        
        return answer;
    }
}
