import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, ans;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];

		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println(ans - 1);

	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		visited[N] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();
			//System.out.println("x : "+x+"\ttime : "+visited[x]);

			if (x == K) {
				ans = Math.min(ans, visited[x]);
				break;
			}

			if (x * 2 < 100001 && visited[x * 2] == 0) {
				visited[x * 2] = visited[x];
				q.offer(x * 2);
			}
			if (x - 1 >= 0 && visited[x - 1] == 0) {
				visited[x - 1] = visited[x] + 1;
				q.offer(x - 1);
			}
			if (x + 1 < 100001 && visited[x + 1] == 0) {
				visited[x + 1] = visited[x] + 1;
				q.offer(x + 1);
			}
		}

	}
}