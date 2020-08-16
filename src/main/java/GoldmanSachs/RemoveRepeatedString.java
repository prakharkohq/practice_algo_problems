package GoldmanSachs;

public class RemoveRepeatedString {
    /***
     * Keep a res as a characters stack.
     * Iterate characters of S one by one.
     *
     * If the next character is same as the last character in res,
     * pop the last character from res.
     * In this way, we remove a pair of adjacent duplicates characters.
     *
     * If the next character is different,
     * we append it to the end of res.
     *
     * ***/

    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaaaaaaabbbccccccc"));
    }

    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
