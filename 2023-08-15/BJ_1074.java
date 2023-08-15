import java.util.Scanner;

public class BJ_1074 {
	static int N, r, c;
	static int sX, sY;
	static int result;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		// 모두 돌리지않고 시작위치찾기 1*1 배열범위 까지 좁히기
		findStartPos(0, 0, (int) Math.pow(2, N));
		System.out.println(result);
	}

	private static void findStartPos(int x, int y, int size) {
		if (size <= 1) return;
		
		int half = size / 2;
		if ((x <= r && r < x + half) && (y <= c && c < y + half)) {// 0위치
			sX = x;
			sY = y;
			result = result + (0 * (half * half));
		} else if ((x <= r && r < x + half) && (y + half <= c && c < y + size)) {// 1위치
			sX = x;
			sY = y + half;
			result = result + (1 * (half * half));
		} else if ((x + half <= r && r < x + size) && (y <= c && c < y + half)) {// 2위치
			sX = x + half;
			sY = y;
			result = result + (2 * (half * half));
		} else if ((x + half <= r && r < x + size) && (y + half <= c && c < y + size)) {// 3위치
			sX = x + half;
			sY = y + half;
			result = result + (3 * (half * half));
		}
		findStartPos(sX, sY, half);
		return;
	}
}
