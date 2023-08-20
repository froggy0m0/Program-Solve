import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
 * N극 0 S극 1
 * 회전돌고나서 0위치에는 S극이있으면 포인트획득
 * 0 -> 1
 * 1 -> 2
 * 2 -> 4
 * 3 -> 8
 */
public class SW_4013 {
	static int K;
	static ArrayList<Integer>[] magnetList = new ArrayList[4]; 
	static List<int[]> rotateInfoList = new ArrayList<>(); 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 4; i++) magnetList[i] = new ArrayList<>();
				
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			
			//톱니바퀴 초기화
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				while(st.hasMoreElements()) {
					magnetList[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			//회전 정보 초기화
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				rotateInfoList.add(new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())});
			}

			int answer = rotate();
			
			System.out.println("#" + tc + " " + answer);
			rotateInfoList.clear();
			for(int i = 0; i < magnetList.length; i++) magnetList[i].clear();
		}
	}
	private static int rotate() {
		int totalScore = 0;
		
		for(int[] rotateInfo : rotateInfoList) {
			int[] rotateFlags = getRotateFlags(rotateInfo[0], rotateInfo[1]);	//회전해야하는 자석을 체크
			
			for(int idx = 0; idx < rotateFlags.length; idx++) {
				if(rotateFlags[idx] == 0) continue;
				//자석 돌리기
				if(rotateFlags[idx] == 1) {
					magnetList[idx].add(0, magnetList[idx].remove(7));
				}else if(rotateFlags[idx] == -1) {
					magnetList[idx].add(7, magnetList[idx].remove(0));
				}
			}
		}
		//회전다돌렸으니 현재 점수 카운트하기
		for(int idx = 0; idx < magnetList.length; idx++) {
			if(magnetList[idx].get(0) == 1) totalScore += 1 << idx;
		}
		
		return totalScore;
	}
	private static int[] getRotateFlags(int idx, int d) {	//시계방향 1  // 반시계 -1
		int[] Flags = new int[4];
		Flags[idx] = d;
		int leftIdx = idx;
		int rightIdx = idx;
		while(true) {
			if(leftIdx == 0) break;
			
			if(magnetList[leftIdx-1].get(2) != magnetList[leftIdx].get(6)) {
				Flags[leftIdx-1] = Flags[leftIdx] * -1;
				leftIdx--;
			}else {
				break;
			}
		}
		
		while(true) {
			if(rightIdx == 3) break;
			
			if(magnetList[rightIdx].get(2) != magnetList[rightIdx+1].get(6)) {
				Flags[rightIdx+1] = Flags[rightIdx] * -1;
				rightIdx++;
			}else {
				break;
			}
		}
		
		return Flags;
	}
}
