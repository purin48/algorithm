import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 누적 계수 탐색
        // 배열의 index를 값 자체로 활용해서 그 값이 몇 번 나오는지를 카운트하는 방법

        // 1. 배열 생성(1 ~ 10000 까지라서)
        int[] arr = new int[10001];

        // 2. 인덱스랑 일치하는 빈도 수 누적
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] += 1;
        }
        
        // 3. 정렬 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            while(arr[i] > 0) {
                sb.append(i).append("\n");
                arr[i] -= 1;
            }
        }
        System.out.println(sb);
    }
}