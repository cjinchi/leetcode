import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = 0,left = 0,right = 0;
        //[char:last visited index] map
        Map<Character,Integer> map = new HashMap<>();
        for(right = 0;right<s.length();right++){
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c)>=left){
                left = map.get(c)+1;
            }
            map.put(c,right);
            length = Math.max(length,right-left+1);
        }
        return length;
    }
}
