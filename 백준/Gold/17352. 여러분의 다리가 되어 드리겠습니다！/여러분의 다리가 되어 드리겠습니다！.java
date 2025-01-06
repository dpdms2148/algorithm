import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        int island1 = 0, island2 = 0;
        for (int i = 1; i < N + 1; i++) {
            int n = find(i);
            if (island1 == 0) {
                island1 = n;
            } else if (island1 != n && island2 == 0) {
                island2 = n;
                break;
            }
        }

        System.out.print(island1 + " " + island2);
    }

    public static boolean union(int x, int y) {
        x = find(x); //x의 부모노드 찾기
        y = find(y); //y의 부모노드 찾기

        // 이미 같은 그래프에 속해있을 때 false 반환
        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}