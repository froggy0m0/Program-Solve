import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BJ_17952 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> task = new Stack<>();
		int totalScore = 0;
		
		int taskScore = 0;
		int remainTime = 0;
		int[] inpTemp;
		for(int i = 0; i < N; i++) {
			inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(inpTemp.length == 1)	{
				if(!task.isEmpty()) {
					int[] taskInfo = task.pop();	
					taskScore = taskInfo[1];
					remainTime = taskInfo[2]-1;
					
					
					if(remainTime == 0) {
						totalScore += taskScore;
					}else {
						task.add(new int[] {1, taskScore, remainTime});
					}
					
					
				}else {
					continue;
				}
				
			}else {
				taskScore = inpTemp[1];
				remainTime = inpTemp[2]-1;	
				if(remainTime == 0) {
					totalScore += taskScore;
				}else {
					task.add(new int[] {1, taskScore, remainTime});
				}
			}
		}
		
		System.out.println(totalScore);
	}
}
