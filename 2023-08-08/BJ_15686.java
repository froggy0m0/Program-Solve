import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_15686 {
	static int N;
	static int M;
	static int[][] boardArr;
	static ArrayList<int[]> chickenStorePos = new ArrayList<>();
	static ArrayList<int[]> homePos = new ArrayList<>();
	static int[] selectIdx;
	static int answer;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		boardArr = new int[N][N];

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				boardArr[x][y] = sc.nextInt();
				if (boardArr[x][y] == 2)
					chickenStorePos.add(new int[] { x, y });
				if (boardArr[x][y] == 1)
					homePos.add(new int[] { x, y });
			}
		}
		selectIdx = new int[M];
		combination(0, 0);
		System.out.println(answer);
	}

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			calDistance();
			return;
		}
		for (int i = start; i < chickenStorePos.size(); i++) {
			selectIdx[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	private static void calDistance() {
		int tempSum = 0;
		int tempDis = 0;
		int temp = 0;
		for (int i = 0; i < homePos.size(); i++) {
			int homeX = homePos.get(i)[0];
			int homeY = homePos.get(i)[1];
			tempDis = 0;

			for (int idx : selectIdx) {
				int chickenX = chickenStorePos.get(idx)[0];
				int chickenY = chickenStorePos.get(idx)[1];
				temp = Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY);
				if (tempDis == 0)
					tempDis = temp;
				else
					tempDis = Math.min(tempDis, temp);
			}
			tempSum += tempDis;
		}

		if (answer == 0)
			answer = tempSum;
		else
			answer = Math.min(answer, tempSum);
	}
}
