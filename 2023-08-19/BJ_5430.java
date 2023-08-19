import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// 65241017 end-- start++
public class BJ_5430 {
	static boolean isReversed;
	static Deque<Integer> deque = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		Pattern pattern = Pattern.compile("\\d+"); //정규표현식 -> 숫자만
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			char[] funcArr = br.readLine().toCharArray();
			
			int N = Integer.parseInt(br.readLine());
			Matcher matcher = pattern.matcher(br.readLine());
			while (matcher.find()) {
				deque.add(Integer.parseInt(matcher.group()));
			}
			
			isReversed = false;
			boolean Error = false;
			for(char func : funcArr) {
				if(func == 'R') {
					isReversed = !isReversed; //※
					continue;
				}else {
					if(deque.isEmpty()) {
						Error = true;
						break;
					}else if(isReversed) {
						deque.pollLast();
					}else {
						deque.pollFirst();
					}
				}
			}
			
			if(Error) sb.append("error\n");
			else {
				sb.append("[");
				
				while(deque.size() > 1) {
					sb.append(poll()+",");
				}
				while(!deque.isEmpty()) sb.append(poll());
				sb.append("]\n");
			}
			deque.clear();
		}
		System.out.println(sb);
	}
	
	public static int poll() {
		if(isReversed) return deque.pollLast();
		return deque.pollFirst();
	}
}