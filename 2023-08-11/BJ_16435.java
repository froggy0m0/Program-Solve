import java.util.Arrays;
import java.util.Scanner;

public class BJ_16435 {
	static int snakeLength;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		snakeLength = sc.nextInt(); sc.nextLine();
		arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		find();
		System.out.println(snakeLength);

	}

	private static void find() {
		for(int i = 0; i < arr.length; i++) {
			if(snakeLength < arr[i]) return;
			snakeLength++;
			
		}
	}

}