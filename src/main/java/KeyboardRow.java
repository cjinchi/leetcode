import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String[] keyboard = new String[]{"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        for (int i = 0; i < keyboard.length; i++) {
            String line = keyboard[i];
            for (int j = 0; j < line.length(); j++) {
                map.put(line.charAt(j), i);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int lineNum = map.get(words[i].charAt(0));
            boolean isSame = true;
            for (int j = 1; j < words[i].length(); j++) {
                if (map.get(words[i].charAt(j)) != lineNum) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                result.add(words[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}
