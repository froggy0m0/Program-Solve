import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
	static int N;
	static int[][] homeInfo, cost;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		homeInfo = new int[2][3];
		cost = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		homeInfo[1][0] = cost[0][0];
		homeInfo[1][1] = cost[0][1];
		homeInfo[1][2] = cost[0][2];
		
		for(int i = 1; i < N; i++) {
			homeInfo[0] = homeInfo[1].clone();
			
			for(int j = 0; j < 3; j++) {
				homeInfo[1][j] = getMinVal(i, j);
			}
		}
		
		
		int minVal = 1 <<30;
		for(int i = 0; i < 3; i++) {
			minVal = Math.min(minVal, homeInfo[1][i]);
		}
		System.out.println(minVal);
	}
	private static int getMinVal(int hc, int idx) {
		int minVal = 1 << 30;
		for(int i = 0; i < 3; i++) {
			if(i == idx) continue;
			
			if(minVal > homeInfo[0][i]) {
				minVal = homeInfo[0][i];
			}
		}
		return minVal+ cost[hc][idx];
	}
	
}