import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    public int bfs(int[][]maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0]=true;
        queue.add(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int len = cur[2];
            
            if(x == n - 1 && y == m - 1){
                answer = len;
                break;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;            
                if(maps[nx][ny] == 0) continue;
                
                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx, ny, len+1});
                }
            }
        }
        return answer;
    }
    
}