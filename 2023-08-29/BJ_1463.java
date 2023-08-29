import java.util.Arrays;
import java.util.Scanner;

public class BJ_1463 {
	static int N, mem[];
	public static void main(String[] args) {
		N = new Scanner(System.in).nextInt();
		mem = new int[N+1];
		Arrays.fill(mem, 1<<30);
		dp(N, 0);
		System.out.println(mem[1]);
	}
	private static void dp(int n, int count) {
		if(n < 1) return;
		if(mem[n] > count) mem[n] = count;
		else return;
		
		if( n % 3 == 0) dp(n/3, count+1);
		if( n % 2 == 0) dp(n/2, count+1);
		if( n > 0) dp(n-1, count+1);
		
	}
}