class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 3; i < sum; i++){
            int j = sum  / i;
            
            if(sum % i == 0 && j >= 3){
                int width = Math.max(i, j);
                int height = Math.min(i, j);
                if(yellow == (width - 2) * (height - 2)){
                    answer[0] = width;
                    answer[1] = height;
                    return answer;
                }
            }
        }
        return answer;
    }
}