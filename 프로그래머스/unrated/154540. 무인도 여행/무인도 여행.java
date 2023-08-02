import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i].charAt(j) == 'X') map[i][j] = 0;
                else map[i][j] = maps[i].charAt(j)-'0';
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) continue;
                if(visited[i][j]) continue;
                
                int sum = 0;
                
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                sum += map[i][j];
                
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    
                    for(int d = 0; d < 4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(map[nx][ny] == 0 || visited[nx][ny]) continue;
                        
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                    }
                }
                
                list.add(sum);
            }
        }
        
        int[] answer = {};
        if(list.size() == 0){
            answer = new int[]{-1};
        }else{
            Collections.sort(list);
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}