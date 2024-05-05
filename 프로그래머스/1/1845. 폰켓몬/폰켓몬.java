import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pkm = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            pkm.add(nums[i]);
        }
        return pkm.size() < (nums.length)/2 ? pkm.size() : (nums.length)/2;
    }
}