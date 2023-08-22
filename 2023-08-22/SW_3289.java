import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_3289 {
	static int N;
	static int[] parents;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1; tc++) {
			int[] tempInp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			N = tempInp[0];
			int M = tempInp[1];
			
			make();
			sb.append("#" + tc + " ");
			for(int i = 0; i < M; i++) {
				tempInp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
				int command = tempInp[0];
				int x = tempInp[1];
				int y = tempInp[2];
				if(command == 1) {
					if(find(x) == find(y)) sb.append("1");
					else sb.append("0");
				}else {
					union(x, y);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void make() {
		parents = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(x == parents[x]) return x;
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