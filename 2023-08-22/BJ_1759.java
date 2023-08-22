import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1759 {
	static int L;
	static int C;
	static char[] charArr;
	static boolean[] isVowel;
	static char[] selected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		L = inpTemp[0];
		C = inpTemp[1];
		
		String inpStr[] = br.readLine().split(" ");
		charArr = new char[C]; 
		for(int i = 0; i < C; i++) {
			charArr[i] = inpStr[i].charAt(0);
		}
		Arrays.sort(charArr);
		isVowel = new boolean[C];
		selected = new char[L];
		for(int i = 0; i < charArr.length; i++) {
			if(charArr[i] == 'a' || charArr[i] == 'e' || charArr[i] == 'i'  || charArr[i] == 'o'  || charArr[i] == 'u' ) {
				isVowel[i] = true;
			}
		}
		
		func(0, 0, 1, 2);
		System.out.println(sb.toString());
	}
	private static void func(int cnt, int start, int v, int c) {
		if(cnt == L) {
			if(v > 0 || c > 0) return;
			for(char ch : selected) sb.append(ch);
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < C; i++) {
			selected[cnt] = charArr[i];
			if(isVowel[i]) func(cnt+1, i+1, v-1, c);
			else func(cnt+1, i+1, v, c-1);
		}
	}

}