import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EvenAppend {

    /**
     * Append words that appear the 2nd, 4th, 6th, etc. time in a list.
     * For example, evenAppend(["a", "b", "b", "a", "a", "b", "b"]) → "bab".
     * @param list is a list of words.
     * @return a concatenation of even appearing words.
     */
    /*public static String evenAppend(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        int count = 0;
        String answer = "";

        for (String item : list){
            if (!map.containsKey(item)){
                map.put(item, 1);
            }

            else{
                count = map.get(item);

                // have not updated the value
                if (count % 2 == 1){
                    answer += item;
                }
                map.put(item, count + 1);
            }
        }

        return answer;
    }*/

    public static String evenAppend(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        int count = 0;
        for (String item: list){
            if(!map.containsKey(item))
                map.put(item, 1);

            else{
                count = map.get(item);

                if(count % 2 == 1){
                    ans += item;
                }

                map.put(item, count+1);
            }
        }

        return ans;
    }

}