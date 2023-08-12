import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2493 {
	public static void main(String[] args) throws IOException {
		Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> { // {idx, height}
			return o1[1] - o2[1];
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr;
		int[] resultArr = new int[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for (int i = N-1; i > -1; i--) {
			while (!queue.isEmpty() && queue.peek()[1] < arr[i]) { 
				int[] infoTop = queue.poll();
				resultArr[infoTop[0]] = i+1;
			}
			queue.offer(new int[] {i, arr[i]});
		}
		
		StringBuilder answer = new StringBuilder();
		for(int v : resultArr) answer.append(v + " ");
		System.out.println(answer.toString());
	}
}