class Solution {
    public int solution(int[] numbers, int target) {
        // 1. DFS 재귀 시작
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] arr, int target, int idx, int sum) {
        // 2. 하위노드 끝까지 간 경우, sum값이랑 target값 일치 비교
        if(idx == arr.length) {
            return sum == target ? 1 : 0;
        }
        
        // 3. 하위노드로 뻗어나가기 (+, -)방식으로 나뉨 => 모든 노드 탐색
        return dfs(arr, target, idx+1, sum+arr[idx])
            + dfs(arr, target, idx+1, sum-arr[idx]);
    }
}