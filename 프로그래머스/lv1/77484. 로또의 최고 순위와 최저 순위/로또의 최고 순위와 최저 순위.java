class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win_nums_counts = 0;//일치하는 번호의 수
        int lottos_zero_counts = 0;//로또에서 알아볼 수 없는 번호의 수
        
        for(int i = 0; i < 6; i++) {
            if(lottos[i] == 0){
                lottos_zero_counts++;
                continue;
            }
            for(int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j]){
                    win_nums_counts++;
                    break;
                }
            }
        }
        
        answer[0] = Math.min(7 - win_nums_counts - lottos_zero_counts, 6);
        answer[1] = Math.min(7 - win_nums_counts, 6);
        return answer;
    }
}