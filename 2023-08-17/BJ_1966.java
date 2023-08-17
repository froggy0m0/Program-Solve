import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1966 {
	static class Doc{
		int idx;
		int val;
		
		public Doc(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Doc> queue = new ArrayDeque<>();
		ArrayList<Integer> valList = new ArrayList<>();
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int targetIdx = sc.nextInt();
			for(int i = 0; i < N; i++) {
				int val = sc.nextInt();
				valList.add(val);
				queue.add(new Doc(i, val));
			}
			Collections.sort(valList, Collections.reverseOrder());
			
			while(!queue.isEmpty()) {
				if(queue.peek().val == valList.get(0)) {
					Doc doc = queue.poll();
					valList.remove(0);
					if(doc.idx == targetIdx) {
						System.out.println(N-valList.size());
					}
				}else {
					queue.add(queue.poll());
				}
			}
			queue.clear();
		}
		
	}
}
