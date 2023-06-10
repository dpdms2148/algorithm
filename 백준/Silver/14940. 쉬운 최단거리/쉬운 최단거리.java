import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    x = i;
                    y = j;
                }
                map[i][j] = value;
            }
        }

        int[][] cost = bfs(map, x, y);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] bfs(int[][] map, int x, int y) {
        int n = map.length;
        int m = map[0].length;

        int[][] cost = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                cost[nx][ny] = cost[cx][cy] + map[nx][ny];
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) cost[i][j] = -1;
            }
        }

        return cost;
    }
}