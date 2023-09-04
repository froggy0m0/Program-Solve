import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205{
	static Pos home,target;
	static boolean[] isVisited;
	static boolean isHappy;
	static ArrayList<Pos> distance;
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public int getDiff(Pos nextPos) {
			return Math.abs(this.x - nextPos.x) + Math.abs(this.y - nextPos.y);
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			isHappy = false;
			
			int n = Integer.parseInt(br.readLine());
			distance = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			distance.add(home);
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				distance.add(new Pos(u,v));
				
			}
			
			st = new StringTokenizer(br.readLine()); 
			target = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			distance.add(target);
			
			isVisited = new boolean[distance.size()];
			bfs();
			
			result.append(isVisited[distance.size()-1] == true ? "happy\n" : "sad\n");
		}
		System.out.println(result.toString());

	
}

	private static void bfs() {
		Queue<Pos> queue = new ArrayDeque<>();
  		queue.add(home);
		while(!queue.isEmpty()) {
			Pos curPos = queue.poll();
			for(int i = 0; i < distance.size(); i++) {
				if(isVisited[i]) continue;
				Pos nextPos = distance.get(i);
				if(curPos.getDiff(nextPos) <= 1000 ) {
					queue.add(nextPos);
					isVisited[i] = true;
				}
			}
		}
	}
}