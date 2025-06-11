import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int sheep, wolf;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        sheep = wolf = 0;

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] == 'v') {
                    SheepVsWolf(i, j);
                }
                if (!visited[i][j] && map[i][j] == 'o') {
                    SheepVsWolf(i, j);
                }
            }
        }
        System.out.print(sheep + " " + wolf);
    }

    private static void SheepVsWolf(int x, int y) {
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, -1, 0, 1};
        int s = 0;
        int w = 0;

        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        if (map[x][y] == 'v') w++;
        if (map[x][y] == 'o') s++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    if (map[nx][ny] == 'v') w++;
                    if (map[nx][ny] == 'o') s++;
                }

            }
        }

        if (s > w) sheep += s;
        else wolf += w;
    }
}
