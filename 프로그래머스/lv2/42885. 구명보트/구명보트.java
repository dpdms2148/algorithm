import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        
        while(left < right){
            
            if(people[left] + people[right] <= limit) {
                //둘이 같이 배에 탈 수 있으므로 모두 배에 탄다
                left++;
                right--;
            } else {
                //둘이 같이 배에 탈 수 없으므로 무게가 무거운 사람만 배에 탄다
                right--;
            }
            
            answer++;
        }
        
        if(left == right) {
            answer++;
        }
        
        return answer;
    }
}