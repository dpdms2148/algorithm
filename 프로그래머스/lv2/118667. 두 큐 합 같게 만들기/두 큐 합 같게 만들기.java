class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] arr = new int[n*2];
        
        long total = 0;
        long sum = 0;
        for(int i=0; i<n; i++){
            total += queue1[i];
            arr[i] = queue1[i];
        }
        sum = total;
        
        for(int i=0; i<n; i++){
            total += queue2[i];
            arr[i+n] = queue2[i];
        }
        
        int count = 0;
        long goal = total/2;
        int startidx = 0;
        int endidx = n - 1;

        while(true) {
            if(count > (4*n)){//종료조건은 왜 4*n인가....
                return -1;
            }
            if(sum < goal){//현재 합이 목표보다 작으면 endidx를 늘려줌
                endidx++;
                if(endidx < 2*n){
                    sum += arr[endidx];
                }
            }else if(sum > goal){//현재 합이 목표보다 크면 startidx를 늘려줌
                if(startidx <= endidx){
                    sum -= arr[startidx];
                    startidx++;
                }else{//더이상 움직일 수 없음
                    return -1;
                }
            }else{
                break;
            }
            count++;
            
        }
        return count;
    }
}