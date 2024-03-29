class Solution {
    public int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, 0, numbers, target);//탐색 깊이, 시작 값, 숫자 배열, 타겟 값
        return answer;
    }
    
    public void dfs(int depth, int value, int[] numbers, int target){
        if(depth == numbers.length) {
            if(value == target){
                answer += 1;
            }
            return;
        }
        dfs(depth + 1, value + numbers[depth], numbers, target);
        dfs(depth + 1, value - numbers[depth], numbers, target);
    }
}