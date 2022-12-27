class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        for(int i = 0; i < n + 1; i++){
            arr[i] = i;
        }
        
        int start = 1;
        int end = 1;
        int sum = 1;
        while(true){
            if(sum < n){
                end++;
                sum += end;
            }else if(sum > n){
                sum -= start;
                start++;
            }else if(sum == n){
                answer++;
                sum -= start;
                start++;
            }
            
            if(start > n) break;
        }
        
        return answer;
    }
}