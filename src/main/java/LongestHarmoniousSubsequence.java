import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		int max = 0;
		for(int num:nums) {
			if(!map.containsKey(num-1)) {
				continue;
			}
			max = Math.max(max, map.get(num)+map.get(num-1));
		}
		return max;
	}
}
