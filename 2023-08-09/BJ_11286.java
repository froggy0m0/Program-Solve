import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BJ_11286 {
	static Queue<Integer> queue;
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		queue = new PriorityQueue<>((x,y) -> {
			int absX = Math.abs(x);
			int absY = Math.abs(y);
			if (absX == absY) return x-y;
			return absX-absY;
		});
		
		int N = sc.nextInt();
		int inp;
		for(int i = 0; i < N; i++) {
			inp = sc.nextInt();
			if(inp == 0) {
				if(queue.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(queue.poll());
				}
			}else {
				queue.offer(inp);
			}
		}
		
		
	}

}
