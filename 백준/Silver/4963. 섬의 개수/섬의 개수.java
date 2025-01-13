import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static int map[][];
    static boolean isvisited[][];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[w][h];
            isvisited = new boolean[w][h];
            answer = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1 && !isvisited[i][j]) {
                        checkIsland(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    private static void checkIsland(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        isvisited[x][y] = true;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 8; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx < w && nx >= 0 && ny < h && ny >= 0 && !isvisited[nx][ny] && map[nx][ny] == 1) {
                    isvisited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}