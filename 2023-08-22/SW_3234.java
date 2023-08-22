import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_3234 {
	static int result;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			func(0, 0, 0, arr, new boolean[N]);
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void func(int cnt, int left, int right, int[] arr, boolean[] isVisited) {
		if (cnt == arr.length) {
			result++;
			return;
		}

		for(int i = 0; i < arr.length; i++) {
			if(isVisited[i]) continue;
			
			isVisited[i] = true;	
			if(left >= right+arr[i]) func(cnt+1, left, right+arr[i], arr, isVisited);
			func(cnt+1, left+arr[i], right, arr, isVisited);
			isVisited[i] = false;
		}
	}
}