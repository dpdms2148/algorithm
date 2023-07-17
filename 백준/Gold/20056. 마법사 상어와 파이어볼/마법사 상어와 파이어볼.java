import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Fireball {
        int r;
        int c;
        int m;
        int s;
        int d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static ArrayList<Fireball> map[][];
    static ArrayList<Fireball> fireballList = new ArrayList<>();
    static int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new Fireball(r, c, m, s, d));
            fireballList.add(new Fireball(r, c, m, s, d));
        }


        for (int k = 0; k < K; k++) {
            // 1. 파이어볼 이동
            moveFireball();

            // 2. 2개 이상 파이어볼이 있는 칸
            combineFireball();

            // fireballList 업데이트 해주기
            makeFireballList();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (Fireball fireball : map[i][j]) {
                        answer += fireball.m;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void makeFireballList() {
        fireballList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() > 0) {
                    for (Fireball fireball : map[i][j]) {
                        fireballList.add(fireball);
                    }
                }
            }
        }
    }

    private static void combineFireball() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() >= 2) {
                    // 2-1. 파이어볼 하나로 합치기
                    int m = 0;
                    int s = 0;
                    int even = 0;
                    int odd = 0;
                    for (Fireball fireball : map[i][j]) {
                        m += fireball.m;
                        s += fireball.s;
                        if (fireball.d % 2 == 0) even++;
                        else odd++;
                    }

                    m /= 5;
                    s /= map[i][j].size();

                    map[i][j] = new ArrayList<>();
                    if (m == 0) continue;

                    boolean flag = false;
                    if (even == 0 || odd == 0) {
                        flag = true;
                    }

                    // 2-2. 파이어볼 4개로 나누기
                    if (flag) {// 모두 홀수거나 모두 짝수
                        for (int dd = 0; dd < 8; dd += 2) {
                            map[i][j].add(new Fireball(i, j, m, s, dd));
                        }
                    } else {
                        for (int dd = 1; dd < 8; dd += 2) {
                            map[i][j].add(new Fireball(i, j, m, s, dd));
                        }
                    }
                }

            }
        }
    }

    private static void moveFireball() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (Fireball fireball : fireballList) {
            //fireball.r = fireball.r + dx[fireball.d] * (fireball.s % N);
            //fireball.c = fireball.c + dy[fireball.d] * (fireball.s % N);
            fireball.r = (fireball.r + (dx[fireball.d] + N) * fireball.s) % N;
            fireball.c = (fireball.c + (dy[fireball.d] + N) * fireball.s) % N;
            //범위를 벗어나는 경우
//            if (fireball.r >= N) fireball.r %= N;
//            if (fireball.c >= N) fireball.c %= N;
//            if (fireball.r < 0) fireball.r = N + fireball.r;
//            if (fireball.c < 0) fireball.c = N + fireball.c;

            map[fireball.r][fireball.c].add(fireball);
        }
    }
}