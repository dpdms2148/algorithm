import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());// 발전소 수
        int W = Integer.parseInt(st.nextToken());// 남아있는 전선의 수
        double M = Double.parseDouble(br.readLine());

        int[][] powerStation = new int[N+1][2];
        for (int i = 1; i < N+1; i++) { // 발전소의 좌표-100,000 ≤ xi,yi  ≤ 100,000
            st = new StringTokenizer(br.readLine());
            powerStation[i][0] = Integer.parseInt(st.nextToken());
            powerStation[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isConnected = new boolean[N+1][N+1];
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isConnected[a][b] = true;
            isConnected[b][a] = true;
        }

        Double[] distance = new Double[N+1];
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[1] = 0.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] < o2[0] ? -1 : 0);
        pq.add(new double[]{0, 1});

        double[] cur;
        double dis;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            if (cur[0] > distance[(int) cur[1]] || (int) cur[1] == N) continue;

            for (int i = 1; i < N+1; i++) {
                if (isConnected[(int) cur[1]][i]) dis = cur[0];
                else dis = cur[0] + Math.sqrt(Math.pow(powerStation[i][0] - powerStation[(int) cur[1]][0], 2)
                        + Math.pow(powerStation[i][1] - powerStation[(int) cur[1]][1], 2));
                if (distance[i] > dis) {
                    distance[i] = dis;
                    pq.add(new double[]{dis, i});
                }
            }
        }

        System.out.println((int) (distance[N] * 1000));
    }
}
