import java.util.List;

public class Partitionable {

    /**
     * Decide whether a list is partitionable.
     * For example, isPartitionable([1, 1, 1, 2, 1]) -> true,
     * and isPartitionable([2, 1, 1, 2, 1]) -> false.
     * @param list is a non-empty list of integers.
     * @return true iff list is partitionable.
     */
    /*public static boolean isPartitionable(List<Integer> list) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < list.size(); i++){
            for (int k = i + 1; k < list.size(); k++){
                right += list.get(k);
            }
            for (int j = 0; j <= i; j++){
                left += list.get(j);
            }
            if (left == right)
                return true;
            else{
                left = 0;
                right = 0;
            }
        }
        return false;
    }*/

    public static boolean isPartitionable(List<Integer> list){
        int left = 0;
        int right = 0;

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < i; j++){
                left += list.get(j);
            }
            for (int k = i; k < list.size(); k++)
                right += list.get(k);

            if (left == right)
                return true;
            else{
                left = right = 0;
            }
        }
        return false;
    }
}