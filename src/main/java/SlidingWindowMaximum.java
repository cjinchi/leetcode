import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(k==0 || nums.length==0) {
    		return new int[0];
    	}
    	int[] ret = new int[nums.length-k+1];
    	int index = 0;
    	PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return -Integer.compare(arg0, arg1);
			}
		});
    	for(int i = 0;i<k;i++) {
    		queue.add(nums[i]);
    	}

    	ret[index++] = queue.peek();
    	for(int i = k;i<nums.length;i++) {
    		queue.remove(nums[i-k]);
    		queue.add(nums[i]);
    		ret[index++] = queue.peek();
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
		int[] a = {1,3,-1,-3,5,3,6,7};
		for(int x:new SlidingWindowMaximum().maxSlidingWindow(a, 3)) {
			System.out.println(x);
		}
	}
    
}
