import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int[][] apt = new int[K + 1][N]; // 배열 크기 조정 (0층부터 K층, 1호부터 N호)

            // 1. 0층의 각 호 초기화
            for (int n = 0; n < N; n++) {
                apt[0][n] = n + 1; // 0층의 n호에는 n+1명이 산다
            }

            // 2. 1호에는 항상 1명이 살고 있음
            for (int k = 1; k <= K; k++) {
                apt[k][0] = 1; // 모든 층의 1호는 1명
            }

            // 3. DP로 사람 수 계산
            for (int k = 1; k <= K; k++) {
                for (int n = 1; n < N; n++) {
                    apt[k][n] = apt[k - 1][n] + apt[k][n - 1];
                }
            }

            // 4. K층 N호 출력
            System.out.println(apt[K][N - 1]);
        }
    }
}
