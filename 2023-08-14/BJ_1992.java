import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1992 {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("BJ_1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		compress(0, 0, N);
		System.out.println(sb.toString());
		br.close();
	}

	private static void compress(int sX, int sY, int size) {
		int sum = 0;
		for (int i = sX; i < sX + size; i++) {
			for (int j = sY; j < sY + size; j++) {
				sum += arr[i][j];
			}
		}

		if (sum == 0) {
			sb.append("0");
			return;
		}
			
		else if (sum == size * size) {
			sb.append("1");
			return;
		}
			 
		else {
			sb.append("(");
			int half = size / 2;
			compress(sX, sY, half);
			compress(sX, sY + half, half);
			compress(sX + half, sY, half);
			compress(sX + half, sY + half, half);
			sb.append(")");
			return;
		}
	}
}