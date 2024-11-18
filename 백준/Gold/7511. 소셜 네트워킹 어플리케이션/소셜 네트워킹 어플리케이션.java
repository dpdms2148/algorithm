import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            bw.append("Scenario " + (t + 1) + ":");
            bw.newLine();

            int n = Integer.parseInt(br.readLine());//유저의 수
            int k = Integer.parseInt(br.readLine());//친구 관계의 수
            friends = new int[n];
            for (int i = 0; i < n; i++) {
                friends[i] = i;
            }

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                makeFriend(a, b);
            }
            int m = Integer.parseInt(br.readLine());//미리 구할 쌍의 수
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (findFriend(a) == findFriend(b)) {
                    bw.append("1");
                    bw.newLine();
                } else {
                    bw.append("0");
                    bw.newLine();
                }
            }
            bw.newLine();
        }
        bw.flush();
    }

    private static int findFriend(int a) {
        if (a == friends[a]) return a;
        else return friends[a] = findFriend(friends[a]);
    }

    private static void makeFriend(int a, int b) {
        int aParent = findFriend(a);
        int bParent = findFriend(b);
        if (aParent < bParent) {
            friends[bParent] = aParent;
        } else if (bParent < aParent) {
            friends[aParent] = bParent;
        }
    }
}