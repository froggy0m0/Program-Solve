import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_5644 {
	
	/*
	 * 1. A, B사용자가 움직이는 로직 move()
	 * 2. isAvailable()함수 1로직 실행후 충전가능한지 여부체크
	 * 		-> 가능하다면 AList, BList따로 생성해서 가능한 AP의 정보를 적음
	 * 		-> getMaxChgarge()AList, BList를 사용하여 최대값 찾기
	 * 		-> 찾은최대값은 static int answer변수에 더해준다
	 * 
	 * ※각 answer, AList BList는 배터리정보리스트는 테케마다 clear()해주기※
	 */
	
	static int[][] board = new int[10][10];
	static ArrayList<Integer>usAbleA = new ArrayList<>();
	static ArrayList<Integer>usAbleB = new ArrayList<>();
	static ArrayList<int[]> APList = new ArrayList<>();
	static int[] moveAInfo;
	static int[] moveBInfo;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int M = inpTemp[0];
			int A = inpTemp[1];
			
			moveAInfo = new int[M+1];
			moveAInfo[0] = 0;
			moveBInfo = new int[M+1];
			moveBInfo[0] = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i < M+1; i++) moveAInfo[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i < M+1; i++) moveBInfo[i] = Integer.parseInt(st.nextToken());
	
			for(int i = 0; i < A; i++) {
				inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				APList.add(new int[] {inpTemp[1], inpTemp[0], inpTemp[2], inpTemp[3]});
			}
			
			int answer = move();
			
			System.out.println("#" + tc + " " + answer);
			usAbleA.clear();
			usAbleB.clear();
			APList.clear();
		}
	}
	private static int move() {
		int result = 0;
		int[] dx = {0, -1, 0, 1, 0};
		int[] dy = {0, 0, 1, 0, -1};
		
		int ax = 1, ay = 1;
		int bx = 10, by = 10;

		
		for(int i = 0; i < moveAInfo.length; i++) {
			ax = ax + dx[moveAInfo[i]];
			ay = ay + dy[moveAInfo[i]];
			
			bx = bx + dx[moveBInfo[i]];
			by = by + dy[moveBInfo[i]];
			
			isAvailable(ax,ay, bx,by);
			if(usAbleA.size()!= 0 || usAbleB.size()!=0) result += getMaxCharge();
		}
		return result;
	}
	private static int getMaxCharge() {
		int maxValue = Integer.MIN_VALUE;
		if(usAbleA.size() >= 1 && usAbleB.size() == 0) {
			for(int i = 0; i < usAbleA.size(); i++) {
				maxValue = Math.max(maxValue, APList.get(usAbleA.get(i))[3]);
			}
		}else if(usAbleB.size() >= 1 && usAbleA.size() == 0) {
			for(int i = 0; i < usAbleB.size(); i++) {
				maxValue = Math.max(maxValue, APList.get(usAbleB.get(i))[3]);
			}
		}else {
			for (int aAPIdx : usAbleA) {
				for (int bApIdx : usAbleB) {
					if(aAPIdx == bApIdx) {
						maxValue = Math.max(maxValue, APList.get(aAPIdx)[3]);
					}else {
						maxValue = Math.max(maxValue, APList.get(aAPIdx)[3] + APList.get(bApIdx)[3]);
					}
				}
			}
		}
		return maxValue;
	}
	private static void isAvailable(int ax, int ay, int bx, int by) {
		usAbleA.clear();
		usAbleB.clear();

		for(int i = 0; i < APList.size(); i++) {
			int[] APInfo = APList.get(i);
			
			if((Math.abs(ax - APInfo[0]) + Math.abs(ay - APInfo[1])) <= APInfo[2]) {
				usAbleA.add(i);
			}
			
			if((Math.abs(bx - APInfo[0]) + Math.abs(by - APInfo[1])) <= APInfo[2]) {
				usAbleB.add(i);
			}
		}
		
	}
}
