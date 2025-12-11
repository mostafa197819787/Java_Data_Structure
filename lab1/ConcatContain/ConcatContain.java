public class ConcatContain {

    /**
     * Compute the smallest number of times source is concatenated with itself
     * so that the resulting string contains target.
     * For example, For example, source "ab" concatenated 2 times "ab"+"ab"+"ab" into "ababab"
     * contains target "baba".
     * @param source a non-empty string to be concatenated.
     * @param target a non-empty string that can be contained in repeatedly concatenated source.
     * @return the smallest number of times of the concatenation.
     */
    /*public static int concatContain(String source, String target) {
        int time;

        if (source.length() >= target.length()){
            if (source.contains(target))
                time = 0;

            else{
                source = source.concat(source);
                if (source.contains(target))
                    time = 1;
                else{
                    time = -1;
                }
            }
        }

        else{
            time = 0;
            String temple = source;

            while (source.length() < target.length()){
                source = source.concat(temple);
                time++;
            }

            while (source.length() <= target.length() * 2){
                if (source.contains(target))
                    return time;
                else {
                    source = source.concat(temple);
                    time++;
                }
            }

            time = -1;
        }

		return time;
    }*/

    public static int concatContain(String source, String target){
        int time;

        if (source.length() >= target.length()){
            if (source.contains(target))
                return 0;
            else{
                source = source.concat(source);
                if (source.contains(target))
                    return 1;
                else
                    return -1;
            }
        }

        else{
            time = 0;
            String temp = source;
            while (source.length() < target.length()){
                source = source.concat(temp);
                time++;
            }

            while (source.length() <= target.length() * 2){
                if (source.contains(target))
                    return time;
                else{
                    source = source.concat(temp);
                    time++;
                }
            }

            time = -1;
        }

        return time;
    }

    
}