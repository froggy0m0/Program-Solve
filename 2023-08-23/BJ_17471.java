import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isSelected;
    static int N;	
    static int[] popArr;
    static ArrayList<Integer>[] adjList;
    static int minValue = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        popArr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N+1; i++) popArr[i] = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++) adjList[i] = new ArrayList<>();
        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int inpLen = Integer.parseInt(st.nextToken());
            for(int j = 0; j < inpLen; j++) {
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        isSelected = new boolean[N+1];
        부분집합(1);
        System.out.println((minValue==Integer.MAX_VALUE)?-1 : minValue);
    }
    private static void 부분집합(int cnt) {
        if(cnt == N+1) {
        	int area1 = dfs(true);
        	int area2 = dfs(false);
            if(area1 + area2 == N && (area1 > 0 && area2 > 0) ) {    //모두 연결되어있다면
            	minValue = Math.min(minValue, getDiff());
            }
            return; 
        }

        isSelected[cnt] = true;
        부분집합(cnt+1);
        isSelected[cnt] = false;
        부분집합(cnt+1);

    }
    private static int getDiff() {
    	int area1Sum = 0;
    	int area2Sum = 0;
		for(int i = 0; i < isSelected.length; i++) {
			if(isSelected[i] == true) area1Sum += popArr[i];
			else area2Sum += popArr[i];
		}
		return Math.abs(area1Sum-area2Sum);
	}
	private static int dfs(boolean check) {
        int count = 0;
        boolean isVisited[] = new boolean[N+1];
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i < isSelected.length; i++) {
            if(isSelected[i] == check) {
                queue.add(i);
                count++;
                isVisited[i] = true;
                break;
            }
        }

        while(!queue.isEmpty()) {
            int pos = queue.poll();
            for(int v : adjList[pos]) {
                if(isVisited[v]) continue;
                if(isSelected[v] == check) {
                	count++;
                	queue.add(v);
                	isVisited[v] = true;
                }
            }
        }
        

        return count;
    }
}