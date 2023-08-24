import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신성현_SWEA_1251_하나로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] xArr = new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				xArr[i] = Long.parseLong(st.nextToken());

			long[] yArr = new long[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				yArr[i] = Long.parseLong(st.nextToken());

			double E = Double.parseDouble(br.readLine());

			double[][] adjArr = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = i+1 ; j < N; j++) {
					adjArr[i][j] =adjArr[j][i]= (Math.abs(xArr[i]-xArr[j])*Math.abs(xArr[i]-xArr[j]) + Math.abs(yArr[i]-yArr[j])* Math.abs(yArr[i]-yArr[j]))*E;
				}
				
			}


			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];
			Arrays.fill(minEdge, Long.MAX_VALUE);
			minEdge[0] = 0;

			double result = 0;
			double min = 0; 
			int minVertex = 0;

			for (int c = 0; c < N; c++) {
				min = Double.MAX_VALUE;

				for (int i = 0; i < N; i++) {
					if (!visited[i] && min > minEdge[i]) {
						minVertex = i;
						min = minEdge[i];
					}
				}

				visited[minVertex] = true;
				result += min;

				for (int i = 0; i < N; i++) {
					if (!visited[i] && adjArr[minVertex][i] != 0 && minEdge[i] > adjArr[minVertex][i]) {
						minEdge[i] = adjArr[minVertex][i];
					}
				}
			}
			System.out.println("#" + tc + " " +Math.round(result));
//			System.out.println("#" + tc + " " +result);
		}
	}
}