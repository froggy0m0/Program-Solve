import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ_17143_낚시왕 {
	static class Pos implements Comparable<Pos> {
		static int[][] delta = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int x, y, s, d, z;

		public Pos(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Pos other) {
			return Integer.compare(this.z, other.z) * -1;
		}

		void move() {
			int moveCount = s;
			if (!(-1 < this.x && this.x < X) && (-1 < this.y && this.y < Y)) {
				if (this.d == 1)
					this.d = 2;
				else if (this.d == 2)
					this.d = 1;
				else if (this.d == 3)
					this.d = 4;
				else if (this.d == 4)
					this.d = 3;
			}
			while (moveCount > 0) {

				this.x += delta[this.d][0] * moveCount;
				this.y += delta[this.d][1] * moveCount;
				if((-1 < this.x && this.x < X) && (-1 < this.y && this.y < Y)) {
					break;
				}
				
				if (this.x < 0) {
					moveCount = Math.abs(this.x);
					this.x = 0;
					this.d = 2;
				} else if (this.y < 0) {
					moveCount = Math.abs(this.y);
					this.y = 0;
					this.d = 3;
				} else if (this.x >= X) {
					moveCount = (this.x - (X - 1));
					this.x = X-1;
					this.d = 1;
				} else if (this.y >= Y) {
					moveCount = (this.y - (Y - 1));
					this.y = Y-1;
					this.d = 4;
				}
				
			}
		}
	}
	static int X, Y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		X = inpTemp[0];
		Y = inpTemp[1];
		int M = inpTemp[2];

		ArrayList<Pos> posList = new ArrayList<>();
		for (int m = 0; m < M; m++) {
			inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			posList.add(new Pos(inpTemp[0] - 1, inpTemp[1] - 1, inpTemp[2], inpTemp[3], inpTemp[4]));
		}

		System.out.println(go(posList));
	}

	private static int go(ArrayList<Pos> posList) {
		int result = 0;
		Pos[][] board = new Pos[X][Y];
		for (int peoplePos = 0; peoplePos < Y; peoplePos++) {
			
			// 배열에 상어 위치시키기
			Collections.sort(posList);
			int size = posList.size();
			int count = 0;
			for (int i = 0; i < size; i++) {
				Pos pos = posList.get(i - count);
				if (board[pos.x][pos.y] == null) {
					board[pos.x][pos.y] = pos;
				} else {
					posList.remove(pos);
					count++;
				}
			}
			
			// 상어 낚기
			for (int x = 0; x < X; x++) {
				if (board[x][peoplePos] == null)
					continue;

				Pos pos = board[x][peoplePos];
				result += pos.z;
				posList.remove(pos);
				break;
			}

			//상어 이동하기
			if (peoplePos == Y - 1)
				return result;
			for (Pos pos : posList) {
				pos.move();
			}
			for (int x = 0; x < X; x++)
				Arrays.fill(board[x], null);
		}
		return result;
	}
}
