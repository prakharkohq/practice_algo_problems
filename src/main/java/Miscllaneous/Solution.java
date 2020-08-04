package Miscllaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solutioning {
    // expand in both directions of low and high to find all palindromes
    public static void expand(String str, int low, int high, Set<String> set)
    {
        // run till str[low.high] is a palindrome
        while (low >= 0 && high < str.length()
                && str.charAt(low) == str.charAt(high))
        {
            // push all palindromes into the set
            String temp = str.substring(low, high + 1);
            if (temp.length() > 1)
            set.add(temp);

            // expand in both directions
            low--;
            high++;
        }
    }

    // Function to find all unique palindromic substrings of given String
    public static void allPalindromicSubStrings(String str)
    {
        // create an empty set to store all unique palindromic substrings
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++)
        {
            // find all odd length palindrome with str[i] as mid point
            expand(str, i, i, set);

            // find all even length palindrome with str[i] and str[i+1]
            // as its mid points
            expand(str, i, i + 1, set);
        }

        // print all unique palindromic substrings
        List<String> impossible = new ArrayList<>();
        impossible.add("impossible");
        List<String> sortedList = new ArrayList<>(set);
        sortedList.sort((s1,s2)-> s2.length() - s1.length());
        List<String> firstThree = sortedList.stream().limit(3).collect(Collectors.toList());
        if (firstThree.size() < 3)
            System.out.println(impossible);
        else
        System.out.print(firstThree);
    }

    public static void main(String[] args) {
        allPalindromicSubStrings("student");
    }



    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=extractPalindrome(s,i,i);//odd length
            count+=extractPalindrome(s,i,i+1);//even length
        }
        return count;
    }
    public int extractPalindrome(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length()&& (s.charAt(left)==s.charAt(right))){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
