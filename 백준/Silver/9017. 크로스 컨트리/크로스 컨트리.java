import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] team = new int[201];       // 팀 정보를 저장하는 배열(index : 팀 번호, value : 팀원 수)
            int[][] teamRunner = new int[N][2]; // 선수 정보를 저장하는 배열(index : 등수, [0]팀, [1]점수)
            int[] teamScore = new int[201];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int teamNumber = Integer.parseInt(st.nextToken());
                team[teamNumber]++;
                teamRunner[i][0] = teamNumber;
            }

            //등수 별로 점수 계산
            int point = 1;
            for (int i = 0; i < N; i++) {
                if (team[teamRunner[i][0]] < 6) {// 팀의 참가 선수가 6명 보다 작은 경우는 점수 계산에서 제외
                    for (int j = 0; j < N; j++) {
                        if (teamRunner[j][0] == teamRunner[i][0]) teamRunner[j][1] = -1;
                    }
                } else {
                    teamRunner[i][1] = point++;
                }

            }

            /*for (int i = 0; i < N; i++) {
                System.out.print(teamRunner[i][1] + " ");
            }*/
            int winner = 0;
            int winnerScore = Integer.MAX_VALUE;
            int winnerFifthScore = 0;
            for (int i = 1; i < 201; i++) {
                if (team[i] < 6) continue;
                int count = 0;
                int score = 0;
                int fifthScore = 0;
                for (int j = 0; j < N; j++) {
                    if (teamRunner[j][0] != i) continue;
                    if (teamRunner[j][1] == -1) continue;

                    count++;
                    if (count == 5) {//5번째 선수라면 점수만 저장하고 넘어감
                        fifthScore = teamRunner[j][1];
                        break;
                    }
                    score += teamRunner[j][1];
                }

                if (score < winnerScore) { // 점수가 같은 경우
                    winner = i;
                    winnerScore = score;
                    winnerFifthScore = fifthScore;
                } else if (score == winnerScore) { //점수가 같은 경우
                    if (fifthScore < winnerFifthScore) { //5번째 선수 점수를 비교
                        winner = i;
                        winnerScore = score;
                        winnerFifthScore = fifthScore;
                    }
                }
                //System.out.println(winner+" "+winnerScore+" "+winnerFifthScore);
            }
            sb.append(winner).append("\n");
        }
        System.out.print(sb);
    }
}