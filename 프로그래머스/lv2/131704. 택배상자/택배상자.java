import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        //보조 컨테이너(스택 사용)
        Stack<Integer> subContainer = new Stack<>();
        
        for(int i = 1; i <= order.length; i++){
            //현재 박스번호가 실어야 하는 박스 번호와 다를 때
            if(order[answer] != i){
               subContainer.push(i);
                continue;
            }
            //현재 박스번호가 실어야 하는 박스 번호와 같을 때
            answer++;
            
            //보조 컨테이너에 실을 수 있는 박스는 다 싣기
            while(!subContainer.isEmpty() && subContainer.peek() == order[answer]){
                subContainer.pop();
                answer++;
            }
        }
        
        return answer;
    }
}