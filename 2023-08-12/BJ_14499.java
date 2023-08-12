import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14499 {
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int xPos = Integer.parseInt(st.nextToken());
		int yPos = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int[] comArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] dx = { 9999, 0, 0, -1, +1 };// 9999, 동서북남
		int[] dy = { 9999, +1, -1, 0, 0 };

		int[][] changeDice = { {},
				{0, 4, 2, 1, 6, 5, 3 }, 
				{0, 3, 2, 6, 1, 5, 4 }, 
				{0, 5, 1, 3, 4, 6, 2 }, 
				{0, 2, 6, 3, 4, 1, 5 } 
				};

		// 로직
		int[] dice = new int[7]; // 0안씀
		for (int command : comArr) {
			int nx = xPos + dx[command];
			int ny = yPos + dy[command];
			if ((-1 < nx && nx < N) && (-1 < ny && ny < M)) {
				dice = new int[] {0, 
						dice[changeDice[command][1]], 
						dice[changeDice[command][2]],
						dice[changeDice[command][3]], 
						dice[changeDice[command][4]], 
						dice[changeDice[command][5]],
						dice[changeDice[command][6]] };
				if (map[nx][ny] == 0)
					map[nx][ny] = dice[6];
				else {
					dice[6] = map[nx][ny];
					map[nx][ny] = 0;
				}
				result.append(dice[1] + "\n");
				xPos = nx;
				yPos = ny;
			}

		}
		System.out.println(result.toString());
	}
}
