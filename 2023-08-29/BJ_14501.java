import java.util.Scanner;

public class BJ_14501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] mem = new int[N+1];
		int[] T = new int[N];
		int[] P = new int[N];
		for(int i = 0; i < N; i ++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i = N-1; i > -1; i--) {
			if(i + T[i] <= N) mem[i] = Math.max(mem[i+1], mem[i+T[i]] + P[i]);
			else mem[i] = mem[i+1];
		}
		
		System.out.println(mem[0]);
	}

}