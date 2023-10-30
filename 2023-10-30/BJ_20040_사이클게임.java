import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20040_사이클게임 {
	static int N, M;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N];
		int result = 0;
		
		for(int i = 0; i < N; i++) parents[i] = i;
		
		int count = 0;
		while(M-- > 0) {
			count++;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(union(a, b)) {
				result = count;
				break;
			}
		}
		
		System.out.println(result);
		
	}
	public static boolean union(int a, int b) {
		int aRoot = find(parents[a]);
		int bRoot = find(parents[b]);
		
		if(aRoot == bRoot) return true;
		
		if(aRoot > bRoot) parents[aRoot] = bRoot;
		else parents[bRoot] = aRoot;
		
		return false;
	}
	
	public static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
}