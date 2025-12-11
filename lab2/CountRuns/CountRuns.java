import java.util.List;

public class CountRuns {

    /**
     * Count the number of runs in a list.
     * For example, countRuns([1, 2, 2, 2, 3]) = 1.
     * @param list is a list of integers.
     * @return the number of runs in list.
     */
    /*public static int countRuns(List<Integer> list) {
        int count = 0;

        for (int i = 0; i < list.size(); i++){
            int temp = 0;
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i).equals(list.get(j))){
                    temp += 1;
                }
                else{
                    break;
                }
            }
            if (temp > 0){
                count += 1;
                i += temp;
            }
        }

        return count;
    }*/
    public static int countRuns(List<Integer> list){
        int count = 0;

        for (int i = 0; i < list.size(); i++){
            int temp = 0;
            for (int j = i + 1; j < list.size(); j++){
                if(list.get(i).equals(list.get(j)))
                    temp += 1;
                else
                    break;
            }
            if(temp > 0){
                count++;
                i += temp;
            }
        }
        return count;
    }
}