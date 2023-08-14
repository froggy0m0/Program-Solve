import java.util.Arrays;
import java.util.Scanner;

public class BJ_1920 {
	static int N, M;
	static int[] nArr, mArr;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		nArr = new int[N];
		for (int i = 0; i < N; i++) {
			nArr[i] = sc.nextInt();
		}
		Arrays.sort(nArr);

		M = sc.nextInt();
		mArr = new int[M];
		for (int i = 0; i < M; i++) {
			mArr[i] = sc.nextInt();
		}

		for (int target : mArr) {
			binSearch(0, N - 1, target);
		}
	}

	private static void binSearch(int s, int e, int target) {
		int mid = (s + e)/2;
		if(s>e) {
			System.out.println(0);
			return;
		}
		if(nArr[mid] == target) System.out.println(1);
		if(nArr[mid] > target) binSearch(s, mid-1, target);
		if(nArr[mid] < target) binSearch(mid+1, e, target);
		
	}

	private static void binSearch1(int s, int e, int target) {
		while (s <= e) {
			int mid = (s + e) / 2;
			if (nArr[mid] == target) {
				System.out.println(1);
				return;
			}

			if (nArr[mid] > target) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}

			if (s > e)
				System.out.println(0);

		}
	}
	
}