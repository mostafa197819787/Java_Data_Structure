import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SameFirstLetter {

    /**
     * Create a map with first letter as key and words with that same
     * first letter separated by comma.
     * For example, numWords(["alice", "bob", "apple", "banana"]) →
     * {"a": "alice,apple", "b": "bob,banana"}.
     * @param list is a list of strings.
     * The strings are non-empty.
     * @return a map with first letter and comma-separated-words pair.
     */
    /*public static Map<String, String> sameFirstLetter(List<String> list) {
        Map<String, String> map = new HashMap<>();

        for (String word : list){
            String item = word.substring(0, 1);
            if (!map.containsKey(item)){
                map.put(item, word);
            }
            else{
                String already = map.get(item);
                already = already + "," + word;
                map.put(item, already);
            }
        }

        return map;
    }*/

    public static Map<String, String> sameFirstLetter(List<String> list){
        Map<String, String> map = new HashMap<>();

        for (String item: list){
            String word = item.substring(0, 1);
            if (!map.containsKey(word)){
                map.put(word, item);
            }
            else{
                String word1 = map.get(word);
                word1 = word1 + "," + item;
                map.put(word, word1);
            }
        }
        return map;
    }

}