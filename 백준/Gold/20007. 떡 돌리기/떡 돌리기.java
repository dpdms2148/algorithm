import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
 
    static int N, M, X, Y, INF = Integer.MAX_VALUE;
    static int totalDist[];
    static ArrayList<Edge>[] adj;
    static class Edge implements Comparable<Edge> {
        int to, dist;
        
        public Edge(int to, int dist) {
            super();
            this.to = to;
            this.dist = dist;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 집 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        X = Integer.parseInt(st.nextToken()); // 최대 갈 수 있는 거리
        Y = Integer.parseInt(st.nextToken()); // 성현이 집
        
        totalDist = new int[N];        
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // 도로 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 양방향 도로
            adj[a].add(new Edge(b, w));
            adj[b].add(new Edge(a, w));
        }
        
        System.out.println(process());
    }
 
    private static int process() {
        
        // 성현이 집으로부터 각 집까지의 최단 거리
        dijkstra();
                
        Arrays.sort(totalDist);
        // 최단 거리가 X보다 클 경우(방문할 수 없는 집)
        if(totalDist[N - 1] * 2 > X) return -1;
        
        // 가까운 집부터 방문
        int day = 0, idx = 0, tmp = 0;
        while(idx < N) {
            
            // X 안으로 갈 수 있을 때까지 가보자!
            while(idx < N && tmp + totalDist[idx] * 2 <= X) {
                tmp += totalDist[idx++] * 2;
            }
            
            tmp = 0;
            day++;
        }
                
        return day;
    }
 
    private static void dijkstra() {
        
        Arrays.fill(totalDist, INF);
        
        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 성현이 집에서부터 출발
        totalDist[Y] = 0;
        pq.add(new Edge(Y, 0));
        
        while(!pq.isEmpty()) {
            
            Edge now = pq.poll();
            // 이미 방문한 집이면 pass
            if(visited[now.to]) continue;
        
            for (Edge next : adj[now.to]) {
                // 방문하지 않은 집이고, 더 짧은 길로 갈 수 있다면
                if(!visited[next.to] && totalDist[next.to] > totalDist[now.to] + next.dist) {
                    totalDist[next.to] = totalDist[now.to] + next.dist;
                    pq.add(new Edge(next.to, totalDist[next.to]));
                }
            }
            
            visited[now.to] = true;
        }
        
    }
 
}