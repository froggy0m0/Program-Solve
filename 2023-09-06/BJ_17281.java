import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17281 {
	static int N;
	static int maxValue = 0;
	static boolean[] isSelected;
	static int[] runnerOrder;
	static ArrayList[] infoList;
	static boolean[] runnerStatus;
	static int idx;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		infoList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> tempList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				tempList.add(Integer.parseInt(st.nextToken()));
			}
			infoList[i] = tempList;
		}

		isSelected = new boolean[9];
		runnerOrder = new int[9];
		perm(0);
		System.out.println(maxValue);
	}

	private static void perm(int cnt) {

		if (cnt == 9) {
			if (runnerOrder[3] == 0)
				maxValue = Math.max(maxValue, go());
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;

			isSelected[i] = true;
			runnerOrder[cnt] = i;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static int go() {
		runnerStatus = new boolean[3];
		idx = 0;
		int score = 0;
		
		for (int i = 0; i < N; i++) { // 1~9이닝
			Arrays.fill(runnerStatus, false);
			int outCount = 0;
			
			while (outCount < 3) {
				int num = (int) infoList[i].get(runnerOrder[idx%9]); //num은 1루타, 2루타, 3루타, 홈런, 아웃 정보
				
				if (num == 4) { // 홈런 
					for(int j = 0 ; j < 3; j++) if (runnerStatus[j] == true) score++;
					score++;
					Arrays.fill(runnerStatus, false);
				} 
				else if (num == 0) outCount++; //아웃
				else score += getScore(num); //1,2,3루타
				
				idx++;
			}
		}
		return score;
	}

	private static int getScore(int num) {
		int score = 0;
		for(int j = 0 ; j < num; j++) if (runnerStatus[j] == true) score++; //진루
		for(int k = 0; k < 3-num; k++) runnerStatus[k] = runnerStatus[k + num]; //진루후 주자상황설정
		runnerStatus[3-num] = true;
		
		if(num == 2) {
			runnerStatus[2] = false;
		}else if (num == 3) {
			runnerStatus[1] = false;
			runnerStatus[2] = false;
		}
		return score;
	}
}