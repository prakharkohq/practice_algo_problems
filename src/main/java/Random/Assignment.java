package Random;

import java.util.Arrays;
import java.util.List;

public class Assignment {
    public static boolean checkInclusivenessOFTokens(String string1, String string2) {
        int len1 = string1.length(), len2 = string2.length();
        if (len1 > len2) return false;

        int[] flagsArray = new int[26];
        for (int i = 0; i < len1; i++) {
            flagsArray[string1.charAt(i) - 'a']++;
            flagsArray[string2.charAt(i) - 'a']--;
        }
        if (allMergePossibleInSinglePass(flagsArray)) return true;

        for (int i = len1; i < len2; i++) {
            flagsArray[string2.charAt(i) - 'a']--;
            flagsArray[string2.charAt(i - len1) - 'a']++;
            if (allMergePossibleInSinglePass(flagsArray)) return true;
        }

        return false;
    }

    private static  boolean allMergePossibleInSinglePass(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public static boolean checkMergesCodeVita(List<String> input ,String bigString)
    {
        for (String string:input)
        {
            if(!checkInclusivenessOFTokens(string,bigString))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Input
        List<String> list = Arrays.asList("god","is","so","hit");
        String bigString = "thisisgood";
        List<String> list2 = Arrays.asList("a","alloy","is","god","lamina");
        String bigString2 = "dogissoloyalanimal";
        System.out.println("Answer is "+checkMergesCodeVita(list,bigString));
        System.out.println("Answer is "+checkMergesCodeVita(list2,bigString2));
    }

}
