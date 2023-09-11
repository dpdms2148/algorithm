import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Shortcut {
        int start;
        int end;
        int distance;

        public Shortcut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길의 갯수
        int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        int[] minDistance = new int[D + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        ArrayList<Shortcut> shortcut = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            //도착 위치가 고속도로의 길이보다 크거나, 지름길의 길이가 도로의 길이보다 긴 경우
            if (end > D || end - start <= distance) continue;

            // 시작 위치, 도착 위치, 지름길의 길이
            shortcut.add(new Shortcut(start, end, distance));
        }
        Collections.sort(shortcut, (o1, o2) -> {
            if (o1.start == o2.start) {//시작 지점이 같으면 종료 지점을 기준으로 정렬
                return Integer.compare(o1.end, o2.end);
            }
            return Integer.compare(o1.start, o2.start);
        });

        int position = 0;
        int index = 0;
        minDistance[0] = 0;
        while (position < D) {
            if (index < shortcut.size()) { // 지름길이 있는 경우
                Shortcut s = shortcut.get(index);
                if (position == s.start) { // 현재 위치에서 갈 수 있는 지름길이 있는 경우
                    minDistance[s.end] = Math.min(minDistance[position] + s.distance, minDistance[s.end]);
                    index++;
                } else {
                    minDistance[position + 1] = Math.min(minDistance[position + 1], minDistance[position] + 1);
                    position++;
                }
            } else { // 지름길이 없는 경우
                minDistance[position + 1] = Math.min(minDistance[position + 1], minDistance[position] + 1);
                position++;
            }
        }

        System.out.println(minDistance[D]);
    }
}