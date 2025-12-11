import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxStretch {

    /**
     * Find the largest stretch in a list.
     * For example, maxStretch([8, 5, 1, 2, 3, 4, 5, 10]) = 6.
     * @param list is a list of integers.
     * @return the largest stretch in list.
     */
    /*public static int maxStretch(List<Integer> list) {
        int max = 0;
        int temp = 0;
        if (list.size() == 0){
            return max;
        }
		else{
            for (int i = 0; i < list.size(); i++){
                for (int j = 0; j < list.size(); j++){
                    if (list.get(i).equals(list.get(j))){
                        temp = j + 1 - i;
                    }
                }
                if (temp > max){
                    max = temp;
                }
            }
            return max;
        }
    }*/

    public static int maxStretch(List<Integer> list){
        int max = 0;
        int temp = 0;
        if (list.size() == 0)
            return 0;

        else{
            for(int i = 0; i < list.size(); i++){
                for (int j = 0; j < list.size(); j++){
                    if (list.get(i).equals(list.get(j)))
                        temp = j + 1 - i;
                }
                if (temp > max)
                    max = temp;
            }
            return max;
        }
    }
}