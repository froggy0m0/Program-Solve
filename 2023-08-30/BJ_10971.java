import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971 {
	static int N, answer;
	static int[][] W; 
	static int[] selected;
	static boolean[] isVistied;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		W = new int[N][N];
		for(int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0; y < N; y++) {
				W[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		selected = new int[N+1];
		isVistied = new boolean[N];
		for(int i = 0; i < N; i++) {
			isVistied[i] = true;
			selected[0] = i;
			selected[N] = i; 
			perm(1);
		}
		System.out.println(answer);
		
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			if(W[selected[N-1]][selected[N]] == 0) return;
			answer = Math.min(answer, getDis());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isVistied[i] || W[selected[cnt-1]][i] == 0) continue;
			isVistied[i] = true;
			selected[cnt] = i;
			perm(cnt+1);
			isVistied[i] = false;
			
		}
		
	}
	private static int getDis() {
		int distance = 0;
		for(int i = 0; i < N; i++) {
			int u = selected[i];
			int v = selected[i+1];
			distance += W[u][v];
		}
		return distance;
	}
}