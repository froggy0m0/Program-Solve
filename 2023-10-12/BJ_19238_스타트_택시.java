import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19238_스타트_택시 {
	static class Pos implements Comparable<Pos> {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pos other) {
			if(this.x == other.x) return this.y - other.y; 
			return this.x - other.x;
		}
		
	}
	
	static int[][] board;
	static int N, M, curFuel;
	static ArrayList<Pos> customerList = new ArrayList<>();
	static ArrayList<Pos> targetList = new ArrayList<>();
	static Pos startPos;
	static int SALT = 1000;
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		curFuel = Integer.parseInt(st.nextToken());
		
		board = new int [N][N];
		for(int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y = 0; y < N; y++) {
				board[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		startPos = new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			customerList.add(new Pos(x, y));
			board[x][y] = m + SALT;
			
			targetList.add(new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
		}
		
		System.out.println(go());
	}
	private static int go() {
		for(int m = 0; m < M; m++) {
			if(findCustomer() == false) return -1;
			if(goDestination() == false) return -1;
		}
		
		return curFuel;
	}
	private static boolean findCustomer() {
		if(board[startPos.x][startPos.y] > 10) { // 들어오자마자 바로  손님찾은경우 // 이동거리 0;
			return true;
		}
		boolean[][] visited = new boolean[N][N];
		Queue<Pos> queue = new ArrayDeque<>();
		ArrayList<Pos> findList = new ArrayList<>();
		
		queue.add(startPos);
		visited[startPos.x][startPos.y] = true;
		int depth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			if(depth > curFuel) return false;
			for(int i = 0; i < size; i++) {
				Pos curPos = queue.poll();
				
				for(int d = 0; d < delta.length; d++) {
					int nx = curPos.x + delta[d][0];
					int ny = curPos.y + delta[d][1];
					
					if((-1 < nx && nx < N) && (-1 < ny && ny < N) && (visited[nx][ny] == false) && board[nx][ny] != 1) {
						queue.add(new Pos(nx, ny));
						visited[nx][ny] = true;
						
						if(board[nx][ny] > 10) {
							findList.add(new Pos(nx, ny));
						}
					}
				}
				
			}
			if(!findList.isEmpty()) { 
				Collections.sort(findList); // 같은 이동거리만큼의 손님들의 정보들
				Pos customer = findList.get(0);
				startPos = customer; // 시작점을 우선순위가 높은 손님으로 정함
				curFuel -= depth;
				return true;
			}
		}
		return false;
	}
	private static boolean goDestination() {
		Pos targetPos = targetList.get((board[startPos.x][startPos.y]-SALT));
		
		if(startPos.x == targetPos.x && startPos.y == targetPos.y) {
			return true;
		}
		board[startPos.x][startPos.y] = 0;
		
		Queue<Pos> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		queue.add(startPos);
		visited[startPos.x][startPos.y] = true;
		
		int depth = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			if(depth > curFuel) return false;
			for(int i = 0; i < size; i++) {
				Pos curPos = queue.poll();
				
				for(int d = 0; d < delta.length; d++) {
					int nx = curPos.x + delta[d][0];
					int ny = curPos.y + delta[d][1];
					
					if((-1 < nx && nx < N) && (-1 < ny && ny < N) && visited[nx][ny] == false && board[nx][ny] != 1) {
						queue.add(new Pos(nx, ny));
						visited[nx][ny] = true;
						
						if(nx == targetPos.x && ny == targetPos.y) {
							startPos = new Pos(nx, ny);
							curFuel += depth;
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}
