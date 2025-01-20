import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int N, M, answer;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 9) {//에어컨 위치
                    //answer = 1;
                    visited[i][j] = true;
                    q.add(new Point(i+dx[0], j+dy[0], 0));
                    q.add(new Point(i+dx[1], j+dy[1], 1));
                    q.add(new Point(i+dx[2], j+dy[2], 2));
                    q.add(new Point(i+dx[3], j+dy[3], 3));
                }
                map[i][j] = n;
            }
        }
        findSpace();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]){
                    //System.out.print("■");
                    answer++;
                }
                //else System.out.print("□");
            }
            //System.out.println();
        }
        System.out.println(answer);
    }

    private static void findSpace() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.d;

            if (x < 0 || x >= N || y < 0 || y >= M) continue;

            //if (!visited[x][y]) answer++;
            visited[x][y] = true;

            if (map[x][y] == 0) {
                q.add(new Point(x + dx[d], y + dy[d], d));
            } else if (map[x][y] == 1) {
                if (d == 0 || d == 2) q.add(new Point(x + dx[d], y + dy[d], d));
                if (d == 1) q.add(new Point(x + dx[3], y + dy[3], 3));
                if (d == 3) q.add(new Point(x + dx[1], y + dy[1], 1));
            } else if (map[x][y] == 2) {
                if (d == 1 || d == 3) q.add(new Point(x + dx[d], y + dy[d], d));
                if (d == 0) q.add(new Point(x + dx[2], y + dy[2], 2));
                if (d == 2) q.add(new Point(x + dx[0], y + dy[0], 0));
            } else if (map[x][y] == 3) {
                if (d == 0) q.add(new Point(x + dx[1], y + dy[1], 1));
                if (d == 1) q.add(new Point(x + dx[0], y + dy[0], 0));
                if (d == 2) q.add(new Point(x + dx[3], y + dy[3], 3));
                if (d == 3) q.add(new Point(x + dx[2], y + dy[2], 2));
            } else if (map[x][y] == 4) {
                if (d == 0) q.add(new Point(x + dx[3], y + dy[3], 3));
                if (d == 1) q.add(new Point(x + dx[2], y + dy[2], 2));
                if (d == 2) q.add(new Point(x + dx[1], y + dy[1], 1));
                if (d == 3) q.add(new Point(x + dx[0], y + dy[0], 0));
            }
        }
    }
}