import java.util.Scanner;
 
public class SWEA_7510 {
    static int answer, N;
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            answer = 1;
            N = sc.nextInt();
            for (int i = 1; i <= N/2; i++) {
                func(i, 0);
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
 
    private static void func(int start, int result) {
        if (result > N)
            return;
        if (result == N) {
            answer = answer + 1;
            return;
        }
 
        func(start + 1, result + start);
    }
 
}