import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        // 3 x 3 배열
        // 표준 입출력
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }            
        }
        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.println(arr[i][j]);
        //         System.out.print(arr[i][j]);
        //     }            
        //     System.out.println();
        // }
        // 매직스퀘어를 저장
        int[][][] ms = getMagicSquares();
        // 가장 적은 비용을 구해주기
        int minValue = Integer.MAX_VALUE; // 정수에서 최대값
        // int maxValue = Integer.MIN_VALUE;
        for (int[][] msArr : ms) {
            // arr과 같은 인덱스의 msArr과의 차이들의 절댓값을 더한 것이
            // 교체 비용
            int sumCost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Math.abs(...) 절대값으로 만들어주는 (부호 제거)...
                    int cost = Math.abs(arr[i][j] - msArr[i][j]);
                    // System.out.println(cost);
                    sumCost+=cost;
                }            
            }
            // System.out.println("cost" + sumCost);
            if (minValue > sumCost) {
                minValue = sumCost;
                // System.out.println(minValue);
            }
        }
        System.out.println(minValue);
    }

    public static int[][][] getMagicSquares() {
        // 기본 마방진
        int[][] base = {
            {8, 3, 4}, 
            {1, 5, 9},
            {6, 7, 2}
        };
        // 8가지의 종류 - 원본 (1) -> 90, 180, 270 (3)
        // 원본 -> 3번 꺾음(4) -> 좌우반전 (4+4) => 8
        int[][][] result = new int[8][3][3];
        result[0] = base; 
        for (int i = 1; i < 8; i++) {
            // i 1, 2, 3
            int[][] rotation = new int[3][3];
            // 회전이나 반전을 통해서 변형된 마방진을 저장할 공간
            if (i < 4) {
                // result[0], base -> 90, 180, 270...
                for(int j=0; j < 3; j++) {
                    // 이전 마방진
                    for (int k=0; k < 3; k++) {
                        // 원본 배열 j, k
                        // 변형시키려는 배열 k (열의 길이-1)-j
                        // 시계 방향으로 90도 회전
                        rotation[k][2-j] = result[i - 1][j][k];
                    }
                }
            } else {
                for(int j=0; j < 3; j++) {
                    // 이전 마방진
                    for (int k=0; k < 3; k++) {
                        // 원본 배열 j, k
                        // 변형시키려는 배열 j (열의 길이-1)-k
                        // 좌우 반전
                        rotation[j][2-k] = result[i - 4][j][k];
                    }
                }
            }
            result[i] = rotation;
            // for (int r = 0; r < 3; r++) {
            //     for (int c = 0; c < 3; c++) {
            //         System.out.print(rotation[r][c]);
            //     }            
            //     System.out.println();
            // }
            // System.out.println();
        }
        return result;
    }
}