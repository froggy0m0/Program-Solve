import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17135 {
	static class Pos{
		public int x;
		public int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return (String.valueOf(x) + String.valueOf(y)).hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Pos) {
				Pos other = (Pos)obj;
				return this.x == other.x && this.y == other.y;
			}
			return false;
		}
	}
	
	
	static int N, M, D, totalEnemy;
	static HashSet<Pos> removePos = new HashSet<Pos>();
	static int[] ArcherPos = new int[3];
	static int[][] originalBoard;
	static int[][] copyBoard;
	static boolean[][] isVisited;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		originalBoard = new int[N][M];
		copyBoard = new int[N][M];
		for(int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int y = 0; y < M; y++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					totalEnemy++;
					originalBoard[x][y] = 1;
				}
			}
		}
		isVisited = new boolean[N][M];
		
		combination(0, 0);
		System.out.println(answer);
		
	}
	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			answer = Math.max(answer, attack());
			return;
		}
		
		for(int i = start; i < M; i++) {
			ArcherPos[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	private static int attack() {
		setCopyBoard();
		int killEnemy = 0;
		int missEnemy = 0;
		for(int time = 0; time < N; time++) {
			if(totalEnemy == killEnemy+missEnemy) break;
			//적 공격가능한위치 set에 add
			setRemovePos();
			
			//공격한 적 지우기 
			for(Pos pos : removePos) {
				copyBoard[pos.x][pos.y] = 0;
			}
			
			//처리한적 추가
			killEnemy += removePos.size();
			removePos.clear();
			
			//-> 놓친적 체크하기
			for(int y = 0; y < M; y++) {
				if(copyBoard[N-1][y] == 1) missEnemy++;
			}
			
			//board내리기
			for(int x = N-1; x > time; x--) {
				copyBoard[x] = Arrays.copyOf(copyBoard[x-1], copyBoard[x-1].length);
			}
			Arrays.fill(copyBoard[time], 0);
		}
		
		return killEnemy;
	}
	
	private static void setCopyBoard() {
		for(int x = 0; x < N; x++) {
			copyBoard[x] = Arrays.copyOf(originalBoard[x], originalBoard[x].length);
		}
		
	}
	
	private static void setRemovePos() {
		int[] dx = {0, -1, 0};
		int[] dy = {-1, 0, +1};
		Queue<int[]> queue = new ArrayDeque<>();
		for(int y : ArcherPos) {
			for(int i = 0; i < N; i++) Arrays.fill(isVisited[i], false);
			int x = N-1; // d도 -1
			int dept = 1;
			boolean find = false;
			if(copyBoard[x][y] == 1) {
				removePos.add(new Pos(x, y));
				continue;
			}
			queue.add(new int[] {x, y, dept});
			isVisited[x][y] = true;
			
			while(!queue.isEmpty()) {
				int[] pos = queue.poll();
				x = pos[0];
				y = pos[1];
				dept = pos[2];
				if(dept == D) break;
				for(int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if((-1 < nx && nx < N) && (-1 < ny && ny < M) && (isVisited[nx][ny] == false)) {
						queue.add(new int[] {nx, ny, dept+1});
						isVisited[nx][ny] = true;
						if(copyBoard[nx][ny] == 1) {
							removePos.add(new Pos(nx, ny));
							find = true;
							break;
						}
					}
				}
				if(find==true) break;
			}
			queue.clear();
		}
		
	}

}
