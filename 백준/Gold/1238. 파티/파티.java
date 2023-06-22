import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] cost = new ArrayList[N + 1];
        ArrayList<int[]>[] reversCost = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            cost[i] = new ArrayList<>();
            reversCost[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            cost[start].add(new int[]{end, time});
            reversCost[end].add(new int[]{start, time});
        }

        int[] timeSum = dijkstra(X, N, cost);
        int[] reversTimeSum = dijkstra(X, N, reversCost);

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            answer = Math.max(answer, timeSum[i] + reversTimeSum[i]);
        }
        System.out.println(answer);
    }

    private static int[] dijkstra(int x, int n, ArrayList<int[]>[] cost) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 1000000);

        // 최단 시간를 가지는 노드를 앞에 배치
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // 출발 노드를 x로 하고 거리를 0으로 초기화
        pq.add(new int[]{x, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            // 최소값이 업데이트 되는 노드만 탐색
            if (dist[cur[0]] < cur[1]) continue;
            dist[cur[0]] = cur[1];

            // 인접 노드 조사
            for (int[] c : cost[cur[0]]) {
                pq.add(new int[]{c[0], cur[1] + c[1]});
            }
        }

        return dist;
    }
    //참고 : https://girawhale.tistory.com/43
}