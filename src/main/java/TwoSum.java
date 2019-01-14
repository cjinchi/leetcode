//1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //index map from new to old
        int[] map = new int[nums.length];
        for(int i=0;i<map.length;i++){
            map[i] = i;
        }
        //sort
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;

                temp = map[i];
                map[i] = map[min];
                map[min] = temp;
            }
        }

        //find
        int left = 0, right = nums.length - 1;
        int sum = nums[left] + nums[right];
        while (sum != target) {
            if (sum > target) {
                right--;
            } else {
                left++;
            }
            sum = nums[left] + nums[right];
        }

        //return
        return new int[]{map[left], map[right]};
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        int[] nums = new int[]{-10,-1,-18,-19};
        for (int i : t.twoSum(nums, -19)) {
            System.out.println(i);
        }
    }
}
