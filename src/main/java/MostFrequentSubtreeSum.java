import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MostFrequentSubtreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    int maxOccurTime = 0;
    int numOfValWithMaxOccurTime = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        getCount(root);
        int[] result = new int[numOfValWithMaxOccurTime];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxOccurTime) {
                result[index] = entry.getKey();
                index++;
            }
        }
        return result;
    }

    public int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val = node.val + getCount(node.left) + getCount(node.right);
        int occurTime = map.getOrDefault(val, 0) + 1;
        map.put(val, occurTime);
        if (occurTime > maxOccurTime) {
            maxOccurTime = occurTime;
            numOfValWithMaxOccurTime = 1;
        } else if (occurTime == maxOccurTime) {
            numOfValWithMaxOccurTime++;
        }
        return val;
    }
}
