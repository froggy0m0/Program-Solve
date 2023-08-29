import java.util.Scanner;

public class BJ_11726 {

	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int[] mem = new int[N+1];
		mem[1] = 1;
		mem[2] = 2;
		for(int i = 3; i < N+1; i++) {
			mem[i] = (mem[i-1]+mem[i-2]) % 10007;
		}
		System.out.println(mem[N]);
	}

}