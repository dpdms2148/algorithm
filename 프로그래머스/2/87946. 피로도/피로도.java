import java.lang.Math;

class Solution {
    public int answer;
    public boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        exploreDungeon(0, k, dungeons);
        return answer;
    }
    
    public void exploreDungeon(int depth, int k, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                exploreDungeon(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}