import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int[] visited;
    static List<List<Integer>> friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friends = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            friends.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            friends.get(A).add(B);
            friends.get(B).add(A);
        }

        answer = 1;
        visited = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == 0) {
                findFriend(i, 1);
            }
        }
        System.out.println(answer);
    }

    private static void findFriend(int index, int value) {
        if (answer == 0) {
            return;
        } else {
            visited[index] = value;
            for (int i : friends.get(index)) {
                if (visited[i] == 0) { //방문안함
                    visited[i] = value * -1; //적표시
                    findFriend(i, value * -1); //다음 친구로 이동
                } else if (visited[i] == value) { //방문함
                    answer = 0; //성립불가능
                    return;
                }
            }
        }
    }
}