class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //전체 면적
        int sum = brown + yellow;
        
        // i : 세로 길이
        for(int i = 3; i < sum; i++) {
            // j : 가로 길이
            int j = sum  / i;
            
            if(sum % i == 0 && j >= 3) {
                // yellow 세로 길이
                int width = Math.max(i, j);
                // yellow 가로 길이
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