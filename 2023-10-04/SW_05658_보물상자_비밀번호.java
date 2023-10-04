import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_05658_보물상자_비밀번호{
	static ArrayList<ArrayDeque<String>> queueList = new ArrayList<>();
	static HashSet<Integer> resultList = new HashSet<>();
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i = 0; i < 4; i++) queueList.add(new ArrayDeque<String>());
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			String[] inp = br.readLine().split("");
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < N/4; j++) {
					queueList.get(i).add(inp[(N/4)*i + j]);
				}
			}
			rotate();
			int result = getResult();
			
			System.out.println("#" + tc + " " + result);
			for(int i = 0; i < 4; i++) queueList.get(i).clear();
			resultList.clear();
		}
	}
	private static void rotate() {
		for(int i = 0; i < N/4; i++) {
			getValues();
			shift();
		}
	}
	
	
	
	private static void getValues() {
		for(int i = 0; i < 4; i++) {
			Queue<String> queue = queueList.get(i);
			StringBuilder sb = new StringBuilder();
			String temp;
			for(int j = 0; j < N/4; j++) {
				temp = queue.poll();
				sb.append(temp);
				queue.offer(temp);
			}
			resultList.add(Integer.parseInt(sb.toString(),16));
		}
	}
	
	private static void shift() {
		for(int i = 0; i < 4; i++) {
			queueList.get((i+1)%4).addFirst(queueList.get(i).pollLast());
		}
	}
	
	private static int getResult() {
		ArrayList<Integer> tempList = new ArrayList<>(resultList);
		Collections.sort(tempList, Collections.reverseOrder());
		return tempList.get(K-1);
	}
}
