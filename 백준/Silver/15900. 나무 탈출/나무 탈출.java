import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, answer;
    static ArrayList<Integer>[] board;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            board[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a].add(b);
            board[b].add(a);
        }
        startGame(1, -1, 0);
        //총 이동 거리가 홀수 -> 성원이가 승리
        System.out.print(answer % 2 == 0 ? "No" : "Yes");
    }

    private static void startGame(int cur, int parent, int sum) {
        if (board[cur].size() == 1 && board[cur].get(0) == parent) {
            // 연결된 간선이 하나고, 그게 부모일 경우 -> 리프 노드
            // 총 이동 거리 업데이트
            answer += sum;
            return;
        }
        for (int next : board[cur]) {
            if (next == parent) continue;
            startGame(next, cur, sum + 1);
        }
    }

}