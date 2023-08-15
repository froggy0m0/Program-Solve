import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1068 {
	static List<List<Integer>> graphList = new ArrayList<>();
	static List<Integer> startList = new ArrayList<>();
	static int N;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < N; i++) {
			graphList.add(new ArrayList<>());
		}
		
		int[] tempArr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
		int removeIdx = sc.nextInt();
		for(int i = 0; i < N; i++) {		//각 노드의 연결그래프 구현
			if(i == removeIdx) continue;	//삭제할 노드는 짤라버리기
			if(tempArr[i] == -1) {			//-1인 == 루트노드, 즉시작노드
				startList.add(i);			//List로구현한이유 -> 이진트리가 두개이상으로 구현될떄도있지않을까 ?
				continue;
			}
			graphList.get(tempArr[i]).add(i);
		}
		
		
		for (int startV : startList) {		//루트노드를 시작으로 깊이탐색
			bfs(startV);
		}
		System.out.println(answer);
	}

	private static void bfs(int startV) {
		Stack<Integer> stack = new Stack<>();
		stack.add(startV);
		
		while (!stack.isEmpty()) {
			int curV = stack.pop();
			List<Integer> nextVList = graphList.get(curV);
			if (nextVList.size() == 0) {
				answer++;
				continue;
			}
											
			for (int nextV : nextVList) { 	//list for-each??
				stack.add(nextV);			//List nextVList = graphList.get(curV);
			}								//List<Integer> nextVList = graphList.get(curV);
		}
	}
}
