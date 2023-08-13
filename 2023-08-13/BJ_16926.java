import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_16926 {
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = inpTemp[0], M = inpTemp[1], rCount = inpTemp[2];

		arr = new int[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int rR = Math.min(N, M) / 2;
		// 아래 오른쪽 위 왼쪽
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int tempCount = 0;
		while (tempCount < rCount) {
			for (int i = 0; i < rR; i++) {
				int curX = i, curY = i;
				int way = 0;
				int temp = arr[curX][curY];

				while (true) {
					int nx = curX + dx[way % 4];
					int ny = curY + dy[way % 4];
					if (((-1 + i < nx) && (nx < N - i)) && (-1 + i < ny) && (ny < M - i)) {
						int temp2 = arr[nx][ny];
						arr[nx][ny] = temp;
						temp = temp2;
						curX = nx;
						curY = ny;
					} else {
						way++;
						continue;
					}
					if (nx == i && ny == i) {
						break;
					}
				}
			}
			tempCount++;
		}
		printMap();
		br.close();
	}

	private static void printMap() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}
