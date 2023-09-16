import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2933 {
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int x, y;
	static char[][] board;
	static int[] throwArr;
	static boolean[][] isVisited;
	static List<Pos> clusterList = new ArrayList<>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		board = new char[x][y];
		for (int i = 0; i < x; i++) {
			board[i] = br.readLine().toCharArray();
		}

		throwArr = new int[Integer.parseInt(br.readLine())];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < throwArr.length; i++)
			throwArr[i] = Integer.parseInt(st.nextToken()) - 1;

		play();

	}

	// 막대던지기
	private static void play() {
		for (int turn = 0; turn < throwArr.length; turn++) {
			int height = (x - 1) - throwArr[turn];
			if (turn % 2 == 0) { // 왼 -> 오
				for (int i = 0; i < y; i++) {
					if (board[height][i] == 'x') { // 미네랄깨기
						board[height][i] = '.';
						break;
					}
				}

			} else { // 오 -> 왼
				for (int i = y - 1; i > -1; i--) {
					if (board[height][i] == 'x') { // 미네랄깨기
						board[height][i] = '.';
						break;
					}
				}
			}

			findCluster(); // 떠있는 클러스터 찾기
			if (!clusterList.isEmpty())
				dropCluster();

		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	private static void dropCluster() { // 클러스트 떨어트리기
		int level = 2;
		for (Pos pos : clusterList) { // 떠있는 클러스트 비어있는 공간으로 만들기
			board[pos.x][pos.y] = '.';
		}

		while (true) { // 클러스트가 내려갈수있는지 체크
			int count = clusterList.size();
			for (Pos pos : clusterList) {
				int nx = pos.x + level;
				int ny = pos.y;
				if ((-1 < nx && nx < x) && (-1 < ny && ny < y) && board[nx][ny] == '.') {
					count--;
					continue;
				} else { 
					break;
				}
			}

			if (count == 0) level++; //모든 클러스트가 한칸씩내려올수있다면 한칸더내려보기
			else {
				level -= 1;
				break;
			}
		}
		for (Pos pos : clusterList) {
			int nx = pos.x + level;
			int ny = pos.y;
			board[nx][ny] = 'x';
		}

	}

	private static void findCluster() {
		isVisited = new boolean[x][y];
		clusterList.clear();
		for (int i = 0; i < y; i++) {
			if (board[x - 1][i] == 'x' && isVisited[x - 1][i] == false) { // 맨바닥에있는 미네랄들을 시작으로 bfs탐색
				bfs(new Pos(x - 1, i));
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 'x' && isVisited[i][j] == false) { // 떠있는 클러스트정보 리스트에추가
					clusterList.add(new Pos(i, j));
				}
			}
		}
	}

	private static void bfs(Pos curPos) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(curPos);

		while (!queue.isEmpty()) {
			curPos = queue.poll();
			for (int d = 0; d < dx.length; d++) {
				int nx = curPos.x + dx[d];
				int ny = curPos.y + dy[d];

				if ((-1 < nx && nx < x) && (-1 < ny && ny < y)) {
					if (board[nx][ny] == 'x' && isVisited[nx][ny] == false) {
						queue.add(new Pos(nx, ny));
						isVisited[nx][ny] = true;
					}
				}
			}
		}
	}
}
