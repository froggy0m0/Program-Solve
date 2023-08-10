import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BJ_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		char[] inpArr;
		String answer;
		int T = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < T; i++) {
			stack.clear();
			answer = "YES";
			inpArr = sc.nextLine().toCharArray();
			for (char c : inpArr) {
				if(c == '(') {
					stack.push(c);
				}else {
					if(!stack.isEmpty() && stack.pop() == '(') continue;
					else answer = "NO"; break;
				}
			}
			if(!stack.isEmpty()) answer = "NO";
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

}
