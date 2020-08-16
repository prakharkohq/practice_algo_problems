package Random;

import java.util.Arrays;

public class LeftMostRepeatedCharacter {
    static int NO_OF_CHARS= 256;

    /* The function returns index of the first
    repeating character in a string. If
    all characters are repeating then
    returns -1 */
    static int firstRepeating(String str)
    {
        // Mark all characters as not visited
        boolean []visited = new boolean[NO_OF_CHARS];
        Arrays.fill(visited,false);

        // Traverse from right and update res as soon
        // as we see a visited character.
        int res = -1;
        for (int i = str.length() - 1; i >= 0; i--)
        {
            if (visited[str.charAt(i)] == false)
                visited[str.charAt(i)] = true;
            else
                res = i;
        }

        return res;
    }

    public static void main(String[] args)
    {
        String str = "abcd";
        int index = firstRepeating(str);
        if (index == -1)
            System.out.printf("Either all characters are "
                    +"distinct or string is empty");
        else
            System.out.printf("First Repeating character"
                            +" is %c",
                    str.charAt(index));
    }
}
