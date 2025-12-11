import java.util.Locale;

public class CheckSubstring {
	
    /**
     * Check if at least n copies of a substring occur in input string.
     * They may overlap.
     * For example, checkSubstring("ababaxxxaba", "aba", 3) → true
     * @param input is the input string.
     * @param subs is the non-empty substring.
     * @param n is non-negative number of occurrences.
     * @return true iff at least n copies of subs occur in input.
     */
    /*public static boolean checkSubstring(String input, String subs, int n) {
        // base case
		if (input.length() < subs.length()){
            if (n > 0)
                return false;
            else
                return true;
        }

        // recursive step
		if (input.substring(0, subs.length()).equals(subs)){
            return checkSubstring(input.substring(1), subs, n - 1);
        }

        return checkSubstring(input.substring(1), subs, n);
    }*/

    /*public static boolean checkSubstring(String input, String subs, int n){
        if (input.length() < subs.length()){
            if (n != 0)
                return false;
            else
                return true;
        }

        else{
            if (input.startsWith(subs))
                return checkSubstring(input.substring(1), subs, n - 1);
            else
                return checkSubstring(input.substring(1), subs, n);
        }
    }*/

    public static String deleteVW(String word) {
        if (word.length() == 0 )
            return "";

        if (word.charAt(0) == 'V' || word.charAt(0) == 'W')
            return deleteVW(word.substring(1));
        else {
            return word.charAt(0) + deleteVW(word.substring(1));
        }
    }

    public static void main(String[] args) {
        String word = "aVW";
        System.out.println(deleteVW(word));

        String word2 = "PPVWVWPP";
        System.out.println(deleteVW(word2));

    }
}
