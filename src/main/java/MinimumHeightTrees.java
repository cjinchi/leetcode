import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
        	List<Integer> list = new ArrayList<>();
        	list.add(0);
        	return list;
        }else if(n==2) {
        	List<Integer> list = new ArrayList<>();
        	list.add(0);
        	list.add(1);
        	return list;
        }else {
        	List<Set<Integer>> graph = new ArrayList<>();
        	for(int i = 0;i<n;i++) {
        		graph.add(new HashSet<>());
        	}
        	for(int[] edge:edges) {
        		graph.get(edge[0]).add(edge[1]);
        		graph.get(edge[1]).add(edge[0]);
        	}
        	List<Integer> leaves = new ArrayList<>();
        	
        	for(int i = 0;i<n;i++) {
        		if(graph.get(i).size()==1) {
        			leaves.add(i);
        		}
        	}
        	while(n>2) {
        		n-=leaves.size();
        		List<Integer> newLeaves = new ArrayList<>();
        		for(int x:leaves) {
        			int father = graph.get(x).iterator().next();
        			graph.get(father).remove(x);
        			if(graph.get(father).size()==1) {
        				newLeaves.add(father);
        			}
        			
        		}
        		leaves = newLeaves;
        	}
        	return leaves;
        }
        
    }
    
    public static void main(String[] args) {
    	int[][] edges = {{0,1},{0,2},{0,3},{3,4},{4,5}};
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, edges));
	}
}
