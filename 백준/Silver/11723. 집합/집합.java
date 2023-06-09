import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int bitmask = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if (operation.equals("add")) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                bitmask |= 1 << x;
            } else if (operation.equals("remove")) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                bitmask &= ~(1 << x);
            } else if (operation.equals("check")) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                sb.append((bitmask & (1 << x)) != 0 ? 1 : 0).append("\n");
                //System.out.println((bitmask & (1 << x)) == 0 ? "0" : "1");
            } else if (operation.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                bitmask ^= (1 << x);
            } else if (operation.equals("all")) {
                bitmask = (1 << 21) - 1;
            } else if (operation.equals("empty")) {
                bitmask = 0;
            }
        }
        System.out.println(sb);
    }
}