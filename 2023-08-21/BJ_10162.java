import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10162 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int[] arr = new int[] {300, 60, 10};
		int[] result = new int[3];
		int T = Integer.parseInt(br.readLine());
		
		while(T != 0) {
			for(int i = 0; i < arr.length; i++) {
				result[i] = T / arr[i];  
				T = T % arr[i];
				
				if(i == arr.length-1 && T != 0) {	
					System.out.println(-1);
					return;
				}
			}
		}
		

		for(int count : result) {
			System.out.print(count + " ");
		}
	}
}
