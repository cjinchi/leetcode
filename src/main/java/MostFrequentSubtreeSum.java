import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        getCount(root);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>max){
                list.clear();
                list.add(entry.getKey());
                max =  entry.getValue();
            }else if (entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val = node.val + getCount(node.left) + getCount(node.right);
        map.put(val,map.getOrDefault(val,0)+1);
        return val;
    }
}
