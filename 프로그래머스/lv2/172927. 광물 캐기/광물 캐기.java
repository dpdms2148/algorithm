class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int[][] cost = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int n = 0;
        for(int i = 0; i < 3; i++){
            n += picks[i];
        }
        digging(new int[n], 0, picks, minerals, cost);
        return answer;
    }
    
    private void digging(int[] arr, int depth, int[] picks, String[] minerals, int[][] cost){
        if(depth == arr.length){
            int tired = 0;
            int index = 0;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < 5; j++){
                    if(index == minerals.length) break;
                    
                    int k = 0;
                    if(minerals[index].equals("diamond")) k = 0;
                    if(minerals[index].equals("iron")) k = 1;
                    if(minerals[index].equals("stone")) k = 2;
                    index++;
                    tired += cost[arr[i]][k];
                }
            }
            
            answer = Math.min(answer, tired);
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(picks[i] > 0){
                picks[i]--;
                arr[depth] = i;
                digging(arr, depth + 1, picks, minerals, cost);
                picks[i]++;
            }
        }
    }
}
