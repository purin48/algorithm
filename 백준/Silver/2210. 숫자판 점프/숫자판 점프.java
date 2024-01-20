import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 숫자판 입력
        int[][] board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        sc.close();
        // System.out.println(Arrays.deepToString(board));
        // 1. 모든 시작점에 대해 DFS 실행 (재귀 방식)
        // 시작점 (r,c) -> 6번의 탐색 depth. / 탐색의 결과 만들어지는 숫자 num
        for (int r = 0; r < 5; r++) {
             for (int c = 0; c < 5; c++) {
                dfsByRecursive(r, c, 0, 0, board);                    
            }   
        }
        // System.out.println(set);
        // System.out.println(set.size());
        
        // 2. 모든 시작점에 대해 DFS 실행 (스택 방식)
        for (int r = 0; r < 5; r++) {
             for (int c = 0; c < 5; c++) {
                dfsByStack(r, c, board);                    
            }   
        }
        // System.out.println(set);
        System.out.println(set.size());
    }

    // 1. DFS의 결과를 저장
    // 2. 중복을 걸러내기 위해
    static Set<Integer> set = new HashSet<>();
    
    // 재귀를 사용한 DFS 구현
    public static void dfsByRecursive(
        int r, int c, int depth, int num, int[][] board) {
        // 6자리 수 완성
        if (depth == 6) { // 재귀 종료 조건
            set.add(num);
            return;
        }
        // 제약조건을 어겼을 때. 경계 체크
        if (r < 0 || c < 0 || r == 5 || c == 5) {
            return;
        }
        // 상하좌우 이동
        int new_number = board[r][c]; // 현재 방문한 숫자 패드의 숫자
        dfsByRecursive(r + 1, c, depth + 1, num * 10 + new_number, board);      
        dfsByRecursive(r - 1, c, depth + 1, num * 10 + new_number, board);      
        dfsByRecursive(r, c + 1, depth + 1, num * 10 + new_number, board);      
        dfsByRecursive(r, c - 1, depth + 1, num * 10 + new_number, board);      
    }

    // 스택을 사용한 DFS 구현
    public static void dfsByStack(int r, int c, int[][] board) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{r, c, 0, 0});
        
        // stack이 빈 값이 아닐 때까지 반복
        while (!stack.isEmpty()) {
            int[] next = stack.pop();
            // 다음 방문할 위치 및 현재까지 만들어진 숫자 추출
            int nextR = next[0];
            int nextC = next[1];
            int depth = next[2];
            int num = next[3];
            // 6자리 수 완성 및 경계 체크
            if (depth == 6 || nextR < 0 || nextR == 5 || nextC < 0 || nextC == 5) {
                if (depth == 6) set.add(num);
                continue;
            }
            // 상하좌우 이동
            stack.push(new int[]{nextR + 1, nextC, depth + 1, num * 10 + board[nextR][nextC]});
            stack.push(new int[]{nextR - 1, nextC, depth + 1, num * 10 + board[nextR][nextC]});
            stack.push(new int[]{nextR, nextC + 1, depth + 1, num * 10 + board[nextR][nextC]});
            stack.push(new int[]{nextR, nextC - 1, depth + 1, num * 10 + board[nextR][nextC]});
        }
    }
}