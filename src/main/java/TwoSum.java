import java.util.HashMap;
import java.util.Map;

//1
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }else{
                map.put(nums[i],i);
            }
        }
        //never reach here
        return null;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = new int[]{-10,-1,-18,-19};
        for (int i : t.twoSum(nums, -19)) {
            System.out.println(i);
        }
    }
}
