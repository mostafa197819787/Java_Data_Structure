public class DelDuplicate {
	
    /**
     * Remove adjacent duplicate characters in a string.
     * For example, delDuplicate("aaabbc") → "abc".
     * @param input is the input string.
     * @return the resulting string.
     */
    /*public static String delDuplicate(String input) {
        // base case
        if (input.length() == 0){
            return "";
        }

        // recursive step
        if (input.length() >= 2 && input.charAt(0) == input.charAt(1)){
            return delDuplicate(input.substring(1));
        }

        return input.charAt(0) + delDuplicate(input.substring(1));

    }*/

    public static String delDuplicate(String input) {
        if (input.length() == 0)
            return "";

        else{
            if (input.length() >= 2 && input.substring(0, 1).equals(input.substring(1, 2)))
                return delDuplicate(input.substring(1));
            else
                return input.charAt(0) + delDuplicate(input.substring(1));
        }
    }
}
