import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchSwap {

    /**
     * Modify a list of strings such that two strings with same
     * first letter are swapped.
     * For example, matchSwap(["ap", "bp", "cp", "aq", "cq", "bq"]) →
     * ["aq", "bq", "cq", "ap", "cp", "bp"].
     * @param list is a list of strings.
     * The strings are non-empty.
     * @return the modified list.
     */
    /*public static List<String> matchSwap(List<String> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++){
            map.put(i, 0);
        }

        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i).substring(0, 1).equals(list.get(j).substring(0, 1))){
                    if (map.get(i) != 1 && map.get(j) != 1){
                        String temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                        map.put(i, 1);
                        map.put(j, 1);
                        break;
                    }
                }
            }
        }

        return list;
    }*/

    public static List<String> matchSwap(List<String> list){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++){
            map.put(i ,0);
        }

        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i).substring(0, 1).equals(list.get(j).substring(0, 1))){
                    if (map.get(i) == 0 &&  map.get(j)== 0){
                        map.put(i, 1);
                        map.put(j, 1);
                        String temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                        break;
                    }
                }
            }
        }
        return list;
    }

}