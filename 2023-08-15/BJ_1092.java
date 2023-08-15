import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1092 {
	static Integer[] nArr;
	static List<Integer> mList = new ArrayList<>();
	static int t = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		nArr = new Integer[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nArr[i] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(nArr);
//		Arrays.sort(nArr, Collections.reverseOrder());	//크레인을 내림차순 정렬하고 찾으면 안됌
														//바로 아랫단계의 크레인이 처리할수도있는 화물을 윗단계가 처리한다면
														//다음 시간떄 아랫단계의 크레인이 놀고있을수가있다.
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			mList.add(Integer.parseInt(st.nextToken())); 
		}
		
		Collections.sort(mList);
		
		if(nArr[N-1] < mList.get(M-1)) {		//화물무게가 너무커서 못옮기면 -1
			System.out.println("-1");
			return;
		}
		
		//binary Search - Upperbound & Lowerbound
		while(!mList.isEmpty()) {		
			for(int v : nArr) {			//가장 작은무게를 들수있는 크레인부터 들수있는 최대의 화물을 옮긴다
				if(mList.size() < 1) break;
				int idx = Collections.binarySearch(mList, v);
				if(idx > -1 || idx == -1) {
					if(idx > -1) { //값을 찾았으면 remove
					mList.remove(idx);
					}
					//값을 찾거나 값이없으면 continue
					//idx 값이 -1 이나오는이유는 현재 v값 미만을 못찾을때
					// == 현재크레인으로 들수있는 화물이없는경우
					// === 다음단계의 크레인이 화물을 처리하기위해 continue;
					continue;
				}
				
				//target값이 없지만 바로밑의 인덱스를 계산헤서 제거 
				idx = (-1 * idx) - 2;
				mList.remove(idx);
			}
			//모든 종류의 크레인이 순회를 다하면 시간증감
			t++;
		}
		
		System.out.println(t);
	}
}
