import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main {
    static class Barn{
        int num;
        int cost;

        public Barn (int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Barn>[] map = new ArrayList[N];
        for(int i=0; i<N; i++){
            map[i] = new ArrayList<>();
        }
        int[] cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            map[x].add(new Barn(y, c));
            map[y].add(new Barn(x, c));
        }

        PriorityQueue<Barn> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Barn(0, 0));

        while(!pq.isEmpty()){
            Barn cur = pq.poll();
            int n = cur.num;
            int c = cur.cost;

            if(c>cost[n]) continue;
            for(int i=0; i<map[n].size(); i++){
                int nn = map[n].get(i).num;
                int nc = map[n].get(i).cost+c;
                if(nc<cost[nn]){
                    pq.add(new Barn(nn, nc));
                    cost[nn] = nc;
                }
            }
        }

        System.out.println(cost[N - 1]);
    }
}