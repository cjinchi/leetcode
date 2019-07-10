import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Edge implements Comparable<Edge>{
	int src;
	int dst;
	int time;
	
	public Edge(int src,int dst,int time) {
		this.src = src;
		this.dst = dst;
		this.time = time;
	}

	@Override
	public int compareTo(Edge arg0) {
		return Integer.compare(this.time, arg0.time);
	}
}

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
    	List<Set<Edge>> edges = new ArrayList<>(N+1);
    	edges.add(null);
    	for(int i = 1;i<=N;i++) {
    		edges.add(new HashSet<>());
    	}
    	for(int[] time:times) {
    		edges.get(time[0]).add(new Edge(time[0], time[1], time[2]));
    	}
    	
    	Set<Integer> finished = new HashSet<>();
        Queue<Edge> fringe = new PriorityQueue<>();
        int maxNum = 0;
        
        finished.add(K);
        for(Edge edge:edges.get(K)) {
        	fringe.add(edge);
        }
        while(!fringe.isEmpty()) {
        	Edge edge = fringe.poll();
        	if(finished.contains(edge.dst)) {
        		continue;
        	}
        	maxNum = Math.max(maxNum, edge.time);
        	finished.add(edge.dst);
        	for(Edge edge2:edges.get(edge.dst)) {
        		fringe.add(new Edge(edge2.src,edge2.dst, edge2.time + edge.time));
        	}
        	
        }
        if(finished.size()!=N) {
        	return -1;
        }
        return maxNum;
        
    }
    
    public static void main(String[] args) {
		int[][] a = {{1,2,1}};
		System.out.println(new NetworkDelayTime().networkDelayTime(a, 2, 2));
	}
}
