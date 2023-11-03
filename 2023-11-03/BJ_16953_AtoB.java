import java.util.HashSet;
import java.util.Scanner;

public class BJ_16953_AtoB {
	static HashSet<Long> visited = new HashSet<>();
	static int minCount = Integer.MAX_VALUE;
	static long B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextInt();
		B = sc.nextInt();
		solve(A, 1);
		System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
	}
	private static void solve(long a, int count) {
		if(count >= minCount || a > B) return;
		if(a == B) {
			minCount = Math.min(minCount, count);
		}
		
		long nextVal = a * 2;
		if(nextVal <= B && visited.contains(nextVal) == false) {
			visited.add(nextVal);
			solve(nextVal, count+1);
			visited.remove(nextVal);
		}
		
		nextVal = (a * 10) + 1;
		if(nextVal <= B && visited.contains(nextVal) == false) {
			visited.add(nextVal);
			solve(nextVal, count+1);
			visited.remove(nextVal);
		}
	}
}
