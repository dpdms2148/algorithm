import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;
    static ArrayList<Integer> answers = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = 0;
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    n = findComplex(N, i, j);
                    answer++;
                    answers.add(n);
                }
            }
        }

        System.out.println(answer);
        Collections.sort(answers);
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }

    private static int findComplex(int N, int x, int y) {
        int count = 1;
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y));
        while (!queue.isEmpty()) {
            point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new point(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }

}