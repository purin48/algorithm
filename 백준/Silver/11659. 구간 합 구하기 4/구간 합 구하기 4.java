import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        arr[0] = 0;

        for(int i=0; i<N; i++) {
            arr[i + 1] = arr[i] + sc.nextInt(); // 누적합 배열 생성
        }

        // 누적합 방식
        // 예시 : [1,2,3,4,5] => 아예 누적된 합이 있는 배열 [1,3,6,10,15]
        // 만약 2 ~ 5까지의 합을 구한다면 ? [5번째 누적합인 15]에 [1까지의 누적합인 1]을 빼면 됨
        // 만약 2 ~ 4까지의 합은 ? [4번째 누적합인 10]에 [1까지의 누적합인 1]을 빼주면 됨
        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(arr[b] - arr[a-1]); // 구간 합 구해서 출력
        }
    }
}