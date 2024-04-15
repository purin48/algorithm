import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static int binarySearch(int[] arr, int target) {
        // 1. 중간 인덱스 구하기
        int left = 0;
        int right = arr.length - 1;

        // 2. 중간 인덱스의 값과 key값 비교
        // 3. 값이 중간값보다 작다면 왼쪽 부분 탐색 / 크면 오른쪽 부분 탐색 반복
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target == arr[mid]) {
                return 0;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // 0. 이분 탐색은 반드시 정렬이 되어있어야 함
        // 1. 중간 인덱스 구하기
        // 2. 중간 인덱스의 값과 key값 비교
        // 3. 값이 중간값보다 작다면 왼쪽 부분 탐색 / 크면 오른쪽 부분 탐색
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] NArr = new int[N];

        for (int i = 0; i < N; i++) {
            NArr[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        // 이진탐색 이전에 정렬부터 선행
        Arrays.sort(NArr);

        // M만큼 반복하여, 이진탐색
        for (int i=0; i<M; i++) {
            if(binarySearch(NArr, sc.nextInt()) >= 0) {
                sb.append(1).append("\n");
            }else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}