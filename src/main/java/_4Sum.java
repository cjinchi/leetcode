import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        //sort
        Arrays.sort(nums);

        for (int i = 0;i<nums.length;i++){
            //for UNIQUE
            if (i>0&&nums[i-1]==nums[i]){
                continue;
            }

            for (int j = nums.length-1;j>=i+3;j--){
                //for UNIQUE
                if (j<nums.length-1&&nums[j+1]==nums[j]){
                    continue;
                }

                //with i and j,find another two nums
                int left = i+1;
                int right = j-1;
                while (left<right){
                    if (left>i+1&&nums[left]==nums[left-1]){
                        left++;
                        continue;
                    }
                    if (right<j-1&&nums[right]==nums[right+1]){
                        right--;
                        continue;
                    }

                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }else if(sum<target){
                        left++;
                    }else if (sum>target){
                        right--;
                    }
                }

            }
        }
        return result;

    }


}
