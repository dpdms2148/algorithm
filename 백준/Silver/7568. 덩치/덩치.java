import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());//몸무게
			data[i][1] = Integer.parseInt(st.nextToken());//키
		}
		
		for(int i=0; i<N; i++) {
			int rank=1;
			for(int j=0; j<N; j++) {
				if(i!=j) {//자기 자신과 비교할필요 없음
					if(data[i][0]<data[j][0]&&data[i][1]<data[j][1]) {
						rank++;
					}
				}
			}
			System.out.print(rank+" ");
		}
	}
}