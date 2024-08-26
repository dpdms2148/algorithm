import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> largerThanZeroArr = new ArrayList<>();
        ArrayList<Integer> smallerThanZeroArr = new ArrayList<>();
        int zeroCnt = 0;

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0) {
                largerThanZeroArr.add(tmp);
            } else if (tmp < 0) {
                smallerThanZeroArr.add(tmp);
            } else {
                zeroCnt++;
            }
        }
        Collections.sort(largerThanZeroArr);
        Collections.sort(smallerThanZeroArr);

        int answer = 0;
        for (int i = largerThanZeroArr.size() - 1; i >= 0; i--) {
            if (i - 1 == -1) {
                answer += largerThanZeroArr.get(i);
            } else {
                if (largerThanZeroArr.get(i) == 1 || largerThanZeroArr.get(i - 1) == 1) {
                    answer += largerThanZeroArr.get(i);
                } else {
                    answer += largerThanZeroArr.get(i) * largerThanZeroArr.get(i - 1);
                    i--;
                }
            }
        }

        for (int i = 0; i < smallerThanZeroArr.size(); i++) {
            if (i + 1 == smallerThanZeroArr.size()) {
                if (zeroCnt == 0) answer += smallerThanZeroArr.get(i);
            } else {
                answer += smallerThanZeroArr.get(i) * smallerThanZeroArr.get(i + 1);
                i++;
            }
        }

        System.out.println(answer);
    }
}