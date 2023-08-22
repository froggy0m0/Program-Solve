import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class SW_7465 {
	static int N;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> hashSet = new HashSet<>();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1; tc++) {
			int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			N = inpTemp[0];
			int M = inpTemp[1];
			make();
			for(int i = 0; i < M; i++) {
				inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int x = inpTemp[0];
				int y = inpTemp[1];
				union(x, y);
			}
			for(int i = 1; i < N+1; i++) {
				find(i);
			}
			for(int i = 1; i < N+1; i++) {
				hashSet.add(parents[i]);
			}
			
			sb.append("#"+tc + " " + hashSet.size() +"\n");
			hashSet.clear();
		}
		System.out.println(sb.toString());
	}
	
	private static void make() {
		parents = new int[N+1];
		
		for(int i = 1; i < N+1; i++) parents[i] = i;
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false;
		
		parents[yRoot] = xRoot;
		return true;
	}
}