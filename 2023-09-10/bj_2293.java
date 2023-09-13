import java.util.Scanner;
public class bj_2293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coinArr = new int[N];
		for(int i = 0; i < N; i++) coinArr[i] = sc.nextInt();
		
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		for(int coin : coinArr) {
			for(int i = coin; i <= K; i++) {
				dp[i] = dp[i] + dp[i-coin];
			}
		}
		System.out.println(dp[K]);
	}
}
