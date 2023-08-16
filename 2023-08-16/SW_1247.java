import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SW_1247 {
	static int minValue;
	static int N;
	static Pos[] pos; // 0인덱스 회사 - (1,,2,,3,고객위치) N+1 집 
	static boolean[] isVistied;
	static int[] numbers;
	static int count = 0;
	static int[][] disArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			minValue = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			isVistied = new boolean[N + 2];
			numbers = new int[N + 2];
			isVistied[0] = true;
			isVistied[N + 1] = true;
			numbers[0] = 0;
			numbers[N + 1] = N + 1;

			st = new StringTokenizer(br.readLine());
			Pos cPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Pos hPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			pos = new Pos[N + 2];
			pos[0] = cPos;
			for (int i = 1; i <= N; i++) {
				pos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			pos[N + 1] = hPos;
			
			disArr = new int[N+2][N+2];
			for(int i = 0; i < N+2; i++) {
				for(int j = 0; j < N+2; j++) {
					if(i == j) continue;
					disArr[i][j] = Math.abs(pos[i].x - pos[j].x) + Math.abs(pos[i].y - pos[j].y);
				}
			}

			for (int i = 0; i < N; i++) {
				perm(1);
			}

			System.out.println("#" + tc + " " +  minValue);
		}
	}

	private static void perm(int cnt) {
		if (cnt == N + 1) {
			int totalDis = 0;
			for (int i = 0; i < numbers.length-1; i++) {
				totalDis += disArr[numbers[i]][numbers[i+1]];
			}
			
			minValue = Math.min(minValue, totalDis);
			
			return;
		}

		for (int i = 1; i < N + 1; i++) {
			if (isVistied[i]) continue;
			isVistied[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1);
			isVistied[i] = false;
		}

	}
}