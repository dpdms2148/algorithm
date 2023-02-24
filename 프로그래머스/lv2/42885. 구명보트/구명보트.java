import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //오름차순으로 정렬
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
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
        
        //아직 남아있는 사람이 있는 경우
        if(left == right) {
            answer++;
        }
        
        return answer;
    }
}