import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Flow implements Comparable<Flow> {
        int start;
        int end;
        int cost;

        public Flow(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Flow flow) {
            return this.cost - flow.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long answer = 0;
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        List<Flow> planet = new ArrayList<>();

        for(int i = 0; i<N; i++){
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n != 0) {
                    planet.add(new Flow(i, j, n));
                }
            }
        }
        Collections.sort(planet);

        for (int i = 0; i < planet.size(); i++) {
            Flow flow = planet.get(i);
            if (find(flow.start) != find(flow.end)) {
                answer += flow.cost;
                union(flow.start, flow.end);
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}