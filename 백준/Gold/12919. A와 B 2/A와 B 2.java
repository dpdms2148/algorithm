import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(makeString(S, T) ? 1 : 0);
    }

    private static boolean makeString(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) return true;
            return false;
        }
        if (t.charAt(0) == 'B') {
            String removeB = t.substring(1);// 맨 첫 글자인 B를 제거
            StringBuilder sb = new StringBuilder(removeB);
            if (makeString(s, sb.reverse().toString())) {
                return true;
            }
        }
        if (t.charAt(t.length() - 1) == 'A') {
            if (makeString(s, t.substring(0, t.length() - 1))) { // 맨 뒷 글자인 A를 제거
                return true;
            }
        }
        return false;
    }
}