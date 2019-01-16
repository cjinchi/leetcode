import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder builder = new StringBuilder();

//        [100ms]
//        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a,b)->{return b.getValue()-a.getValue();});
//        queue.addAll(map.entrySet());
//        while (!queue.isEmpty()){
//            Map.Entry<Character,Integer> entry = queue.poll();
//            for(int i=0;i<entry.getValue();i++){
//                builder.append(entry.getKey());
//            }
//        }

//        [33ms]
        List<Character>[] bucket = new List[s.length()+1];
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if (bucket[entry.getValue()]==null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        for(int i=bucket.length-1;i>=0;i--){
            if (bucket[i]!=null){
                for(char c:bucket[i]){
                    for(int j=0;j<i;j++){
                        builder.append(c);
                    }
                }
            }
        }

        return builder.toString();
    }
}
