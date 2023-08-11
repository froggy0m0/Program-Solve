import java.util.Scanner;

public class BJ_5585 {
	public static void main(String[] args) {
		int[] info = new int[] {0, 0}; //잔돈갯수, 남은돈
		info[1] = 1000 - new Scanner(System.in).nextInt();
		int[] arr = new int[] {1, 5, 10, 50, 100, 500};
		int idx = arr.length-1;
		while(true) {
			if (idx < 0) break;
			if(info[1] == 0) break;
			info[0] += info[1] / arr[idx];
			info[1] = info[1] % arr[idx];
			idx--;
		}
		System.out.println(info[0]);
	}
}