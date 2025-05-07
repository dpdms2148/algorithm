import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[] totalCount;
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
        totalCount = new int[m];
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[j][i] && land[j][i] == 1){//석유가 있음
                    bfs(n, m, j, i, land, visited);//현재 위치에서 석유 탐색
                }
            }
            answer = Arrays.stream(totalCount).max().getAsInt();
        }
        return answer;
    }
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public void bfs(int n, int m, int x, int y, int[][] land, boolean[][] visited){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        q.add(new int[]{x, y});
        visited[x][y] = true;
        count++;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            set.add(cur[1]);
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(!visited[nx][ny] && land[nx][ny] == 1){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        for (int index : set) {
            totalCount[index] += count;
        }
    }
}